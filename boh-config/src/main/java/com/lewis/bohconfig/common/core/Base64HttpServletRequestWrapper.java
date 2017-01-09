package com.lewis.bohconfig.common.core;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class Base64HttpServletRequestWrapper extends HttpServletRequestWrapper {

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public Base64HttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getQueryString() {
        String queryString = super.getQueryString();
        if (StringUtils.isNotEmpty(queryString) && Base64.isBase64(queryString)) {
            try {
                return new String(Base64.decodeBase64(queryString),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return queryString;
    }
}
