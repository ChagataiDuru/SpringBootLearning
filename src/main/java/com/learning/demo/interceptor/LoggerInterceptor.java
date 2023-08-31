package com.learning.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        log.info("[preHandle][" + request + "]" + "[" + request.getMethod() + "]" + request.getRequestURI());
        return true;
    }

    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {
        log.info("[postHandle][" + request + "]");
    }

    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {
        if (ex != null)
            ex.printStackTrace();
        log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
    }
}