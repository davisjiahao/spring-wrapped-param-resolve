package com.davis.param.bean;

import lombok.Data;

@Data
public class GenericBean<T> extends BaseGenericBean<Integer> {
    private T genericData;
    private String dataString;
    private ExampleBean exampleBean;
}
