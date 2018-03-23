package com.demo.transmission.plugin.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class IncomingInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(IncomingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        logger.info(">> Receiving " + request.getRequestURI() + "?" + request.getQueryString());
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String header = e.nextElement();
            logger.info(">>>> " + header + ": " + request.getHeader(header));
        }
        UserId.set(request.getHeader("X-User-Id"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) {
    }
}