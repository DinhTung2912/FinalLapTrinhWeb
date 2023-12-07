package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.FeedbackDAO;
import com.example.finallaptrinhweb.model.Feedback;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/user/feedback")
public class FeedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String title = request.getParameter("text");
        String content = request.getParameter("form_fields[message]");

        // Tạo đối tượng Feedback
        Feedback feedback = new Feedback();
        feedback.setName(name);
        feedback.setEmail(email);
        feedback.setContent(content);
        feedback.setSubmissionDate(new Timestamp(new Date().getTime()));

        // Gọi DAO để thêm dữ liệu vào cơ sở dữ liệu
        boolean success = FeedbackDAO.addFeedback(feedback);

        // Xử lý kết quả
        if (success) {
            response.getWriter().println("Phản hồi của bạn đã được gửi thành công!");
        } else {
            response.getWriter().println("Có lỗi xảy ra khi gửi phản hồi. Vui lòng thử lại sau.");
        }

        // Chuyển hướng về trang contact.jsp
        request.getRequestDispatcher("./contact.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý yêu cầu GET nếu cần
        // Ví dụ: Hiển thị một trang form
        request.getRequestDispatcher("./contact.jsp").forward(request, response);
    }
}
