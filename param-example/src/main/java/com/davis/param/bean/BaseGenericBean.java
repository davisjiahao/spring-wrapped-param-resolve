package com.davis.param.bean;

import lombok.Data;

@Data
public class BaseGenericBean<T> {
    private T baseGenericData;
}
