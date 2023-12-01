<%--
  Created by IntelliJ IDEA.
  User: DINHTUNG
  Date: 01/12/2023
  Time: 3:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.finallaptrinhweb.model.Product" %>
<%@ page import="com.example.finallaptrinhweb.dao.ProductDAO" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.finallaptrinhweb.controller.user_page.ProductDetailsServlet" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/css/header&footer.css" />
    <link rel="stylesheet" href="css/products/detailproduct.css" />

    <link rel="icon" href="https://tienthangvet.vn/wp-content/uploads/cropped-favicon-Tien-Thang-Vet-192x192.png"
          sizes="192x192" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Chi tiết sản phẩm</title>
</head>

<body>
<div class="website-wrapper">
    <jsp:include page="header.jsp"/>

    <div class="body">
        <div class="wrapper-content">
            <div class="content">
                <div class="single-breadcrumbs-wrapper">
                    <div class="container">
                        <div class="wd-breadcrumbs">
                            <nav class="woocommerce-breadcrumb">
                                <a href="" class="breadcrumb-link">
                                    Trang chủ
                                </a>
                                <a href="" class="breadcrumb-link">
                                    Sản phẩm
                                </a>
                                <a href="" class="breadcrumb-link breadcrumb-link-last">
                                    Thuốc thú y
                                </a>
                                <span class="breadcrumb-last">
                                        Dipomax-J | Trị viêm da, nấm da, triệu chứng viêm da cấp
                                        trên chó mèo
                                    </span>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="product-images">
                        <div class="product-images-inner">
                            <div class="col-12">
                                <div class="owl-stage">
                                    <div class="item" style="width: 575px; height: 575px">
                                        <div class="product-image-wrap">
                                            <img src="https://tienthangvet.vn/wp-content/uploads/Dipomax-J.jpg"
                                                 class="wp-post-image wp-post-image" />
                                        </div>
                                    </div>
                                    <div class="product-additional-galleries">
                                        <a id="see-more"
                                           href="https://tienthangvet.vn/wp-content/uploads/Dipomax-J.jpg"
                                           class="woodmart-show-product-gallery">
                                            <i class="fa-solid fa-compress"></i>
                                            <span class="see-more">Click to enlarge</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="owl-stage-outer" style="margin-top: 10px">
                                    <div class="owl-stage">
                                        <div class="item" style="width: 145.25px">
                                            <div class="product-image-thumbnail">
                                                <img width="150" height="150"
                                                     src="https://tienthangvet.vn/wp-content/uploads/Dipomax-J.jpg" />
                                            </div>
                                        </div>
                                        <div class="item" style="width: 145.25px">
                                            <div class="product-image-thumbnail">
                                                <img width="150" height="150"
                                                     src="https://tienthangvet.vn/wp-content/uploads/Dipomax-J.jpg" />
                                            </div>
                                        </div>
                                        <div class="item" style="width: 145.25px">
                                            <div class="product-image-thumbnail">
                                                <img width="150" height="150"
                                                     src="https://tienthangvet.vn/wp-content/uploads/Dipomax-J2.jpg" />
                                            </div>
                                        </div>
                                        <div class="item" style="width: 145.25px">
                                            <div class="product-image-thumbnail">
                                                <img width="150" height="150"
                                                     src="https://tienthangvet.vn/wp-content/uploads/Dipomax-J1.jpg" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="detail-product">
                        <div class="summary-inner set-mb-l reset-last-child">
                            <div class="wd-product-brands">
                                <a href="">
                                    <img src="https://tienthangvet.vn/wp-content/uploads/logo-APA.jpg" title="APA"
                                         alt="APA" />
                                </a>
                            </div>
                            <h1 class="product_title entry-title wd-entities-title">
                                Dipomax-J | Trị viêm da, nấm da, triệu chứng viêm da cấp
                                trên chó mèo
                            </h1>
                            <div class="price-wrapper">
                                <div class="unit">₫</div>
                                <div class="price">129.000</div>
                            </div>
                            <div
                                    class="wd-compare-btn product-compare-button wd-action-btn wd-style-text wd-compare-icon">
                                <a href="">
                                    <i class="fa-solid fa-shuffle"></i>
                                    <span>So sánh</span>
                                </a>
                            </div>
                            <div class="wd-wishlist-btn wd-action-btn wd-style-text wd-wishlist-icon">
                                <a class="" href="">
                                    <i class="fa-regular fa-heart"></i>
                                    <span>Yêu thích</span>
                                </a>
                            </div>
                            <div class="product_meta">
                                    <span class="posted_in"><span class="meta-label">Danh mục:</span>
                                        <a href="" rel="tag">Thuốc
                                            thú y</a></span>
                            </div>
                            <div class="container">
                                <button class="add-to-cart-button">
                                    <svg class="add-to-cart-box box-1" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <rect width="24" height="24" rx="2" fill="#ffffff" />
                                    </svg>
                                    <svg class="add-to-cart-box box-2" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <rect width="24" height="24" rx="2" fill="#ffffff" />
                                    </svg>
                                    <svg class="cart-icon" xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                         viewBox="0 0 24 24" fill="none" stroke="#ffffff" stroke-width="2"
                                         stroke-linecap="round" stroke-linejoin="round">
                                        <circle cx="9" cy="21" r="1"></circle>
                                        <circle cx="20" cy="21" r="1"></circle>
                                        <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6">
                                        </path>
                                    </svg>
                                    <svg class="tick" xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                         viewBox="0 0 24 24">
                                        <path fill="none" d="M0 0h24v24H0V0z" />
                                        <path fill="#ffffff"
                                              d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zM9.29 16.29L5.7 12.7c-.39-.39-.39-1.02 0-1.41.39-.39 1.02-.39 1.41 0L10 14.17l6.88-6.88c.39-.39 1.02-.39 1.41 0 .39.39.39 1.02 0 1.41l-7.59 7.59c-.38.39-1.02.39-1.41 0z" />
                                    </svg>
                                    <span class="add-to-cart">Thêm vào giỏ hàng</span>
                                    <span class="added-to-cart">Đã thêm</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="wrapper-content">
            <div class="product-tabs-wrapper">
                <div class="container">
                    <div class="poduct-tabs-inner">
                        <div class="woocommerce-tabs wc-tabs-wrapper tabs-layout-tabs" data-state="first"
                             data-layout="tabs">
                            <div class="wd-nav-wrapper wd-nav-tabs-wrapper text-center">
                                <ul class="wd-nav wd-nav-tabs wd-icon-pos-left tabs wc-tabs wd-style-underline-reverse"
                                    role="tablist">
                                    <li class="description_tab active" id="tab-title-description" role="tab"
                                        aria-controls="tab-description">
                                        <a class="wd-nav-link" href="#tab-description">
                                                <span class="nav-link-text wd-tabs-title">
                                                    Mô tả
                                                </span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="wd-accordion-item">
                                <div class="entry-content woocommerce-Tabs-panel woocommerce-Tabs-panel--description wd-active panel wc-tab"
                                     id="tab-description" role="tabpanel" aria-labelledby="tab-title-description"
                                     data-accordion-index="description" style="display: block">
                                    <div class="wc-tab-inner">
                                        <div data-elementor-type="product-post" data-elementor-id="37778"
                                             class="elementor elementor-37778">
                                            <section
                                                    class="wd-negative-gap elementor-section elementor-top-section elementor-element elementor-element-493d2218 elementor-section-boxed elementor-section-height-default elementor-section-height-default wd-section-disabled"
                                                    data-id="493d2218" data-element_type="section">
                                                <div class="elementor-container elementor-column-gap-default">
                                                    <div class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-56ddef75"
                                                         data-id="56ddef75" data-element_type="column">
                                                        <div
                                                                class="elementor-widget-wrap elementor-element-populated">
                                                            <div class="elementor-element elementor-element-1400a071 color-scheme-inherit text-left elementor-widget elementor-widget-text-editor"
                                                                 data-id="1400a071" data-element_type="widget"
                                                                 data-widget_type="text-editor.default">
                                                                <div class="elementor-widget-container">
                                                                    <p>
                                                                        DIPROMAX-J là sản phẩm điều trị viêm da
                                                                        Tiết Bã Do Vi Khuẩn (Staphylococcus
                                                                        Pseudintermedius),&nbsp; Nấm Men
                                                                        (Malassezia Pachydermatis) Và Nấm Ngoài
                                                                        Da (Dermatophytosis). các triệu chứng
                                                                        viêm da cấp trên chó mèo.
                                                                    </p>
                                                                    <h1>Thành phần: 1g Dipomax-J chứa</h1>
                                                                    <p>
                                                                        Betamethasone Dipropionate:….0,64
                                                                        mg<br />Gentamicin
                                                                        Sulfate:……………………1,0
                                                                        mg<br />Clotrimazole:……………………………10,0
                                                                        mg<br />Tá dược vừa đủ:……………………………..1 g
                                                                    </p>
                                                                    <h2>Hướng dẫn sử dụng:</h2>
                                                                    <p>
                                                                        Liều lượng sử dụng tùy thuộc vào mức độ
                                                                        vùng da bị bệnh.
                                                                    </p>
                                                                    <p>
                                                                        ► Bôi kem vào vùng da bị bệnh, nên cắt
                                                                        tỉa lông trước khi thoa thuốc.<br />►
                                                                        Liều lượng sử dụng tùy thuộc vào mức độ
                                                                        vùng da bị bệnh.<br />► Thoa 2 lần/ngày
                                                                        (sáng &amp; tối) cho đến khi hết các
                                                                        triệu chứng viêm da, nấm da (tối đa 2 –
                                                                        4 tuần).<br />► Lặp lại nếu cần thiết
                                                                        sau 20 ngày.
                                                                    </p>
                                                                    <h2>Dạng bào chế: Kem bôi ngoài da</h2>
                                                                    <h2>CHỐNG CHỈ ĐỊNH:</h2>
                                                                    <p>
                                                                        – Không để thuốc dính vào mắt hoặc bôi
                                                                        lên vết thương hở.<br />– Không dùng cho
                                                                        vật nuôi quá mẫn cảm với bất kỳ thành
                                                                        phần nào của thuốc.
                                                                    </p>
                                                                    <h2>
                                                                        BẢO QUẢN<br />– Bảo quản nơi khô ráo,
                                                                        thoáng mát, tránh ánh sáng trực tiếp.<br />–
                                                                        Bảo quản ở nhiệt độ phòng, dưới 30oC.
                                                                    </h2>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </section>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="wrapper-content">
            <div class="container related-and-upsells">
                <div class="related-products">
                    <h3 class="title slider-title">Sản phẩm tương tự</h3>
                    <div class="products">
                        <div class="wrapper-container">
                            <div class="container">
                                <div class="item">
                                    <div>
                                        <div class="product-element-top">
                                            <a href="detail-product.html">
                                                <img src="https://tienthangvet.vn/wp-content/uploads/nutrimaxplus-bo-sung-vitamin-khoang-cho-thu-cung.jpg"
                                                     alt="">
                                            </a>
                                        </div>
                                        <div class="product-element-bottom">
                                            <a href="detail-product.html">
                                                Nutrimax-plus | gel dinh dưỡng bổ sung vitamin, khoáng
                                                dành cho chó mèo
                                            </a>
                                        </div>
                                        <div class="product-element">
                                            <div class="price-wrap">
                                                <div class="unit">₫</div>
                                                <div class="price">134.000</div>
                                            </div>
                                            <div class="rating">
                                                <div class="stars" data-stars="4">
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star-half-stroke"></i>
                                                    <i class="fa-regular fa-star"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="wd-buttons wd-pos-r-t">
                                        <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon">
                                            <a href="" class="button product_type_simple add-to-cart-loop"
                                               aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                                                    <span>
                                                        <i class="fa-solid fa-cart-shopping"></i> </span></a>
                                        </div>
                                        <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                                            <a href="" class="open-quick-view quick-view-button">
                                                    <span>
                                                        <i class="fa-solid fa-magnifying-glass"></i> </span></a>
                                        </div>
                                        <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                                            <a class="wd-tltp wd-tooltip-inited" href=""
                                               data-added-text="Browse Wishlist">
                                                    <span class="wd-tooltip-label">
                                                        <i class="fa-regular fa-heart"></i> </span></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div>
                                        <div class="product-element-top">
                                            <a href="detail-product.html">
                                                <img src="https://tienthangvet.vn/wp-content/uploads/Nokodemaseb-dieu-tri-cac-trieu-chung-do-nam-gay-ra.jpg"
                                                     alt="">
                                            </a>
                                        </div>
                                        <div class="product-element-bottom">
                                            <a href="detail-product.html">
                                                Nokodermaseb | Dung dịch kháng khuẩn và điều trị nấm dạng
                                                xịt
                                            </a>
                                        </div>
                                        <div class="product-element">
                                            <div class="price-wrap">
                                                <div class="unit">₫</div>
                                                <div class="price">134.000</div>
                                            </div>
                                            <div class="rating">
                                                <div class="stars" data-stars="4">
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star-half-stroke"></i>
                                                    <i class="fa-regular fa-star"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="wd-buttons wd-pos-r-t">
                                        <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon">
                                            <a href="" class="button product_type_simple add-to-cart-loop"
                                               aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                                                    <span>
                                                        <i class="fa-solid fa-cart-shopping"></i> </span></a>
                                        </div>
                                        <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                                            <a href="" class="open-quick-view quick-view-button">
                                                    <span>
                                                        <i class="fa-solid fa-magnifying-glass"></i> </span></a>
                                        </div>
                                        <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                                            <a class="wd-tltp wd-tooltip-inited" href=""
                                               data-added-text="Browse Wishlist">
                                                    <span class="wd-tooltip-label">
                                                        <i class="fa-regular fa-heart"></i> </span></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div>
                                        <div class="product-element-top">
                                            <a href="detail-product.html">
                                                <img src="https://tienthangvet.vn/wp-content/uploads/APM-1.jpg"
                                                     alt="">
                                            </a>
                                        </div>
                                        <div class="product-element-bottom">
                                            <a href="detail-product.html">
                                                Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine
                                            </a>
                                        </div>
                                        <div class="product-element">
                                            <div class="price-wrap">
                                                <div class="unit">₫</div>
                                                <div class="price">134.000</div>
                                            </div>
                                            <div class="rating">
                                                <div class="stars" data-stars="4">
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star-half-stroke"></i>
                                                    <i class="fa-regular fa-star"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="wd-buttons wd-pos-r-t">
                                        <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon">
                                            <a href="" class="button product_type_simple add-to-cart-loop"
                                               aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                                                    <span>
                                                        <i class="fa-solid fa-cart-shopping"></i> </span></a>
                                        </div>
                                        <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                                            <a href="" class="open-quick-view quick-view-button">
                                                    <span>
                                                        <i class="fa-solid fa-magnifying-glass"></i> </span></a>
                                        </div>
                                        <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                                            <a class="wd-tltp wd-tooltip-inited" href=""
                                               data-added-text="Browse Wishlist">
                                                    <span class="wd-tooltip-label">
                                                        <i class="fa-regular fa-heart"></i> </span></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div>
                                        <div class="product-element-top">
                                            <a href="detail-product.html">
                                                <img src="https://tienthangvet.vn/wp-content/uploads/Tukono.jpg"
                                                     alt="">
                                            </a>
                                        </div>
                                        <div class="product-element-bottom">
                                            <a href="detail-product.html">
                                                TUKONO – Thuốc nhỏ tai trị viêm tai ngoài cho thú cưng
                                            </a>
                                        </div>
                                        <div class="product-element">
                                            <div class="price-wrap">
                                                <div class="unit">₫</div>
                                                <div class="price">134.000</div>
                                            </div>
                                            <div class="rating">
                                                <div class="stars" data-stars="4">
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star"></i>
                                                    <i class="fa-solid fa-star-half-stroke"></i>
                                                    <i class="fa-regular fa-star"></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="wd-buttons wd-pos-r-t">
                                        <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon">
                                            <a href="" class="button product_type_simple add-to-cart-loop"
                                               aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                                                    <span>
                                                        <i class="fa-solid fa-cart-shopping"></i> </span></a>
                                        </div>
                                        <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                                            <a href="" class="open-quick-view quick-view-button">
                                                    <span>
                                                        <i class="fa-solid fa-magnifying-glass"></i> </span></a>
                                        </div>
                                        <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                                            <a class="wd-tltp wd-tooltip-inited" href=""
                                               data-added-text="Browse Wishlist">
                                                    <span class="wd-tooltip-label">
                                                        <i class="fa-regular fa-heart"></i> </span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</div>

<script src="js/detailProduct/scripts.js"></script>
</body>

</html>