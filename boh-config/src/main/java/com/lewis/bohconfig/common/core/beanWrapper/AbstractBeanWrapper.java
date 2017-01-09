package com.lewis.bohconfig.common.core.beanWrapper;

import org.springframework.core.MethodParameter;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public abstract class AbstractBeanWrapper implements BeanWrapper {

    public boolean supportsType(MethodParameter returnType) {
        if (ResponseData.class.isAssignableFrom(returnType.getParameterType())) {
            return false;
        }
        return supports(returnType);
    }

    public abstract boolean supports(MethodParameter returnType);
}
