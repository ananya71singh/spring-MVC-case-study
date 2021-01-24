<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1 class="menu-title-cart">Cart</h1>
	<div class="main">
		<h3 class="no-items-in-cart">No items in the cart. Use 'Add to Cart' option in <a class="menu-link" href="/show-menu-list-customer">Menu Item List</a></h3>
	</div>
	<footer>copyright &copy; 2019</footer>
</body>
</html>