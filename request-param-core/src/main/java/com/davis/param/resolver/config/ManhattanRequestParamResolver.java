package com.davis.param.resolver.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.davis.param.resolver.annotation.ManhattanRequestParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author didi
 */
public class ManhattanRequestParamResolver implements HandlerMethodArgumentResolver {

    private static final String MANHATTAN_BIZ_PARAMS_KEY = "bizContent";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ManhattanRequestParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        // 1、得到 JSONRequestParam 注解信息并将其转换成用来记录注解信息的 JSONRequestParamNamedValueInfo 对象
        ManhattanRequestParam jsonRequestParam = parameter.getParameterAnnotation(ManhattanRequestParam.class);
        String paramName = StringUtils.isNotEmpty(jsonRequestParam.name()) ? jsonRequestParam.name() : parameter.getParameterName();

        // 2、获得 MANHATTAN_BIZ_PARAMS_KEY 字符串
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        String bizContentJsonText = servletRequest.getParameter(MANHATTAN_BIZ_PARAMS_KEY);
        if(StringUtils.isEmpty(bizContentJsonText)) {
            // todo error
        }

        // 3、将 bizContentJsonText 字符串转换JsonObject
        JSONObject bizContentJson = JSON.parseObject(bizContentJsonText);

        // 4、得到参数的 Class
        Class clazz = parameter.getParameterType();

        // 5、解析参数值
        JSONObject objectJson = bizContentJson.getJSONObject(paramName);
        if(jsonRequestParam.required() && objectJson == null) {

        }
        Object objectValue;

        if(objectJson != null) {
            // todo clazz 类中参数必须项的校验
            objectValue = JSON.parseObject(String.valueOf(objectJson), clazz);
            return objectValue;
        }

        objectValue = JSON.parseObject(String.valueOf(bizContentJson), clazz);


        return objectValue;
    }

}
