package com.example.finallaptrinhweb.controller.user_page;

import com.example.finallaptrinhweb.dao.ProductDAO;
import com.example.finallaptrinhweb.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/product")
public class ProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy ID sản phẩm từ request
        String idParameter = request.getParameter("id");

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                int productId = Integer.parseInt(idParameter);

                // Tạo một đối tượng ProductDAO
                ProductDAO productDAO = new ProductDAO();

                // Gọi phương thức getProductById để lấy chi tiết sản phẩm
                Product product = productDAO.getProductById(productId);

                // Sản phẩm tương tự
                List<Product> products = productDAO.getAllProductsLimited(0, 4);

                // Hình ảnh sản phẩm
                String folderUrl = getServletContext().getRealPath("data\\sp_") + idParameter;
                List<String> imgUrl = getImgUrl(folderUrl);

                if (product != null) {
                    // Đặt đối tượng Product vào request để hiển thị trên trang JSP
                    request.setAttribute("product", product);
                    request.setAttribute("products", products);
                    request.setAttribute("listImg", imgUrl);

                    // Chuyển hướng đến trang product-detail.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./product_detail.jsp");
                    dispatcher.forward(request, response);
                } else {
                    // Nếu không tìm thấy sản phẩm, hiển thị thông báo
                    response.getWriter().println("Product not found");
                }
            } catch (NumberFormatException e) {
                // Xử lý khi giá trị id không hợp lệ hoặc không thể chuyển đổi thành số nguyên
                response.getWriter().println("Invalid product ID");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Xử lý khi giá trị id là null hoặc rỗng
            response.getWriter().println("Product ID is missing");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Do nothing or add POST-specific logic if needed
        response.getWriter().println("POST method not allowed for this servlet");
    }

    private List<String> getImgUrl(String path) {
        List<String> imageFiles = new ArrayList<>();

        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            // Sử dụng FilenameFilter để lọc các file ảnh
            FilenameFilter imageFilter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    String lowercaseName = name.toLowerCase();
                    return lowercaseName.endsWith(".jpg") || lowercaseName.endsWith(".jpeg")
                            || lowercaseName.endsWith(".png") || lowercaseName.endsWith(".gif")
                            || lowercaseName.endsWith(".bmp");
                    // Thêm hoặc thay đổi các định dạng file ảnh khác nếu cần
                }
            };

            // Lấy danh sách các file trong thư mục sử dụng bộ lọc
            File[] files = folder.listFiles(imageFilter);

            // Thêm các đường dẫn file vào danh sách
            if (files != null) {
                for (File file : files) {
                    // Lấy đường dẫn từ "data" trở đi
                    String fullPath = file.getAbsolutePath();
                    int index = fullPath.indexOf("data");

                    if (index != -1) {
                        String resultPath = fullPath.substring(index);
                        imageFiles.add(resultPath);
                    }
                }
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc không phải là thư mục!");
        }

        return imageFiles;
    }

}
