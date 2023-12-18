<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page import="com.example.finallaptrinhweb.model.Cart" %>
<%@ page import="com.example.finallaptrinhweb.model.CartItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Cart cart = (Cart) session.getAttribute("cart");
%>
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
<jsp:include page="header.jsp"/>
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
          <a href="cart.jsp">nhấn tại đây</a> để lấy mã giảm giá
        </h6>
      </div>
    </div>
    <h4>Chi tiết đơn hàng</h4>
    <form id="checkoutForm" action="#" method="post">
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


          <div class="checkout__input">
            <p>Lưu ý khi vận chuyển<span>*</span></p>
            <input type="text" placeholder="Lưu ý về đơn hàng hoặc lưu ý khi vận chuyển." />
          </div>
        </div>
        <div class="col-lg-4 col-md-6">
          <div class="checkout__order">
          <div >
            <h2>Thông tin sản phẩm trong giỏ hàng:</h2>

            <c:forEach var="item" items="${cart.products.values()}">
              <div>
                <p>Tên sản phẩm: ${item.product.productName}</p>
                <p>Giá bán: ${item.product.price} VNĐ</p>
<%--                <p>Số lượng: ${item.quantity}</p>--%>
                <p>Tổng: ${item.totalPrice} VNĐ</p>
              </div>
            </c:forEach>
          </div>


          <p>Vui lòng chọn hình thức thanh toán</p>
          <div class="checkout__input__checkbox">
            <label for="cash">
              Cash on delivery (COD)
              <input type="checkbox" id="cash" class="payment-option" />
              <span class="checkmark"></span>
            </label>
          </div>
          <div class="checkout__input__checkbox">
            <label for="momo">
              MOMO
              <input type="checkbox" id="momo" class="payment-option" data-toggle="collapse" data-target="#momo-code" />
              <span class="checkmark"></span>
            </label>
          </div>

          <div>
            <form action="<c:url value='/user/checkout' />" method="post" id="paymentValidationMessage" class="payment-validation-message">
              <!-- ... Form content ... -->
              <button id="validateAndSubmitBtn" type="button" type="submit" class="site-btn">Thanh toán</button>
            </form>
          </div>
        </div>
          </div>



      </div>

    </form>
  </div>
</section>

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
            <img src="assets/img/qr_code/qr_code1.jpg" alt="" style="max-width: 100%; height: auto;">
            <p>Vui lòng mở momo và quét QR code trong vòng <span id="count-down-time">60</span> giây</p>

          </div>
        </div>
      </div>
    </div>
  </div>


<jsp:include page="footer.jsp"/>
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
    // Handle button click for validation and submission
    $("#validateAndSubmitBtn").click(function () {
      // Check if either COD or MOMO is selected
      if ($("#cash").prop("checked") && !$("#momo").prop("checked")) {
        // If only COD is selected, proceed with form submission
        $("#checkoutForm").submit();
      } else if ($("#momo").prop("checked") && !$("#cash").prop("checked")) {
        // If only MOMO is selected, display MOMO QR code modal
        $("#momo-payment").modal("show");
        // Start countdown timer (you can implement this logic)
        startCountdownTimer();
      } else {
        // Show validation message if both or neither is selected
        $("#paymentValidationMessage").text("Vui lòng chọn một phương thức thanh toán (COD hoặc MOMO).").show();
      }
    });

    $("#momo").change(function () {
      // Uncheck COD if MOMO is selected
      if ($(this).prop("checked")) {
        $("#cash").prop("checked", false);
        $("#paymentValidationMessage").hide();
      }
    });

    $("#cash").change(function () {
      if ($(this).prop("checked")) {
        $("#momo").prop("checked", false);
        $("#paymentValidationMessage").hide();
      }
    });

    // Handle form submission for COD
    $("#checkoutForm").submit(function (event) {
      // Prevent the default form submission
      event.preventDefault();

      // Perform any necessary form validation or AJAX request here
      // Show the order success modal
      $("#orderSuccessModal").modal("show");
    });


    function startCountdownTimer() {
      // Set the countdown duration in seconds
      var countdownDuration = 60;

      // Get the countdown element by its ID
      var countdownElement = $("#count-down-time");

      // Update the countdown every second
      var countdownInterval = setInterval(function () {
        // Update the countdown element with the remaining time
        countdownElement.text(countdownDuration);

        // Decrease the countdown duration
        countdownDuration--;

        // Check if the countdown has reached zero
        if (countdownDuration < 0) {
          // Clear the interval when the countdown is complete
          clearInterval(countdownInterval);

          // You can add logic here when the countdown reaches zero,
          // such as hiding the MOMO modal or displaying a message.

          // For example:
          // $("#momo-payment").modal("hide");
          // alert("Time's up! Please try again.");
        }
      }, 1000); // Update every 1000 milliseconds (1 second)
    }

  });
</script>




</body>

</html>