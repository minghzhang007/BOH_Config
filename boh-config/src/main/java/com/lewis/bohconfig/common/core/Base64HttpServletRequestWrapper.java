package com.lewis.bohconfig.common.core;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class Base64HttpServletRequestWrapper extends HttpServletRequestWrapper {

    private boolean firstTime = true;

    private byte[] bytes;
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

    private void firstTime() throws IOException {
        firstTime = false;
        BufferedReader reader = super.getReader();
        StringBuilder sb = new StringBuilder();
        String line ;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        byte[] orignalBytes = sb.toString().getBytes("utf-8");
        if (Base64.isBase64(orignalBytes)) {
            bytes =Base64.decodeBase64(orignalBytes);
        }else{
            bytes = orignalBytes;
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        if (firstTime) {
            firstTime();
        }
        InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(bytes), "utf-8");
        return new BufferedReader(isr);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (firstTime) {
            firstTime();
        }
        ServletInputStream sis =new ServletInputStream(){
            private int i;
            @Override
            public int read() throws IOException {
                byte b;
                if (bytes.length > i)
                    b = bytes[i++];
                else
                    b = -1;

                return b;
            }
        };
        return sis;
    }
}
