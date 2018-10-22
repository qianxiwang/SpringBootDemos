package com.demos.springbootdemos;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {

//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
////        登陆不做拦截
//
//        if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/login_view")) {
//            return true;
//        }
//        //验证session是否存在
//        Object object = request.getSession().getAttribute("session_user");
//
//        if (object == null) {
//            response.sendRedirect("/login_view");
//            return false;
//        }
//        return true;
//    }
}
