<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>truYum</title>
	<link rel="stylesheet" href="/style/style.css">
</head>
<body>
	<header>
		<p class="page-title">truYum &nbsp;<img class="logo" src="/images/truyum-logo.png" height="48px" width="48px" alt=""></p>
		<nav>
			<a href="/show-menu-list-customer">Menu</a>
			<a href="/show-cart?userId=1">Cart</a>
		</nav>
	</header>
	<h1 class="menu-title-customer">Menu Items</h1>
	<h3 class="status"><c:if test="${addCartStatus}">Item added to Cart Successfully</c:if></h3>
	<div class="main">
		<table class="menu-list">
			<tr>
				<th class="name-a"><label for="name">Name</label></th>
				<th class="free-dev-a"><label for="free-delivery">Free Delivery</label></th>
				<th class="price-a"><label for="price">Price</label></th>
				<th class="category-a"><label for="category">Category</label></th>
				<th class="action-a"><label for="action">Action</label></th>
			</tr>
			<c:forEach var="menuItem" items="${menuItemListCustomer}">
				<tr>
				    
					<td class="name-a">${menuItem.name}</td>
					<td class="free-dev-a">
					<c:if test="${menuItem.freeDelivery==true}">Yes</c:if>
					<c:if test="${menuItem.freeDelivery==false}">No</c:if>
					</td>
					<td class="price-a">Rs. ${menuItem.price}</td>
					<td class="category-a">${menuItem.category}</td>
					<td class="action-a"><a href="/add-to-cart?menuItemId=${menuItem.id}">Add to Cart</a></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	<footer>copyright &copy; 2019</footer>
</body>
</html>