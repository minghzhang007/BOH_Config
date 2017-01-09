package com.lewis.bohconfig.common.core.beanWrapper;

import org.springframework.core.MethodParameter;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class DefaultBeanWrapper extends AbstractBeanWrapper {
    @Override
    public boolean supports(MethodParameter returnType) {
        return true;
    }

    public Object wrap(Object bean) {
        return new SuccessData(bean);
    }
}
