<%--
  Created by IntelliJ IDEA.
  User: DINHTUNG
  Date: 09/12/2023
  Time: 1:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />

    <link rel="stylesheet" href="css/thuvien/bootstrap.min.css" type="text/css" />
    <link rel="stylesheet" href="css/thuvien/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/thuvien/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/thuvien/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/thuvien/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/thuvien/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/thuvien/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/cart/order_detail.css" type="text/css" />
    <link rel="stylesheet" href="css/header&footer.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="icon" href="https://tienthangvet.vn/wp-content/uploads/cropped-favicon-Tien-Thang-Vet-192x192.png"
          sizes="192x192" />
    <title>Chi tiết đơn hàng</title>
</head>

<body>
<div class="website-wrapper">
    <jsp:include page="header.jsp"/>
    <div class="page-title" style="
            background-image: url(https://tienthangvet.vn/wp-content/uploads/title-tag-tien-thang-vet-tsd1.jpg);
          ">
        <div class="container">
            <h1 class="title">Chi tiết đơn hàng</h1>
        </div>
    </div>

    <section class="follow spad">
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <div class="Account__Style">
                        <div class="heading">
                            <span>Chi tiết đơn hàng #673617832</span>
                            <span class="split">-</span>
                            <span class="status">Giao hàng thành công</span>
                        </div>
                        <div class="created-date">Ngày đặt hàng: 07:46 30/10/2023</div>

                        <div class="styles_section-1">
                            <div class="title">Thông báo</div>
                            <div class="content">
                                <div class="notifications">
                                    <div class="notifications__item">
                                        <div class="date">05:44 31/10/2023</div>
                                        <div class="comment">Chúng tôi vừa bàn giao đơn hàng của quý khách đến đối
                                            tác vận chuyển. Đơn hàng của quý khách sẽ được giao trong ngày hôm nay
                                            31/10/2023</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="styles_section-2">
                            <div class="styles_group_1">
                                <div class="title">Địa chỉ người nhận</div>
                                <div class="content">
                                    <p class="name">Nguyễn Đình Tùng</p>
                                    <p class="address">
                                        <span>Địa chỉ: </span>KTX Đại Học Quốc Gia (Cổng sau), Phường Linh Trung,
                                        Quận Thủ Đức, Hồ Chí Minh, Việt Nam
                                    </p>
                                    <p class="phone">
                                        <span>Điện thoại: </span>0828008612
                                    </p>
                                </div>
                            </div>
                            <div class="styles_group_1">
                                <div class="title">Hình thức giao hàng</div>
                                <div class="content">
                                    <p>Giao vào Thứ bảy, 31/10</p>
                                    <p>Phí vận chuyển: 12.000đ</p>
                                </div>
                            </div>
                            <div class="styles_group_1">
                                <div class="title">Hình thức thanh toán</div>
                                <div class="content">
                                    <p class="">Thanh toán tiền mặt khi nhận hàng</p>
                                </div>
                            </div>
                        </div>
                        <table class="styles_section-3">
                            <thead>
                            <tr>
                                <th>Sản phẩm</th>
                                <th>Giá</th>
                                <th>Số lượng</th>
                                <th>Giảm giá</th>
                                <th>Tạm tính</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="product-item">
                                        <img src="https://tienthangvet.vn/wp-content/uploads/APM-1.jpg"
                                             alt="Vắc xin vô hoạt">
                                        <div class="product-info">
                                            <a class="product-name" href="#">Vắc xin vô hoạt</a>
                                            <p class="product-seller">Cung cấp bởi Thú y The Pet</p>
                                            <div class="product-review">
                                                <a id="btn-comment" href="#" data-toggle="modal"
                                                   data-target="#exampleModalCenter">Viết nhận xét</a>
                                                <a href="" target="_blank">Bảo hành</a>
                                                <button disabled>Hủy Đơn Hàng</button>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td class="price">109.000 VNĐ</td>
                                <td class="quantity">2</td>
                                <td class="discount-amount">0 VNĐ</td>
                                <td class="raw-total">218.000 VNĐ</td>
                            </tr>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="4">
                                    <span>Tạm tính</span>
                                </td>
                                <td>218.000 VNĐ</td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <span>Phí vận chuyển</span>
                                </td>
                                <td>12.000 VNĐ</td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <span>Tổng cộng</span>
                                </td>
                                <td>
                                    <span class="sum">230.000 VNĐ</span>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                        <a class="view-list-order" href="">Quay lại đơn hàng của tôi</a>
                        <a class="view-tracking-detail" href="order_manage.html">Theo dõi đơn hàng</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 style="color:#7fad39 ;" class="modal-title" id="exampleModalLongTitle">Viết nhận xét</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- <div class="container-cm col-lg-12"> -->

                        <!-- <h5>ĐÁNH GIÁ SẢN PHẨM</h5> -->
                        <!-- <form id="form-cm"> -->
                        <!-- <label for="sao">Đánh giá của bạn về sản phẩm này</label> -->
                        <select class="fullname-cm" name="star" >
                            <option value="154" selected>😍 Rất tốt</option>
                            <option value="155">😀 Tốt</option>
                            <option value="156">🙂 Được</option>
                            <option value="157">😐 Tệ </option>
                            <option value="158">😌 Rất tệ</option>
                        </select>
                        <!-- <h6>Viết nhận xét của bạn vào bên dưới:</h6> -->
                        <input class="message" type="text" name="message" placeholder="Hãy chia sẻ những điều bạn thích về sản phẩm này nhé!" style="background-color: white"><br>
                        <label for="">Thêm hình sản phẩm nếu có (tối đa 5 hình): </label> <button style="color: #ffffff;background-color:#5e6158;border-radius: 5px;" class="chonhinh">Chọn Hình</button> <br>
                        <button type="button" class="submit-cm" name="submit-cm">Gửi Nhận Xét</button>
                        <!--
                                        </form> -->

                        <!-- </div> -->
                        <!-- <div class="modal-footer">
                          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                          <button type="button" class="btn btn-primary">Save changes</button>
                        </div> -->
                    </div>
                </div>
            </div>
        </div>

    <jsp:include page="footer.jsp"/>
</div>
<script src="js/thuvien/jquery-3.3.1.min.js"></script>
<script src="js/thuvien/bootstrap.min.js"></script>
<script src="js/thuvien/main.js"></script>

</body>

</html>