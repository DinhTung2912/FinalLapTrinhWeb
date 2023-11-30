<%@ page import="com.example.finallaptrinhweb.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% User user = (User) session.getAttribute("auth");%>
<head>
    <link rel="stylesheet" href="css/header&footer.css">
</head>
<header class="header">
    <div class="container">
        <div class="header-left">
            <a href="index.jsp">
                <img src="https://tienthangvet.vn/wp-content/uploads/logo-tien-thang-vet.jpg" alt=""/>
            </a>
        </div>
        <div class="header-center">
            <div class="header-nav" role="navigation" aria-label="Main navigation">
                <ul class="menu">
                    <li class="menu-item">
                        <a href="./index.html"><span class="nav-link-text">Thuốc Y The Pet</span></a>
                    </li>
                    <li class="menu-item">
                        <a href="./pages/introduce.html"><span class="nav-link-text">Giới thiệu</span></a>
                    </li>
                    <li class="menu-item">
                        <a href="./pages/products.html"><span class="nav-link-text">Sản phẩm</span></a>
                        <div class="container">
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
                        <a href="./pages/contact.html"><span class="nav-link-text">Liên hệ</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="header-right">
            <form role="search" method="get" class="searchform" action="" data-thumbnail="1" data-price="1"
                  data-post_type="product" data-count="20" data-sku="0" data-symbols_count="3">
                <input type="text" class="s" placeholder="Tìm kiếm sản phẩm" value="" name="s" aria-label="Search"
                       title="Search for products" required=""/>
                <input type="hidden" name="post_type" value="product"/>
                <button type="submit" class="searchsubmit">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>
            <div class="action">
                <%if (user == null) { %>
                <a class="sign-in" href="signIn.jsp" style="margin-left: 20px">Đăng nhập</a>
                <%} else {%>
                <div class="cart">
                    <span class="count">3</span>
                    <a href="cart.jsp">
                        <i class="fa-solid fa-cart-shopping material-icons"></i>
                    </a>
                </div>
                <div class="user-dropdown">
                    <i class="fas fa-user fa-2x" style="color: #66b840" id="user-icon"></i>
                    <div class="user-dropdown-content" id="user-dropdown-content">
                        <ul class="user-menu">
                            <li class="user-menu-item">
                                <a href="user_info.jsp"><span class="nav-link-text">Quản lý thông tin cá
                                                nhân</span></a>
                            </li>
                            <li class="user-menu-item">
                                <a href="signout"><span class="nav-link-text">Đăng xuất</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <%}%>
            </div>
        </div>
    </div>
</header>


