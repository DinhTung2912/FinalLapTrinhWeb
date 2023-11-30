<%--
  Created by IntelliJ IDEA.
  User: DINHTUNG
  Date: 30/11/2023
  Time: 8:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.finallaptrinhweb.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <link rel="stylesheet" href="/css/header&footer.css" />
  <link rel="stylesheet" href="css/products/styles.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="icon" href="https://tienthangvet.vn/wp-content/uploads/cropped-favicon-Tien-Thang-Vet-192x192.png"
        sizes="192x192" />
  <title>Sản phẩm</title>
</head>

<body>
<div class="website-wrapper">
  <jsp:include page="header.jsp"/>

  <div class="body">
    <div class="page-title" style="
            background-image: url(https://tienthangvet.vn/wp-content/uploads/title-tag-tien-thang-vet-tsd1.jpg);
          ">
      <div class="container">
        <h1 class="title">Sản phẩm</h1>
      </div>
    </div>

    <div class="container">
      <div class="columns">
        <aside class="sidebar">
          <div class="widget-area">
            <div id="categories-1" class="widget">
              <span class="widget-title">Danh mục sản phẩm</span>
              <ul class="product-categories">
                <li class="item"><a href="">Vắc xin</a></li>
                <li class="item"><a href="">Kháng sinh</a></li>
                <li class="item"><a href="">Sát trùng</a></li>
                <li class="item"><a href="">Hooc môn</a></li>
                <li class="item"><a href="">Dinh dưỡng</a></li>
                <li class="item"><a href="">Dầu tắm</a></li>
              </ul>
            </div>
            <div id="categories-2" class="widget">
              <span class="widget-title">Lọc theo đối tượng</span>
              <ul
                      class="wd-swatches-filter wd-filter-list wd-labels-on wd-size-normal wd-layout-list wd-text-style-1 wd-bg-style-4 wd-shape-round wd-scroll-content">
                <li class="wc-layered-nav-term wd-swatch-wrap">
                  <a rel="nofollow noopener" href="" class="layered-nav-link"><span class="wd-swatch wd-bg"><span
                          class="wd-swatch-bg"><img
                          src="https://tienthangvet.vn/wp-content/uploads/icon-thuoc-thu-y-cho-cho.jpg"
                          alt="Swatch image" /></span></span><span
                          class="wd-filter-lable layer-term-lable">Chó</span></a>
                  <span class="count">55</span>
                </li>
                <li class="wc-layered-nav-term wd-swatch-wrap">
                  <a rel="nofollow noopener" href="" class="layered-nav-link"><span class="wd-swatch wd-bg"><span
                          class="wd-swatch-bg"><img
                          src="https://tienthangvet.vn/wp-content/uploads/icon-thuoc-thu-y-cho-gia-cam.jpg"
                          alt="Swatch image" /></span></span><span class="wd-filter-lable layer-term-lable">Gia
                        cầm</span></a>
                  <span class="count">43</span>
                </li>
                <li class="wc-layered-nav-term wd-swatch-wrap">
                  <a rel="nofollow noopener" href="" class="layered-nav-link"><span class="wd-swatch wd-bg"><span
                          class="wd-swatch-bg"><img
                          src="https://tienthangvet.vn/wp-content/uploads/icon-thuoc-thu-y-cho-gia-suc.jpg"
                          alt="Swatch image" /></span></span><span class="wd-filter-lable layer-term-lable">Gia
                        súc</span></a>
                  <span class="count">28</span>
                </li>
                <li class="wc-layered-nav-term wd-swatch-wrap">
                  <a rel="nofollow noopener" href="" class="layered-nav-link"><span class="wd-swatch wd-bg"><span
                          class="wd-swatch-bg"><img
                          src="https://tienthangvet.vn/wp-content/uploads/icon-thuoc-thu-y-cho-heo.jpg"
                          alt="Swatch image" /></span></span><span
                          class="wd-filter-lable layer-term-lable">Heo</span></a>
                  <span class="count">16</span>
                </li>
                <li class="wc-layered-nav-term wd-swatch-wrap">
                  <a rel="nofollow noopener" href="" class="layered-nav-link"><span class="wd-swatch wd-bg"><span
                          class="wd-swatch-bg"><img
                          src="https://tienthangvet.vn/wp-content/uploads/icon-thuoc-thu-y-cho-nhung-dong-vat-khac.jpg"
                          alt="Swatch image" /></span></span><span
                          class="wd-filter-lable layer-term-lable">Khác</span></a>
                  <span class="count">2</span>
                </li>
                <li class="wc-layered-nav-term wd-swatch-wrap">
                  <a rel="nofollow noopener" href="" class="layered-nav-link"><span class="wd-swatch wd-bg"><span
                          class="wd-swatch-bg"><img
                          src="https://tienthangvet.vn/wp-content/uploads/icon-thuoc-thu-y-cho-meo.jpg"
                          alt="Swatch image" /></span></span><span
                          class="wd-filter-lable layer-term-lable">Mèo</span></a>
                  <span class="count">9</span>
                </li>
              </ul>
            </div>
          </div>
        </aside>
        <div class="content">
          <div class="shop-loop-head">
            <div class="wd-shop-tools">
              <div class="wd-breadcrumbs">
                <nav class="woocommerce-breadcrumb">
                  <a href="" class="breadcrumb-link"> Trang chủ </a>
                  <a href="" class="breadcrumb-link breadcrumb-link-last">Sản phẩm
                  </a>
                </nav>
              </div>
            </div>
          </div>
          <div class="wrapper-container">
            <div class="container">
              <div class="item">
                <div>
                  <div class="product-element-top">
                    <a href="detail-product.html">
                      <img src="https://tienthangvet.vn/wp-content/uploads/Dipomax-J.jpg" alt="">
                    </a>
                  </div>
                  <div class="product-element-bottom">
                    <a href="detail-product.html">
                      Dipomax-J | Trị viêm da, nấm da, triệu chứng viêm da cấp
                      trên chó mèo
                    </a>
                  </div>
                  <div class="product-element">
                    <div class="price-wrap">
                      <div class="unit">₫</div>
                      <div class="price">129.000</div>
                    </div>
                    <div class="rating">
                      <div class="stars" data-stars="4">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-regular fa-star"></i>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="wd-buttons wd-pos-r-t">
                  <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon"><a href=""
                                                                                          class="button product_type_simple add-to-cart-loop"
                                                                                          aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                        <span>
                          <i class="fa-solid fa-cart-shopping"></i>
                        </span></a></div>
                  <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                    <a href="" class="open-quick-view quick-view-button">
                        <span>
                          <i class="fa-solid fa-magnifying-glass"></i>
                        </span></a>
                  </div>
                  <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                    <a class="wd-tltp wd-tooltip-inited" href="" data-added-text="Browse Wishlist">
                        <span class="wd-tooltip-label">
                          <i class="fa-regular fa-heart"></i>
                        </span></a>
                  </div>
                </div>
              </div>
              <div class="item">
                <div>
                  <div class="product-element-top">
                    <a href="detail-product.html">
                      <img
                              src="https://tienthangvet.vn/wp-content/uploads/nutrimaxplus-bo-sung-vitamin-khoang-cho-thu-cung.jpg"
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
                      <div class="price">119.000</div>
                    </div>
                    <div class="rating">
                      <div class="stars" data-stars="4">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-regular fa-star"></i>
                        <i class="fa-regular fa-star"></i>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="wd-buttons wd-pos-r-t">
                  <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon"><a href=""
                                                                                          class="button product_type_simple add-to-cart-loop"
                                                                                          aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                        <span>
                          <i class="fa-solid fa-cart-shopping"></i>
                        </span></a></div>
                  <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                    <a href="" class="open-quick-view quick-view-button">
                        <span>
                          <i class="fa-solid fa-magnifying-glass"></i>
                        </span></a>
                  </div>
                  <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                    <a class="wd-tltp wd-tooltip-inited" href="" data-added-text="Browse Wishlist">
                        <span class="wd-tooltip-label">
                          <i class="fa-regular fa-heart"></i>
                        </span></a>
                  </div>
                </div>
              </div>
              <div class="item">
                <div>
                  <div class="product-element-top">
                    <a href="detail-product.html">
                      <img
                              src="https://tienthangvet.vn/wp-content/uploads/Nokodemaseb-dieu-tri-cac-trieu-chung-do-nam-gay-ra.jpg"
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
                      <div class="price">132.000</div>
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
                  <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon"><a href=""
                                                                                          class="button product_type_simple add-to-cart-loop"
                                                                                          aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                        <span>
                          <i class="fa-solid fa-cart-shopping"></i>
                        </span></a></div>
                  <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                    <a href="" class="open-quick-view quick-view-button">
                        <span>
                          <i class="fa-solid fa-magnifying-glass"></i>
                        </span></a>
                  </div>
                  <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                    <a class="wd-tltp wd-tooltip-inited" href="" data-added-text="Browse Wishlist">
                        <span class="wd-tooltip-label">
                          <i class="fa-regular fa-heart"></i>
                        </span></a>
                  </div>
                </div>
              </div>
              <div class="item">
                <div>
                  <div class="product-element-top">
                    <a href="detail-product.html">
                      <img src="https://tienthangvet.vn/wp-content/uploads/APM-1.jpg" alt="">
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
                      <div class="price">109.000</div>
                    </div>
                    <div class="rating">
                      <div class="stars" data-stars="4">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="wd-buttons wd-pos-r-t">
                  <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon"><a href=""
                                                                                          class="button product_type_simple add-to-cart-loop"
                                                                                          aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                        <span>
                          <i class="fa-solid fa-cart-shopping"></i>
                        </span></a></div>
                  <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                    <a href="" class="open-quick-view quick-view-button">
                        <span>
                          <i class="fa-solid fa-magnifying-glass"></i>
                        </span></a>
                  </div>
                  <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                    <a class="wd-tltp wd-tooltip-inited" href="" data-added-text="Browse Wishlist">
                        <span class="wd-tooltip-label">
                          <i class="fa-regular fa-heart"></i>
                        </span></a>
                  </div>
                </div>
              </div>
              <div class="item">
                <div>
                  <div class="product-element-top">
                    <a href="detail-product.html">
                      <img src="https://tienthangvet.vn/wp-content/uploads/pedtge-600x600.jpg" alt="">
                    </a>
                  </div>
                  <div class="product-element-bottom">
                    <a href="detail-product.html">
                      Vắc xin vô hoạt phòng bệnh PED+TGE heo
                    </a>
                  </div>
                  <div class="product-element">
                    <div class="price-wrap">
                      <div class="unit">₫</div>
                      <div class="price">79.000</div>
                    </div>
                    <div class="rating">
                      <div class="stars" data-stars="4">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-regular fa-star"></i>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="wd-buttons wd-pos-r-t">
                  <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon"><a href=""
                                                                                          class="button product_type_simple add-to-cart-loop"
                                                                                          aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                        <span>
                          <i class="fa-solid fa-cart-shopping"></i>
                        </span></a></div>
                  <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                    <a href="" class="open-quick-view quick-view-button">
                        <span>
                          <i class="fa-solid fa-magnifying-glass"></i>
                        </span></a>
                  </div>
                  <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                    <a class="wd-tltp wd-tooltip-inited" href="" data-added-text="Browse Wishlist">
                        <span class="wd-tooltip-label">
                          <i class="fa-regular fa-heart"></i>
                        </span></a>
                  </div>
                </div>
              </div>
              <div class="item">
                <div>
                  <div class="product-element-top">
                    <a href="detail-product.html">
                      <img src="https://tienthangvet.vn/wp-content/uploads/Tukono.jpg" alt="">
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
                      <div class="price">175.000</div>
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
                  <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon"><a href=""
                                                                                          class="button product_type_simple add-to-cart-loop"
                                                                                          aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                        <span>
                          <i class="fa-solid fa-cart-shopping"></i>
                        </span></a></div>
                  <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                    <a href="" class="open-quick-view quick-view-button">
                        <span>
                          <i class="fa-solid fa-magnifying-glass"></i>
                        </span></a>
                  </div>
                  <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                    <a class="wd-tltp wd-tooltip-inited" href="" data-added-text="Browse Wishlist">
                        <span class="wd-tooltip-label">
                          <i class="fa-regular fa-heart"></i>
                        </span></a>
                  </div>
                </div>
              </div>
              <div class="item">
                <div>
                  <div class="product-element-top">
                    <a href="detail-product.html">
                      <img
                              src="https://tienthangvet.vn/wp-content/uploads/thuoc-tien-me-Xylinvet-su-dung-cho-cho-meo-600x600.jpg"
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
                      <div class="price">145.000</div>
                    </div>
                    <div class="rating">
                      <div class="stars" data-stars="4">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star-half-stroke"></i>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="wd-buttons wd-pos-r-t">
                  <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon"><a href=""
                                                                                          class="button product_type_simple add-to-cart-loop"
                                                                                          aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                        <span>
                          <i class="fa-solid fa-cart-shopping"></i>
                        </span></a></div>
                  <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                    <a href="" class="open-quick-view quick-view-button">
                        <span>
                          <i class="fa-solid fa-magnifying-glass"></i>
                        </span></a>
                  </div>
                  <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                    <a class="wd-tltp wd-tooltip-inited" href="" data-added-text="Browse Wishlist">
                        <span class="wd-tooltip-label">
                          <i class="fa-regular fa-heart"></i>
                        </span></a>
                  </div>
                </div>
              </div>
              <div class="item">
                <div>
                  <div class="product-element-top">
                    <a href="detail-product.html">
                      <img
                              src="https://tienthangvet.vn/wp-content/uploads/thuoc-nho-gay-cleartix-spot-on-cat-tri-ve-bo-chet-tren-meo-600x600.jpg"
                              alt="">
                    </a>
                  </div>
                  <div class="product-element-bottom">
                    <a href="detail-product.html">
                      Cleartix Spot on Cat điều trị bọ chét và ve gây bệnh trên mèo
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
                  <div class="wd-add-btn wd-action-btn wd-style-icon wd-add-cart-icon"><a href=""
                                                                                          class="button product_type_simple add-to-cart-loop"
                                                                                          aria-label="Đọc thêm về “Vắc-xin vô hoạt Nisseiken Swine APM Inactivated Vaccine”">
                        <span>
                          <i class="fa-solid fa-cart-shopping"></i>
                        </span></a></div>
                  <div class="quick-view wd-action-btn wd-style-icon wd-quick-view-icon">
                    <a href="" class="open-quick-view quick-view-button">
                        <span>
                          <i class="fa-solid fa-magnifying-glass"></i>
                        </span></a>
                  </div>
                  <div class="wd-wishlist-btn wd-action-btn wd-style-icon wd-wishlist-icon">
                    <a class="wd-tltp wd-tooltip-inited" href="" data-added-text="Browse Wishlist">
                        <span class="wd-tooltip-label">
                          <i class="fa-regular fa-heart"></i>
                        </span></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="pagination">
            <ul class="pagination-wrapper">
              <li class="page-item"><a class="page-link" href="#">Trước</a></li>
              <li class="page-item active"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#">Sau</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="footer.jsp"/>
</div>
<script src="../"></script>
<script>
  window.addEventListener("scroll", () => {
    var header = document.querySelector(".container");
    header.classList.toggle("sticky", window.scrollY > 100);
  });
</script>
</body>

</html>