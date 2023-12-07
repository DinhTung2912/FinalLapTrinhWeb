<%--
  Created by IntelliJ IDEA.
  User: DINHTUNG
  Date: 06/12/2023
  Time: 11:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="css/contact/contact.css">
    <link rel="stylesheet" href="css/HomePage/styles.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="icon" href="https://tienthangvet.vn/wp-content/uploads/cropped-favicon-Tien-Thang-Vet-192x192.png" sizes="192x192" />
    <link rel="stylesheet" href="css/header&footer.css" />
    <title>Liên hệ</title>
</head>

<body>
<div class="website-wrapper">
    <jsp:include page="header.jsp"/>
    <!-- Map Begin -->
    <div class="body">
        <div class="col-lg-12">
            <div class="map">
                <iframe
                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.258927212624!2d106.78567238152027!3d10.86790033428018!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x9672b7efd0893fc4!2zxJDhuqFpIEjhu41jIE7DtG5nIEzDom0!5e0!3m2!1svi!2s!4v1604126585524!5m2!1svi!2s"
                        height="500" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
            </div>
            <!-- Map End -->
            <!-- From Begin-->
            <div class="elementor-container">
                <div class="elementor-column1 elementor-col-50">
                    <div class="elementor-widget-wrap1">
                        <div class="elementor-element">
                            <div class="elementor-widget-container">
                                <h2 class="elementor-heading-titler">ĐÓNG GÓP Ý KIẾN</h2>
                            </div>
                        </div>
                        <div class="elementor-element elementor">
                            <div class="elementor-widget-container">
                                 <form class="elementor-form" method="post" action="${pageContext.request.contextPath}/user/feedback">
                                    <div class="elementor-field-type-text">
                                        <label for="form-name" class="elementor-label">
                                            Họ tên </label>
                                        <input size="1" type="text" name="name" id="form-name" class="elementor-field"
                                               placeholder="Họ tên" required="required" aria-required="true">
                                    </div>
                                    <div class="elementor-field-type-email">
                                        <label for="form-email" class="elementor-label">
                                            Email </label>
                                        <input size="1" type="email" name="email" id="form-email" class="elementor-field"
                                               placeholder="Email" required="required" aria-required="true">
                                    </div>
                                    <div class="elementor-field-type-textarea">
                                        <label for="form-message" class="elementor-label">
                                            Nội dung liên hệ </label>
                                        <textarea class="elementor-field-textual" name="form_fields[message]"
                                                  id="form-message" rows="4" placeholder="Nội dung liên hệ" required="required"
                                                  aria-required="true"></textarea>
                                    </div>
                                    <div class="elementor-field-group">
                                        <button type="submit" class="elementor-button">
                                        <span>
                                            <span class="elementor-button-icon">
                                            </span>
                                            <span class="elementor-button-text">Gửi</span>
                                        </span>
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="elementor-column1 elementor-col-50">
                    <div class="elementor-widget-wrap2">
                        <div class="elementor-element">
                            <div class="elementor-widget-container ">
                                <div class="title-wrapper">
                                    <div class="liner-continer">
                                        <h2 class="woodmart-title-container">THÔNG TIN LIÊN HỆ</h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <section class="wd-negative-gap">
                            <div class="elementor-container at">
                                <div class="elementor-column1 elementor-col-50">
                                    <div class="elementor-widget-wrapd">
                                        <div class="elementor-element">
                                            <div class="elementor-widget-container">
                                                <div class="info-box-wrapper">
                                                    <div class="wd-info-box">
                                                        <div class="info-box-content">
                                                            <div class="info-box-inner"
                                                                 data-elementor-setting-key="content">
                                                                <p><span style="color: #333333;"><strong>Địa
                                                                        chỉ:</strong></span> Khu phố 6, Linh Trung, Thủ
                                                                    Đức, TPHCM</p>
                                                                <p><span style="color: #333333;"><strong>Điện
                                                                        thoại:</strong></span> 0999 999 999</p>
                                                                <p><span
                                                                        style="color: #333333;"><strong>Email:</strong></span>
                                                                    doanwebnhom30@gmail.com</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="elementor-column1">
                                    <div class="elementor-widget-wrap">
                                        <div class="elementor-element">
                                            <div class="elementor-widget-container">
                                                <div class="info-box-wrapper">
                                                    <div class="wd-info-box ">
                                                        <div class="info-box-content">
                                                            <div class="info-box-inner ">
                                                                <p><b>THỜI GIAN LÀM VIỆC</b></p>
                                                                <p>Thứ 2 - Thứ 6: 08h00 - 17h00</p>
                                                                <p>Thứ bảy: Nghỉ</p>
                                                                <p>Chủ nhật: Nghỉ</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <div class="icon-infor d-flex px-5 py-5 my-3 border-top justify-content-center">
                            <a href="https://www.facebook.com/tienthangvetvn" class="icon-link"><span><i class="fab fa-facebook-f"></i></span></a>
                            <a href="https://twitter.com/i/flow/login?redirect_after_login=%2Ftienthangvet" class="icon-link"><span><i class="fab fa-twitter"></i></span></a>
                            <a href="https://www.instagram.com/tienthangvet/" class="icon-link"><span><i class="fab fa-instagram"></i></span></a>
                            <a href="https://www.youtube.com/channel/UCf7LpFLbwvD3hOXn8lVPHQA" class="icon-link"><span><i class="fab fa-youtube"></i></span></a>
                            <a href="https://www.pinterest.com/tienthangvet/" class="icon-link"><span><i class="fab fa-pinterest"></i></span></a>
                            <a href="link_linkedin" class="icon-link"><span><i class="fab fa-linkedin"></i></span></a>
                        </div>


                    </div>
                </div>

                <!-- Contact Form End -->
            </div>
        </div>

    </div>
    <jsp:include page="footer.jsp"/>



    <script>
        window.addEventListener('scroll', () => {
            var header = document.querySelector('.container')
            header.classList.toggle('sticky', window.scrollY > 100)
        })
    </script>
</div>
</body>

</html>
