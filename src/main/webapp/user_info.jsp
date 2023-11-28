<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

  <link rel="stylesheet" href="../css/thuvien/bootstrap.min.css" type="text/css" />
  <link rel="stylesheet" href="../css/thuvien/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="../css/thuvien/elegant-icons.css" type="text/css">
  <link rel="stylesheet" href="../css/thuvien/nice-select.css" type="text/css">
  <link rel="stylesheet" href="../css/thuvien/jquery-ui.min.css" type="text/css">
  <link rel="stylesheet" href="../css/thuvien/owl.carousel.min.css" type="text/css">
  <link rel="stylesheet" href="../css/thuvien/slicknav.min.css" type="text/css">
  <link rel="stylesheet" href="../css/user/user.css" type="text/css">
  <link rel="stylesheet" href="../css/header&footer.css"/>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
  <link rel="icon" href="https://tienthangvet.vn/wp-content/uploads/cropped-favicon-Tien-Thang-Vet-192x192.png" sizes="192x192" />
  <title>Trang cá nhân</title>
</head>
<body>
<div class="website-wrapper">
  <header class="header">
    <div class="container-2">
      <div class="header-left">
        <a href="">
          <img src="https://tienthangvet.vn/wp-content/uploads/logo-tien-thang-vet.jpg" alt=""/>
        </a>
      </div>
      <div class="header-center">
        <div class="header-nav" role="navigation" aria-label="Main navigation">
          <ul class="menu-2 m-0 p-0" >
            <li class="menu-item" class="d-flex">
              <a href="../index.html"><span class="nav-link-text">Thuốc Y The Pet</span></a>
            </li>
            <li class="menu-item">
              <a href="introduce.html"><span class="nav-link-text">Giới thiệu</span></a>


            </li>
            <li class="menu-item">
              <a href=""><span class="nav-link-text">Sản
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
        <form role="search" method="get" class="searchform" action=""
              data-thumbnail="1" data-price="1" data-post_type="product" data-count="20" data-sku="0"
              data-symbols_count="3">
          <input type="text" class="s" placeholder="Tìm kiếm sản phẩm" value="" name="s"
                 aria-label="Search" title="Search for products" required=""/>
          <input type="hidden" name="post_type" value="product"/>
          <button type="submit" class="searchsubmit">
            <i class="fa-solid fa-magnifying-glass"></i>
          </button>
        </form>
        <div class="action">
          <div class="cart">
            <span class="count">3</span>
            <i class="fa-solid fa-cart-shopping material-icons" onclick="location.href='cart.html'"></i>
          </div>
          <div class="user-dropdown">
            <i class="fas fa-user fa-2x" style="color: #66b840" id="user-icon"></i>
            <div class="user-dropdown-content" id="user-dropdown-content">
                <ul class="user-menu">
                    <li class="user-menu-item">
                        <a href="user_info.html"><span class="nav-link-text">Quản lý thông tin cá nhân</span></a>
                    </li>
                    <li class="user-menu-item">
                        <a href="signIn.html"><span class="nav-link-text">Đăng xuất</span></a>
                    </li>
                </ul>
            </div>
        </div>

        </div>
      </div>
    </div>
  </header>
  <div class="page-title" style="
            background-image: url(https://tienthangvet.vn/wp-content/uploads/title-tag-tien-thang-vet-tsd1.jpg);
          ">
    <div class="container">
      <h1 class="title">Trang cá nhân</h1>
    </div>
  </div>
  <div class="container">
    <div class="row my-2 user__border">
      <div class="col-lg-8 order-lg-2">
        <ul class="nav nav-tabs">
          <li class="nav-item">
            <a href="" data-target="#profile" data-toggle="tab" class="nav-link active nav-link-2">Tài Khoản</a>
          </li>
          <li class="nav-item">
            <a href="" data-target="#messages" data-toggle="tab" class="nav-link nav-link-2">Đổi Mật Khẩu</a>
          </li>
          <li class="nav-item">
            <a href="" data-target="#edit" data-toggle="tab" class="nav-link nav-link-2">Đơn Hàng</a>
          </li>
        </ul>
        <div class="tab-content py-4">
          <div class="tab-pane active" id="profile">
            <!-- <h5 class="mb-3">Thông Tin Tài Khoản</h5> -->
            <div class="row">
              <div class="col-md-12">
                <header>
                  <h1>HỒ SƠ CỦA TÔI</h1>
                  <div class="content">Quản lý thông tin hồ sơ để bảo mật tài khoản</div>
                </header>
                <form id="formAcount" class="formAcount validate clearfix">
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label"> Họ tên: <span>(*)</span></label>
                      <div class="col-lg-6 col-md-9">
                        <input type="text" id="fullName" name="fullName" value="Nhóm 30" placeholder="Họ tên" class="validate[required,minSize[4],maxSize[32]] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label">Ngày sinh: <span></span></label>
                      <div class="col-lg-6 col-md-9">
                        <input type="date" id="birthday" name="birthday" value="" placeholder="Ngày sinh" class="validate[required] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label">Điện thoại: <span></span></label>
                      <div class="col-lg-6 col-md-9">
                        <input type="text" id="mobile" name="mobile" value="" placeholder="Điện thoại" class="validate[required,custom[phone]] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label">Email: <span>(*)</span></label>
                      <div class="col-lg-6 col-md-9">
                        <input type="text" id="email" name="email" value="littlestarproud24@yahoo.com.vn" placeholder="Email" class="validate[required,custom[email]] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label">Tỉnh/Thành phố : <span>(*)</span></label>
                      <div class="col-lg-6 col-md-9">
                        <select name="cityID" id="cityID">
                          <option value="">Tỉnh/Thành phố</option>
                          <option value="254">An Giang</option>
                          <option value="255">Bà Rịa - Vũng Tàu</option>
                          <option value="256">Bắc Giang</option>
                          <option value="257">Bắc Kạn</option>
                          <option value="258">Bạc Liêu</option>
                          <option value="259">Bắc Ninh</option>
                          <option value="260">Bến Tre</option>
                          <option value="261">Bình Định</option>
                          <option value="262">Bình Dương</option>
                          <option value="263">Bình Phước</option>
                          <option value="264">Bình Thuận</option>
                          <option value="265">Cần Thơ</option>
                          <option value="266">Cà Mau</option>
                          <option value="267">Cao Bằng</option>
                          <option value="268">Đà Nẵng</option>
                          <option value="269">Đắk Lắk</option>
                          <option value="270">Đắk Nông</option>
                          <option value="271">Điện Biên</option>
                          <option value="272">Đồng Nai</option>
                          <option value="273">Đồng Tháp</option>
                          <option value="274">Gia Lai</option>
                          <option value="275">Hải Phòng</option>
                          <option value="276">Hà Nội</option>
                          <option value="277">Hà Giang</option>
                          <option value="278">Hà Nam</option>
                          <option value="279">Hà Tĩnh</option>
                          <option value="280">Hải Dương</option>
                          <option value="281">Hậu Giang</option>
                          <option value="282">Hòa Bình</option>
                          <option value="283">Hưng Yên</option>
                          <option value="284">Khánh Hòa</option>
                          <option value="285">Kiên Giang</option>
                          <option value="286">Kon Tum</option>
                          <option value="287">Lai Châu</option>
                          <option value="288">Lâm Đồng</option>
                          <option value="289">Lạng Sơn</option>
                          <option value="290">Lào Cai</option>
                          <option value="291">Long An</option>
                          <option value="292">Nam Định</option>
                          <option value="293">Nghệ An</option>
                          <option value="294">Ninh Bình</option>
                          <option value="295">Ninh Thuận</option>
                          <option value="296">Phú Thọ</option>
                          <option value="297">Quảng Bình</option>
                          <option value="298">Quảng Nam</option>
                          <option value="299">Quảng Ngãi</option>
                          <option value="300">Quảng Ninh</option>
                          <option value="301">Quảng Trị</option>
                          <option value="302">Sóc Trăng</option>
                          <option value="303">Sơn La</option>
                          <option value="304">Thành phố Hồ Chí Minh</option>
                          <option value="305">Tây Ninh</option>
                          <option value="306">Thái Bình</option>
                          <option value="307">Thái Nguyên</option>
                          <option value="308">Thanh Hóa</option>
                          <option value="309">Thừa Thiên Huế</option>
                          <option value="310">Tiền Giang</option>
                          <option value="312">Trà Vinh</option>
                          <option value="313">Tuyên Quang</option>
                          <option value="314">Vĩnh Long</option>
                          <option value="315">Vĩnh Phúc</option>
                          <option value="316">Yên Bái</option>
                          <option value="317">Phú Yên</option>
                        </select>
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label">Quận/ Huyện:  <span>(*)</span></label>
                      <div class="col-lg-6 col-md-9">
                        <input type="text" id="district" name="district" value="" placeholder="Quận/ Huyện" class="validate[required,custom[email]] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label">Xã/ Phường/ Thị trấn:  <span>(*)</span></label>
                      <div class="col-lg-6 col-md-9">
                        <input type="text" id="ward" name="ward" value="" placeholder="Xã/ Phường/ Thị trấn" class="validate[required,custom[email]] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label">Địa chỉ chi tiết:  <span>(*)</span></label>
                      <div class="col-lg-6 col-md-9">
                        <input type="text" id="address" name="address" value="" placeholder="Địa chỉ chi tiết" class="validate[required] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label"></label>
                      <div class="col-lg-6 col-md-9">
                        <input type="submit" class="btn-update" value="CẬP NHẬT">
                        <!-- <button type="submit" class="btn-update">CẬP NHẬT                                      -->
                        </button>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <!--/row-->
          </div>
          <div class="tab-pane" id="messages">
            <!-- <h5 class="mb-3">Thông Tin Tài Khoản</h5> -->
            <div class="row">
              <div class="col-md-12">
                <header>
                  <h1>THAY ĐỔI MẬT KHẨU</h1>
                  <div class="content">Bạn nên cập nhật mật khẩu thường xuyên vì lí do bảo mật</div>
                </header>
                <form id="formAcount" class="formAcount validate clearfix">
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label"> Mật khẩu cũ: </label>
                      <div class="col-lg-6 col-md-9">
                        <input type="password" id="pass" name="pass" class="validate[required,minSize[4],maxSize[32]] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label"> Mật khẩu mới: </label>
                      <div class="col-lg-6 col-md-9">
                        <input type="password" id="pass" name="pass" class="validate[required,minSize[4],maxSize[32]] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label"> Xác nhận mật khẩu: </label>
                      <div class="col-lg-6 col-md-9">
                        <input type="password" id="pass" name="pass" class="validate[required,minSize[4],maxSize[32]] form-control input-sm">
                      </div>
                    </div>
                  </div>
                  <div class="form-group clearfix">
                    <div class="row">
                      <label class="col-md-3 control-label"></label>
                      <div class="col-lg-6 col-md-9">
                        <button type="submit" class="btn-update">LƯU
                        </button>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <!--/row-->
          </div>
          <div class="tab-pane myorder__style" id="edit">
            <!-- <div class="heading">Đơn hàng của tôi</div> -->
            <div class="inner">
              <table>
                <thead>
                <tr>
                  <th>Mã đơn hàng</th>
                  <th>Ngày mua</th>
                  <th>Sản phẩm</th>
                  <th>Tổng tiền</th>
                  <th>Trạng thái đơn hàng</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>
                    <a href="order_detail.html">673617832</a>
                  </td>
                  <td>30/10/2023</td>
                  <td>Vắc xin vô hoạt</td>
                  <td>230.000 VNĐ</td>
                  <td>Giao hàng thành công</td>
                </tr>
                <tr>
                  <td>
                    <a href="#">219844147</a>
                  </td>
                  <td>12/10/2023</td>
                  <td>Thuốc kháng viêm</td>
                  <td>156.000 VNĐ</td>
                  <td>Giao hàng thành công</td>
                </tr>
                <tr>
                  <td>
                    <a href="#">972084147</a>
                  </td>
                  <td>09/10/2013</td>
                  <td>Sát trùng</td>
                  <td>350.000 VNĐ</td>
                  <td>Đã hủy</td>
                </tr>
                <tr>
                  <td>
                    <a href="#">404252736</a>
                  </td>
                  <td>05/10/2013</td>
                  <td>Dinh Dưỡng</td>
                  <td>172.000 VNĐ</td>
                  <td>Đã hủy</td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>



          <!--/row-->
        </div>

      </div>
      <div class="col-lg-4 order-lg-1 text-center img-2">
        <div class="img-ava">
          <img src="https://tienthangvet.vn/wp-content/uploads/logo-tien-thang-vet.jpg" class="mx-auto img-fluid img-circle d-block"  alt="avatar">
          <label class="load-ava">
            <span class="custom-file-control">Đổi Ảnh</span>
            <input type="file" id="file" class="custom-file-input">

          </label>
        </div>
        <h6 class="mt-2">Nhóm 30</h6>

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
          <div class="elementor-element" data-id="960505b" data-element_type="widget"
               data-widget_type="html.default">
            <div class="elementor-widget-container">
              <iframe
                      src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.214525515988!2d106.78918677590663!3d10.871281657435139!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBOw7RuZyBMw6JtIFRQLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1697118240058!5m2!1svi!2s"
                      width="100%" height="250" style="border:0;" allowfullscreen=""
                      loading="lazy"></iframe>
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
<script src="../js/thuvien/jquery-3.3.1.min.js"></script>
<script src="../js/thuvien/bootstrap.min.js"></script>
<script src="../js/thuvien/main.js"></script>
<script>
  window.addEventListener('scroll', () => {
  var header = document.querySelector('.container-2')
  header.classList.toggle('sticky', window.scrollY > 100)
})
</script>
<script>
  $(document).ready(function(){
    $("#formAcount").validate({
      rules: {
        fullname: {
          required: true
        },
        email: {
          required: true,
          email: true
        },
        cityID: {
          required: true
        },
        district: {
          required: true
        },
        ward: {
          required: true
        },
        address:  {
          required: true
        }
      },
      messages: {
        fullname: {
          required: "Xin vui lòng nhập tên"
        },
        email: {
          required: "Xin vui lòng nhập email",
          email: "Email không hợp lệ, xin vui lòng nhập lại"
        },
        cityID: {
          required: "Xin chọn tỉnh/thành phố"
        },
        district: {
          required: "Xin vui lòng nhập quận/huyện"
        },
        ward: {
          required: "Xin vui lòng nhập xã/ phường/ thị trấn"
        },
        address:  {
          required: "Xin vui lòng nhập địa chỉ"
        }
      }
    });
  });
</script>

</body>
</html>