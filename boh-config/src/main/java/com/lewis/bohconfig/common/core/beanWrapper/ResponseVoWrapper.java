package com.lewis.bohconfig.common.core.beanWrapper;

import com.lewis.bohconfig.common.domain.ResponseVo;
import org.springframework.core.MethodParameter;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class ResponseVoWrapper extends AbstractBeanWrapper {
    @Override
    public boolean supports(MethodParameter returnType) {
        return ResponseVo.class.isAssignableFrom(returnType.getParameterType());
    }

    public Object wrap(Object bean) {
        return (ResponseVo)bean;
    }
}
