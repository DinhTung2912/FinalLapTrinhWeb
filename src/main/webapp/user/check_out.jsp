<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <link rel="stylesheet" href="" type="text/css" />

  <link rel="stylesheet" href="css/thuvien/bootstrap.min.css" type="text/css" />
  <link rel="stylesheet" href="css/thuvien/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="css/thuvien/elegant-icons.css" type="text/css">
  <link rel="stylesheet" href="css/thuvien/nice-select.css" type="text/css">
  <link rel="stylesheet" href="css/thuvien/jquery-ui.min.css" type="text/css">
  <link rel="stylesheet" href="css/thuvien/owl.carousel.min.css" type="text/css">
  <link rel="stylesheet" href="css/thuvien/slicknav.min.css" type="text/css">
  <link rel="stylesheet" href="css/cart/checkout.css" type="text/css" />
  <link rel="stylesheet" href="css/header&footer.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
    integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="icon" href="https://tienthangvet.vn/wp-content/uploads/cropped-favicon-Tien-Thang-Vet-192x192.png"
    sizes="192x192" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

  <title>Checkout</title>
</head>

<body>
  <div class="website-wrapper">
    <header class="header">
      <div class="container-2" >
        <div class="header-left">
          <a href="../index.html">
            <img src="https://tienthangvet.vn/wp-content/uploads/logo-tien-thang-vet.jpg" alt="" />
          </a>
        </div>
        <div class="header-center">
          <div class="header-nav" role="navigation" aria-label="Main navigation">
              <ul class="menu-2 m-0 p-0">
                  <li class="menu-item">
                      <a href="../index.html"><span class="nav-link-text">Thuốc Y
                              The Pet</span></a>
                  </li>
                  <li class="menu-item">
                      <a href="introduce.html"><span class="nav-link-text">Giới
                              thiệu</span></a>

                  </li>
                  <li class="menu-item">
                      <a href="products.html" class="d-flex"><span class="nav-link-text ">Sản
                              phẩm</span></a>
                      <div class="">
                          <ul class="sub-menu">
                              <li class="menu-item">
                                <a href="">Thức ăn chăn nuôi</a>
                              </li>
                              <li class="menu-item">
                                <a href="">Chăm sóc thú cưng</a>
                              </li>
                              <li class="menu-item">
                                <a href="">Thuốc thú y<i class="fa-solid fa-angle-right"></i></a>
                                <ul class="sub-sub-menu">
                                  <li class="menu-item">
                                    <a href="">Thuốc kháng sinh</a>
                                  </li>
                                  <li class="menu-item">
                                    <a href="">Thuốc sát trùng</a>
                                  </li>
                                  <li class="menu-item">
                                    <a href="">Vắc xin phòng bệnh</a>
                                  </li>
                                </ul>
                              </li>
                            </ul>
                      </div>
                  </li>
                  <li class="menu-item">
                      <a href="contact.html"><span class="nav-link-text">Liên
                              hệ</span></a>
                  </li>
              </ul>
          </div>
      </div>
        <div class="header-right">
          <form role="search" method="get" class="searchform" action="" data-thumbnail="1" data-price="1"
            data-post_type="product" data-count="20" data-sku="0" data-symbols_count="3">
            <input type="text" class="s" placeholder="Tìm kiếm sản phẩm" value="" name="s" aria-label="Search"
              title="Search for products" required="" />
            <input type="hidden" name="post_type" value="product" />
            <button type="submit" class="searchsubmit">
              <i class="fa-solid fa-magnifying-glass"></i>
            </button>
          </form>
          <div class="action">
            <div class="cart">
              <span class="count">3</span>
              <i class="fa-solid fa-cart-shopping material-icons" onclick="location.href='cart.html'"></i>
            </div>
            <button class="sign-in" onclick="location.href='signIn.html'">Đăng nhập</button>
          </div>
        </div>
      </div>
    </header>
    <div class="page-title" style="
            background-image: url(https://tienthangvet.vn/wp-content/uploads/title-tag-tien-thang-vet-tsd1.jpg);
          ">
      <div class="container">
        <h1 class="title">Thanh toán</h1>
      </div>
    </div>
    
    <section class="checkout spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <h6>
              <span class="icon_tag_alt"></span> Đã có mã giảm giá?
              <a href="cart.html">nhấn tại đây</a> để lấy mã giảm giá
            </h6>
          </div>
        </div>
        <div class="checkout__form">
          <h4>Chi tiết đơn hàng</h4>
          <form action="#">
            <div class="row">
              <div class="col-lg-8 col-md-6">
                <div class="row">
                  <div class="col-lg-6">
                    <div class="checkout__input">
                      <p>Họ và tên đệm<span>*</span></p>
                      <input type="text" required />
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="checkout__input">
                      <p>Tên<span>*</span></p>
                      <input type="text" required />
                    </div>
                  </div>
                </div>
                <div class="checkout__input">
                  <p>Địa chỉ<span>*</span></p>
                  <input type="text" placeholder="Số nhà / Đường" class="checkout__input__add" required />
                  <input type="text" placeholder required="Xã / Phường / Thị trấn" />
                </div>
                <div class="checkout__input">
                  <p>Tỉnh / Thành phố<span>*</span></p>
                  <input type="text" required />
                </div>
                <div class="checkout__input">
                  <p>Huyện / Quận<span>*</span></p>
                  <input type="text" required />
                </div>
                <div class="row">
                  <div class="col-lg-6">
                    <div class="checkout__input">
                      <p>Điện thoại<span>*</span></p>
                      <input type="number" required />
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="checkout__input">
                      <p>Email<span>*</span></p>
                      <input type="email" required />
                    </div>
                  </div>
                </div>

                <!-- Tao tai khoan -->
<!--                <div class="checkout__input__checkbox">-->
<!--                  <label for="acc">-->
<!--                    Tạo tài khoản?-->
<!--                    <input type="checkbox" id="acc" data-toggle="collapse" data-target="#create_account"-->
<!--                      aria-expanded="false" aria-controls="create_account" required />-->
<!--                    <span class="checkmark"></span>-->
<!--                  </label>-->
<!--                </div>-->


<!--                <div class="collapse" id="create_account">-->
<!--                  <p>-->
<!--                    Để tạo tạo khoản vui lòng nhập thông tin bên dưới. Nếu khách-->
<!--                    hàng đã có tài khoản vui lòng đăng nhập-->
<!--                  </p>-->
<!--                  <div class="checkout__input">-->
<!--                    <p>Mật khẩu tài khoản<span>*</span></p>-->
<!--                    <input type="password" required />-->
<!--                  </div>-->
<!--                </div>-->
                <!-- Ket thuc tao tai khoan -->

                <!-- Van chuuyen den dia chi khac -->
<!--                <div class="checkout__input__checkbox">-->
<!--                  <label for="diff-acc">-->
<!--                    Vận chuyển đơn hàng đến địa chỉ khác?-->
<!--                    <input type="checkbox" id="diff-acc" data-toggle="collapse" data-target="#other_place_ship"-->
<!--                      aria-expanded="false" aria-controls="collapseExample" />-->
<!--                    <span class="checkmark" id="order-place"></span>-->
<!--                  </label>-->
<!--                </div>-->
<!--                <div class="checkout__input collapse" id="other_place_ship">-->
<!--                  <p>Địa chỉ<span>*</span></p>-->
<!--                  <input id="order-place-input-required" type="text" placeholder="Ghi đầy đủ địa chỉ" />-->
<!--                </div>-->

                <!-- Ket thuc van chuyen den dia chi khac -->

                <div class="checkout__input">
                  <p>Lưu ý khi vận chuyển<span>*</span></p>
                  <input type="text" placeholder="Lưu ý về đơn hàng hoặc lưu ý khi vận chuyển." />
                </div>
              </div>
              <div class="col-lg-4 col-md-6">
                <div class="checkout__order">
                  <h4>Đơn hàng</h4>
                  <div class="checkout__order__products">
                    Sản phẩm <span>Giá</span>
                  </div>
                  <ul>
                    <li>Thuốc trị viêm da <span>45.000 VNĐ</span></li>
                    <li>Vắc xin vô hoạt <span>29.000 VNĐ</span></li>
                    <li>Thuốc kháng tiêm <span>36.000 VNĐ</span></li>
                  </ul>
                  <div class="checkout__order__subtotal">
                    Tổng:<span>110.000 VNĐ</span>
                  </div>
                  <div class="checkout__order__subtotal">
                    Phí vận chuyển: <span>26.000 VNĐ</span>
                  </div>

                  <div class="checkout__order__total">
                    Thành tiền:<span>126.000 VNĐ</span>
                  </div>
                  <p>Vui lòng chọn hình thức thanh toán</p>
                  <div class="checkout__input__checkbox">
                    <label for="cash">
                      Cash on delivery (COD)
                      <input type="checkbox" id="cash" />
                      <span class="checkmark"></span>
                    </label>
                  </div>
                  <div class="checkout__input__checkbox">
                    <label for="momo">
                      MOMO
                      <input type="checkbox" id="momo" data-toggle="collapse" data-target="#momo-code" />
                      <span class="checkmark"></span>
                    </label>
<!--                    <div id="momo-code" class="checkout__input collapse">-->
<!--                      <p>Mã giảm momo</p>-->
<!--                      <input type="text" />-->
<!--                    </div>-->
                  </div>
                  <button id="checkout-btn" type="submit" class="site-btn">Đặt hàng</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </section>
    <!-- Checkout Section End -->
    <!-- Modal -->
    <div class="modal fade" id="momo-payment" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
      aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLongTitle">Quét QR</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="container">
              <img src="img/qr_code/qr_code1.png" alt="">
              <p>Vui lòng mở momo và quét QR code trong vòng <span id="count-down-time">200</span> giây</p>
            </div>
          </div>
        </div>
      </div>
    </div>


    <footer class="footer-container">
      <div class="container">
        <div class="main-footer">
          <div class="elementor-column" data-id="e97658c" data-element_type="column">
            <div class="elementor-widget-wrap elementor-element-populated">
              <div class="elementor-widget-container">
                <p><span style="color: #ffffff;"><strong>CÔNG
                      TY TNHH THƯƠNG MẠI VÀ
                      DỊCH VỤ PHÁT TRIỂN <br>THUỐC Y THE PET</strong></span></p>
              </div>
              <div class="elementor-widget-container">
                <ul class="elementor-icon-list-items">
                  <li class="elementor-icon-list-item">
                    <a href="">
                      <span class="elementor-icon-list-icon">
                        <i aria-hidden="true" class="fas fa-map-marker-alt"></i> </span>
                      <span class="elementor-icon-list-text">Khu phố 6, Phường Linh Trung, Quận Thủ Đức, TPHCM</span>
                    </a>
                  </li>
                  <li class="elementor-icon-list-item">
                    <a href="tel:%200947513315">

                      <span class="elementor-icon-list-icon">
                        <i aria-hidden="true" class="fas fa-phone-volume"></i> </span>
                      <span class="elementor-icon-list-text">NVKD SP gia súc -
                        gia cầm: 0999 999 999</span>
                    </a>
                  </li>
                  <li class="elementor-icon-list-item">
                    <a href="tel:%20028%203948%203929">

                      <span class="elementor-icon-list-icon">
                        <i aria-hidden="true" class="fas fa-headphones-alt"></i> </span>
                      <span class="elementor-icon-list-text">Hotline: 028 999 9999</span>
                    </a>
                  </li>
                  <li class="elementor-icon-list-item">
                    <a href="mailto:tienthangvet@gmail.com">

                      <span class="elementor-icon-list-icon">
                        <i aria-hidden="true" class="far fa-envelope"></i>
                      </span>
                      <span class="elementor-icon-list-text">doanwebnhom30@gmail.com</span>
                    </a>
                  </li>
                </ul>
              </div>
              <div class="elementor-widget-container">
                <div class="social-icons">
                  <a href=""><i class="icon fa-brands fa-square-facebook"></i></a>
                  <a href=""><i class="icon fa-brands fa-square-x-twitter"></i></a>
                  <a href=""><i class="icon fa-brands fa-square-instagram"></i></a>
                  <a href=""><i class="icon fa-brands fa-square-youtube"></i></a>
                  <a href=""><i class="icon fa-brands fa-square-pinterest"></i></a>
                  <a href=""><i class="icon fa-brands fa-linkedin"></i></a>
                </div>
              </div>

            </div>
          </div>
          <div class="elementor-widget-wrap">
            <div class="elementor-element" data-id="4cd4ee9" data-element_type="widget"
              data-widget_type="text-editor.default">
              <div class="elementor-widget-container">
                <p style="font-size: 16px; font-weight: 600;"><span
                        style="color: #ffffff;"><strong>THÔNG
                                            TIN
                                            CHUNG</strong></span></p>
                <p><a href="introduce.html" rel="nofollow"><span
                        style="color: rgba(236, 236, 236, 0.4);">Giới
                                            thiệu</span></a></p>
                <p><span style="color: rgba(236, 236, 236, 0.4);"><a
                        style="color: rgba(236, 236, 236, 0.4);"
                        href="privacyPolicy.html" rel="nofollow">Chính sách
                                            bảo mật</a></span></p>
                <p><span style="color: rgba(236, 236, 236, 0.4);"><a
                        style="color: rgba(236, 236, 236, 0.4);"
                        href="partnerPolicy.html" rel="nofollow">Chính sách
                                            đối tác</a></span></p>
                <p><span style="color: rgba(236, 236, 236, 0.4);"><a
                        style="color: rgba(236, 236, 236, 0.4);"
                        href="agencyPolicy.html" rel="nofollow">Chính sách
                                            đại lý</a></span></p>
                <p><span style="color: rgba(236, 236, 236, 0.4);"><a
                        style="color: rgba(236, 236, 236, 0.4);"
                        href="termsPolicy.html" rel="nofollow">Chính sách điều khoản và điều kiện</a></span></p>
                <p><span style="color: rgba(236, 236, 236, 0.4);"><a
                        style="color: rgba(236, 236, 236, 0.4);"
                        href="contact.html" rel="nofollow">Thông tin liên
                                            hệ</a></span></p>
              </div>
            </div>
          </div>
          <div class="elementor-map-wrap">
            <div class="elementor-element" data-id="960505b" data-element_type="widget" data-widget_type="html.default">
              <div class="elementor-widget-container">
                <iframe
                  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.214525515988!2d106.78918677590663!3d10.871281657435139!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBOw7RuZyBMw6JtIFRQLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1697118240058!5m2!1svi!2s"
                  width="100%" height="250" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
              </div>
            </div>
          </div>
        </div>
        <div class="copyrights-wrapper">
          <div class="container">
            <div class="min-footer">
              <small><a href=""><strong style="color: #333333;">Thuốc Y The Pet</strong></a> <i
                  class="fa fa-copyright"></i> 2023 được tạo bởi <strong>Nhóm 30</strong>.</small>
            </div>
          </div>
        </div>
      </div>


    </footer>
  </div>
  <script src="js/thuvien/jquery-3.3.1.min.js"></script>
  <script src="js/thuvien/bootstrap.min.js"></script>
  <script src="js/thuvien/main.js"></script>
  <div class="modal" id="orderSuccessModal">
    <div class="modal-dialog">
      <div class="modal-content">

        <!-- Modal Header -->
        <div class="modal-header">

          <h4 class="modal-title">Đặt hàng thành công!    </h4>
          <p class="text-center">
            <i class="fas fa-check-circle" style="color: #7fad39; font-size: 30px;"></i>
          </p>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>

        <!-- Modal Body -->
        <div class="modal-body">
          <p>Cảm ơn bạn đã đặt hàng! Chúng tôi sẽ liên hệ với bạn sớm nhất có thể.</p>
        </div>

      </div>
    </div>
  </div>

  <script>
    $(document).ready(function () {
      // Handle form submission
      $("#checkout-btn").click(function (event) {
        event.preventDefault();
        // Perform any necessary form validation or AJAX request here
        // Show the order success modal
        $("#orderSuccessModal").modal("show");
      });
    });
  </script>
</body>

</html>