package com.lewis.bohconfig.common.core;

import com.lewis.bohconfig.common.enumer.Json;
import com.lewis.bohconfig.common.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class JsonArgumentsResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Json.class);
    }

    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory binderFactory) throws Exception {
        try {
            Class<?> parameterType = methodParameter.getParameterType();
            String requestParam = getAllRequestParams(nativeWebRequest);
            if (parameterType != null && StringUtils.isNotEmpty(requestParam)) {
                Object o = JsonUtil.toBean(requestParam, parameterType);
                return o;
            }
            System.out.println(requestParam);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private String getAllRequestParams(NativeWebRequest nativeWebRequest) throws IOException {
        String requestParam = null;
        HttpServletRequest httpServletRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String method = httpServletRequest.getMethod();
        if ("GET".equalsIgnoreCase(method) || "DELETE".equalsIgnoreCase(method)) {
            requestParam = httpServletRequest.getQueryString();
        } else {
            StringBuilder buffer = new StringBuilder();
            String line;
            BufferedReader reader = httpServletRequest.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            requestParam = buffer.toString();
        }
        return requestParam;
    }
}
