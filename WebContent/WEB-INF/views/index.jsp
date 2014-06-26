<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
	


<html>

<head>
<title></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link href='http://fonts.googleapis.com/css?family=Niconne' rel='stylesheet' type='text/css'>
</head>

<body>
	<div id="container">
		
		<div id="header"><br><br><center><h1>Lavigne Library</h1></center><br></div>
		
		<div id="navi">
						
			<spring:url value="/home" var="home"/>
			<spring:url value="/searchBooks" var="books"/>
			<spring:url value="/about" var="about"/>
		
			<br>
			<center>
			<ul>
			<li><a href="${home}">HOME</a></li>
			<li><a href="${books}">BOOKS</a></li>
			<li><a href="${about}">THE LIBRARY</a></li>
			</ul>
			</center>
		</div>
		
		
		
		<!-- CONTENT CHANGES STARTS HERE -->
		
		
		<div id="content" style="padding:40px">
		
			<div>
				
				<sec:authorize access="hasRole('ROLE_USER')">
				
					<spring:url value="/profile" var="user"/>
	 				<a style="float:right" class="btn" href="${user}"><i class="icon-user"></i>Go to myProfile</a>
					<br>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					
					<spring:url value="/adminpanel" var="admin"/>
	 				<a style="float:right" class="btn" href="${admin}"><i class="icon-user"></i>Go to myAdminPanel</a>
					<br>
				</sec:authorize>
			
			</div>
		
			<h3>Welcome to The Online Bookstore!</h3>
			<br>
			
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			<BR>
			<CENTER>
				<img class="post" src="${pageContext.request.contextPath}/resources/images/front.jpg" style="width:500px;height:230px" />
				<br><br>
				
				<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
					<spring:url value="/login" var="login"/>
					<spring:url value="/users/add" var="register"/>
				
					<a href="${register}"><button class="btn btn-success">I got a Key!</button></a>
					<a href="${login}"><button class="btn btn-success">Login</button></a>
					
				</sec:authorize>
					
			</CENTER>
			<BR><BR>
			
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			
		
		</div>
		
		
		<!-- CONTENT CHANGES ENDS HERE -->
		
		
		
		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	</div>

</body>

</html>