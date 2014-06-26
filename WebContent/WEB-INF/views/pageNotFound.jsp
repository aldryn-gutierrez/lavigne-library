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
		
		<div id="header"><br><br><center><A href="index.php"><h1>Lavigne Library</h1></A></center><br></div>
		
		<div id="navi">
			<br>
			<center>
			<ul>
			<li><a href="index.php">HOME</a></li>
			<li><a href="view.php">BOOKS</a></li>
			<li><a href="search.php">SEARCH</a></li>
			</ul>
			</center>
		</div>
		
		<div id="content" style="padding:40px">

			<CENTER>
			<h2>Hey There Explorer!</h2>
			<br>

			<img class="post" src="${pageContext.request.contextPath}/resources/images/dora.jpg" style="height:400px;width:330px" />
			<BR><BR>

			<p>The page you were looking for was currently not found.</p>
			<p>Perhaps you were exploring the url or the page is temporarily not on the Map.</p>	

			

			</CENTER>



		</div>
			

		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	

	</div>


		

</body>

</html>