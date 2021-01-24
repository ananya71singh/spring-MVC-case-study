<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>truYum</title>
<link rel="stylesheet" href="/style/style.css">
<script src="/js/script.js"></script>
</head>
<body>
	<header>
		<p class="page-title">
			truYum &nbsp;<img class="logo" src="/images/truyum-logo.png"
				height="48px" width="48px" alt="">
		</p>
		<nav>
			<a href="/show-menu-list-admin">Menu</a>
		</nav>
	</header>
	<h1 class="menu-title-edit">Edit Menu Item</h1>
	<div class="main">
		<sf:form action="edit-menu-item" modelAttribute="menuItem"
			method="POST">
			<table class="edit-menu-item">
				<tr>
					<td class="name"><sf:label path="name">Name</sf:label></td>
				</tr>
				<tr>
					<td colspan="4"><sf:input path="name" id="name" name="name" /></td>
				</tr>
				<tr>
					<td class="name"><span id="errors"><sf:errors path="name" /> </span></td>
				</tr>
				<tr>
					<td><sf:hidden path="id" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td class="price"><sf:label path="price">Price (Rs.)</sf:label></td>
					<td class="active"><sf:label path="active">Active</sf:label></td>
					<td class="date-of-launch"><sf:label path="dateOfLaunch">Date of Launch</sf:label></td>
					<td class="category"><sf:label path="category">Category</sf:label></td>
				</tr>

				<tr>
					<td><sf:input path="price" /></td>
					<td>
					    <sf:radiobutton path="active" name="inStock" id="active" value="Yes" />Yes
					    <sf:radiobutton path="active" name="inStock" id="active" value="No" />No
				    </td>
					<td><sf:input path="dateOfLaunch" name="date-of-launch" id="date-of-launch" onchange="validateMenuItemForm()" /></td>
					<td><sf:select path="category" id="category" items="${categoryList}" /></td>
				</tr>
				<tr>
					<td class="price">
					     <span id="errors"><sf:errors path="price" /></span>
					</td>
					<td class="active"></td>
					<td class="date-of-launch"><span id="errors"><sf:errors path="dateOfLaunch" /></span></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td class="free-dev"><sf:checkbox path="freeDelivery" id="free-dev" /> <sf:label path="freeDelivery">Free Delivery</sf:label></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" id="submit" value="Save" /></td>
				</tr>
			</table>
		</sf:form>
	</div>
	<footer>copyright &copy; 2019</footer>
</body>
</html>