<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>truYum</title>
<link rel="stylesheet" href="/style/style.css">
</head>
<body>
	<header>
		<p class="page-title">
			truYum &nbsp;<img class="logo" src="/images/truyum-logo.png"
				height="48px" width="48px" alt="">
		</p>
		<nav>
			<a href="/show-menu-list-customer">Menu</a> 
			<a href="/show-cart?userId=1">Cart</a>
		</nav>
	</header>
	<h1 class="menu-title-cart">Cart</h1>
	<h3 class="status"><c:if test="${removeCartItemStatus}">Item removed from Cart successfully</c:if></h3>
	<div class="main">
		<table class="cart-details">


			<tr>
				<th class="name-cart"><label for="name-cart">Name</label></th>
				<th class="free-dev-cart"><label for="free-delivery-cart">Free
						Delivery</label></th>
				<th class="price-cart"><label for="price-cart">Price</label></th>
				<th class="category-cart"><label for="category-cart">Category</label></th>
			</tr>

			<c:forEach var="usercart" items="${cart}">
				<tr>
					<td class="name-cart">${usercart.name}</td>
					<td class="free-dev-cart"><c:if
							test="${usercart.freeDelivery==true}">Yes</c:if> <c:if
							test="${usercart.freeDelivery==false}">No</c:if></td>
					<td class="price-cart">Rs. ${usercart.price}</td>
					<td class="category-cart">${usercart.category}</td>
					<td class="action-cart"><a href="/remove-cart?menuItemId=${usercart.id}&userId=1">Delete</a></td>
				</tr>

			</c:forEach>
            <tr>
				<td></td>
				<td class="free-dev-cart"><strong>Total</strong></td>
				<td class="price-cart"><strong>Rs. ${total}</strong></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
	<footer>copyright &copy; 2019</footer>
</body>
</html>