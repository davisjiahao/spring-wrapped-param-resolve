package com.davis.param.controller;

import com.davis.param.bean.ExampleBean;
import com.davis.param.bean.GenericBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/app")
public class ApplicationController {

    /**
     * 测试1 3232323
     * 3232323232 323232
     * @param param1 234333 33333232323
     * wqwqwqwq              wqwqwqwqw
     * @param param2 2333
     *
     * @see int
     *
     * @param id
     * @see Integer
     * @param param3 3333
     * @see ExampleBean
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/test/{id}")
    public String example_1(@RequestBody Integer param1,
                            @RequestParam(name = "param_2", required = true) String param2,
                            @PathVariable(name = "id", required = true) Long id,
                            int param3) {
        return "example_1";
    }

    /**
     * 测试apidoc
     * @param bean
     * @param genericBean
     * @return
     */
    @PostMapping("/test2")
    public ExampleBean example22(ExampleBean bean, GenericBean<ExampleBean> genericBean) {
        return null;
    }


    /**
     * 测试3
     * @param listGenericBean
     * @return
     */
    @GetMapping("/test3")
    public List<GenericBean<ExampleBean>> example_3(ArrayList<GenericBean<ExampleBean>> listGenericBean, ExampleBean[] exampleBeanArray) {
        return null;
    }
}
