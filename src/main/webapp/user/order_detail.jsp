<%--
  Created by IntelliJ IDEA.
  User: DINHTUNG
  Date: 09/12/2023
  Time: 1:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.finallaptrinhweb.model.Util" %>
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
        <%--    <c:set var="or" value="${order}"></c:set>--%>
        <div class="container">
            <div class="row">
                <div class="col-lg">
                    <div class="Account__Style">
                        <div class="heading">
                            <span>Chi tiết đơn hàng #${order.id}</span>
                            <span class="split">-</span>
                            <span class="status">Giao hàng thành công</span>
                        </div>
                        <div class="created-date">Ngày đặt hàng: ${order.dateCreated}</div>
                        <div class="styles_section-2">
                            <div class="styles_group_1">
                                <div class="title">Địa chỉ người nhận</div>
                                <div class="content">
                                    <p class="name">${order.username}</p>
                                    <p class="address">
                                        <span>Địa chỉ: </span>
                                        ${order.detailAddress}
                                    </p>
                                    <p class="phone">
                                        <span>Điện thoại: </span>0${order.phone}
                                    </p>
                                </div>
                            </div>
                            <div class="styles_group_1">
                                <div class="title">Hình thức giao hàng</div>
                                <div class="content">
                                    <p>Vận chuyển</p>
                                </div>
                            </div>
                            <div class="styles_group_1">
                                <div class="title">Hình thức thanh toán</div>
                                <div class="content">
                                    <c:if test="${order.payment==true}"><p class="">Thanh toán tiền mặt khi nhận hàng</p></c:if>
                                    <c:if test="${order.payment==false}"><p class="">Thanh toán qua ví Momo</p></c:if>
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
                            <c:forEach items="${p_list}" var="pl">
                                            <c:set var="price" value="${pl.price}"></c:set>
                                            <c:set var="sale" value="${pl.sale}"></c:set>
                                            <c:set var="total" value="${pl.total}"></c:set>
                            <tr>
                                <td>
                                    <div class="product-item">
                                        <img src="${pl.imageUrl}" alt="${pl.productName}">
                                        <div class="product-info">
                                            <a class="product-name" href="shop-detail?id=${pl.id}">${pl.productName}</a>
                                            <p class="product-seller">Cung cấp bởi Thú Y The Pet </p>
                                            <div class="product-review">
                                                <a id="btn-comment" href="#" data-toggle="modal"
                                                   data-target="#exampleModalCenter">Viết nhận xét</a>
                                                <a href="warranty?order_id=${order.id}&pro_id=${pl.productId}&user_id=${sessionScope.user_id}" target="_blank">Bảo hành</a>
                                            </div>
                                        </div>
                                    </div>

                                    </td>
                                <td class="price"><%= Util.formatCurrency((double) pageContext.getAttribute("price"))%> VND</td>
                                    <td class="quantity">${pl.quantity}</td>
                                <td class="discount-amount"><%= Util.formatCurrency((double) pageContext.getAttribute("sale"))%> VND</td>
                                <td class="raw-total"><%= Util.formatCurrency((double) pageContext.getAttribute("total"))%>VND</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <c:set var="sum" value="${sum}"></c:set>
                            <c:set var="ship" value="${ship}"></c:set>
                            <c:set var="total_money" value="${total_money}"></c:set>
                            <tr>
                                <td colspan="4">
                                    <span>Tạm tính</span>
                                </td>
                                <td><%= Util.formatCurrency((double) pageContext.getAttribute("sum"))%>VND</td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <span>Phí vận chuyển</span>
                                </td>
                                <td><%= Util.formatCurrency((double) pageContext.getAttribute("ship"))%>VND</td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <span>Tổng cộng</span>
                                </td>
                                <td>
                                    <span class="sum"><%= Util.formatCurrency((double) pageContext.getAttribute("total_money"))%>VND</span>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                        <a class="view-list-order" href="user">Quay lại đơn hàng của tôi</a>
                        <button class="cancel-order" disabled="">Hủy Đơn Hàng</button>
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