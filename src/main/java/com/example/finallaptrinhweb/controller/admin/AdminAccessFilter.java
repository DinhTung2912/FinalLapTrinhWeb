//package com.example.finallaptrinhweb.controller.admin;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import com.example.finallaptrinhweb.model.User;
//
//import java.io.IOException;
//
//@WebFilter(
//        filterName = "AdminAccessFilter",
//        urlPatterns = {"/admin/*"}
//)
//public class AdminAccessFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Không cần thực hiện gì đặc biệt khi filter được khởi tạo
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        // Kiểm tra nếu đường dẫn chứa "/admin/"
//        if (httpRequest.getRequestURI().startsWith(httpRequest.getContextPath() + "/admin/")) {
//            // Kiểm tra xem người dùng đã đăng nhập hay chưa
//            HttpSession session = httpRequest.getSession();
//            User user = (session != null) ? (User) session.getAttribute("auth") : null;
//
//            // Nếu đường dẫn không phải là trang đăng nhập và người dùng chưa đăng nhập, chuyển hướng đến trang đăng nhập admin
//            if (!httpRequest.getRequestURI().endsWith("/admin/signIn.jsp") && user == null) {
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin/signIn.jsp");
//                return;
//            }
//
//            // Nếu người dùng đã đăng nhập, chuyển hướng đến trang quản lý sau khi đăng nhập thành công
//            if (user != null) {
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin/dashboard");
//                return;
//            }
//        }
//
//        // Cho phép tiếp tục chuỗi filter cho các URL khác
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // Không cần thực hiện gì đặc biệt khi filter bị hủy
//    }
//}