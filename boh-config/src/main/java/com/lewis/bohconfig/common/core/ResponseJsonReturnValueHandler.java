package com.lewis.bohconfig.common.core;

import com.lewis.bohconfig.common.core.beanWrapper.BeanWrapper;
import com.lewis.bohconfig.common.domain.ResponseVo;
import com.lewis.bohconfig.common.enumer.ResponseJson;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class ResponseJsonReturnValueHandler implements HandlerMethodReturnValueHandler {
    private HttpMessageConverter httpMessageConverter;
    private List<BeanWrapper> beanWrappers;

    public boolean supportsReturnType(MethodParameter returnType) {
        return returnType.getMethodAnnotation(ResponseJson.class) != null;
    }

    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        mavContainer.setRequestHandled(true);
        ResponseVo responseVo = null;
        if (!(returnValue instanceof ResponseVo)) {
            responseVo = new ResponseVo();
            responseVo.setData(returnValue);
            responseVo.setMsg("OK");
            responseVo.setSuccess(true);
            responseVo.setErrorCode(0);
        }else {
            responseVo = (ResponseVo)returnValue;
        }
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        response.setHeader("Access-Control-Allow-Origin","*");
        ServletServerHttpResponse outputMessage = new ServletServerHttpResponse(response);
        MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, Collections.singletonMap("charset", "utf-8"));
        httpMessageConverter.write(responseVo, mediaType,outputMessage);
    }

    public HttpMessageConverter getHttpMessageConverter() {
        return httpMessageConverter;
    }

    public void setHttpMessageConverter(HttpMessageConverter httpMessageConverter) {
        this.httpMessageConverter = httpMessageConverter;
    }

    public List<BeanWrapper> getBeanWrappers() {
        return beanWrappers;
    }

    public void setBeanWrappers(List<BeanWrapper> beanWrappers) {
        this.beanWrappers = beanWrappers;
    }
}
