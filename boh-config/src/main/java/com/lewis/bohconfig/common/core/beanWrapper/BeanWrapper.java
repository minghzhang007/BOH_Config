package com.lewis.bohconfig.common.core.beanWrapper;

import org.springframework.core.MethodParameter;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public interface BeanWrapper {
    /**
     * 支持性判断
     *
     * @param returnType
     * @return
     */
    boolean supportsType(MethodParameter returnType);

    /**
     * 对象包装
     *
     * @param bean
     * @return
     */
    Object wrap(Object bean);
}
