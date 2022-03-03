//
//package com.bloodbank.filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebFilter(filterName = "webf",urlPatterns = {"/*"})
//public class MyFilter implements Filter{
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req=(HttpServletRequest) request;
//        HttpServletResponse resp=(HttpServletResponse) response;
//        String url=req.getRequestURI().toString();
//        System.out.println("\nURL-->"+url);
//        Object sessionobj=req.getSession().getAttribute("user");
//        if(url.contains(".")){
//            chain.doFilter(request, response);
//        }
//        else{
//            if(url.contains("/users")){
//                if(sessionobj==null){
//                    String u=req.getContextPath()+"/login.jsp";
//                    resp.sendRedirect(u);
//                }
//                else{
//                    
//                    resp.sendRedirect(req.getContextPath()+"/users/home.jsp");
//                }
//            }
//            else if(url.contains("/logout")){
//                chain.doFilter(request, response);
//            }
////            else if(sessionobj!=null){
////                resp.sendRedirect(req.getContextPath()+"/users/home.jsp");
////            }
//            else{
//                chain.doFilter(request, response);
//            }
//        }
//    }
//
//    @Override
//    public void destroy() {
//        
//    }
//    
//}
