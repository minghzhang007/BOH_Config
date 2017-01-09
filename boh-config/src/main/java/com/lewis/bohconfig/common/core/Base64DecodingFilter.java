package com.lewis.bohconfig.common.core;

import com.google.common.base.Splitter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class Base64DecodingFilter implements Filter {
    private PathMatcher matcher = new AntPathMatcher();
    private List<String> noDecodeList = new ArrayList();

    public void init(FilterConfig filterConfig) throws ServletException {
        String noDecode = filterConfig.getInitParameter("noDecode");
        noDecodeList  =Splitter.on(",").trimResults().splitToList(noDecode);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        if (ifContainsInNoDecodeList(req.getServletPath())) {
            chain.doFilter(req, resp);
        } else {
            Base64HttpServletRequestWrapper DecodingRequest = new Base64HttpServletRequestWrapper(req);
            chain.doFilter(DecodingRequest, resp);
        }
    }

    public void destroy() {

    }

    private boolean ifContainsInNoDecodeList(String servletPath) {
        boolean ret = false;
        if (noDecodeList.contains(servletPath)) {
            ret = true;
        } else if (!noDecodeList.isEmpty()) {
            for (String filtermapping : noDecodeList) {
                if (matcher.match(filtermapping,servletPath)) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }
}
