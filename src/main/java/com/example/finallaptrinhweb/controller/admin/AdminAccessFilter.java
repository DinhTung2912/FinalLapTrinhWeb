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
//        // Lấy đường dẫn yêu cầu
//        String requestURI = httpRequest.getRequestURI();
//
//        // Kiểm tra nếu đường dẫn bắt đầu bằng "/admin/"
//        if (requestURI.startsWith(httpRequest.getContextPath() + "/admin/")) {
//            // Kiểm tra xem người dùng đã đăng nhập hay chưa
//            HttpSession session = httpRequest.getSession();
//            User user = (session != null) ? (User) session.getAttribute("auth") : null;
//
//            if (user == null || user.getRoleId() != 2) {
//                // Người dùng chưa đăng nhập hoặc không có vai trò 2, chuyển hướng đến trang đăng nhập admin
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/user/signIn.jsp");
//                return;
//            } else {
//                // Người dùng đã đăng nhập và có vai trò 2, cho phép tiếp tục chuỗi filter
//                chain.doFilter(request, response);
//            }
//        } else {
//            // Cho phép tiếp tục chuỗi filter cho các URL khác
//            chain.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        // Không cần thực hiện gì đặc biệt khi filter bị hủy
//    }
//}
