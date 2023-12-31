package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.FeedbackDAO;
import com.example.finallaptrinhweb.model.Feedback;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet("/user/feedback")
public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String content = request.getParameter("form_fields[message]");


        // Kiểm tra dữ liệu đầu vào
        if (name == null || email == null || content == null || name.isEmpty() || email.isEmpty() || content.isEmpty()) {
            // Trường dữ liệu không hợp lệ, hiển thị thông báo lỗi
            request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin.");
        } else if (!isValidEmail(email)) {
            // Kiểm tra email có đúng định dạng không
            request.setAttribute("emailError", "Địa chỉ email không hợp lệ. Vui lòng nhập lại");
        } else if (content.length() < 10) {
            // Kiểm tra nội dung đóng góp có ít nhất 10 ký tự không
            request.setAttribute("contentError", "Nội dung đóng góp phải có ít nhất 10 ký tự.");
        } else {
            // Dữ liệu hợp lệ, tiếp tục xử lý
            Feedback feedback = new Feedback();
            feedback.setName(name);
            feedback.setEmail(email);
            feedback.setContent(content);
            feedback.setSubmissionDate(new Timestamp(new Date().getTime()));

            // Gọi DAO để thêm dữ liệu vào cơ sở dữ liệu
            boolean success = FeedbackDAO.addFeedback(feedback);

            // Xử lý kết quả
            if (success) {
                request.setAttribute("feedbackMessage", "Phản hồi của bạn đã được gửi thành công!");
            } else {
                request.setAttribute("errorMessage", "Có lỗi xảy ra khi gửi phản hồi. Vui lòng thử lại sau.");
            }
        }


        // Ví dụ: Hiển thị một trang form
        request.getRequestDispatcher("./contact.jsp").forward(request, response);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        // Lấy dữ liệu từ form

    }
}