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
			<h2>The area requires strict authorities!</h2>
			<br>

			<img class="post" src="${pageContext.request.contextPath}/resources/images/zooey.jpg" style="height:400px;width:300px" />
			<div style="margin-left:7px;margin-top:15px;height:40px;width:250px;">
				<p style="font-size:22px;">Zooey Deschannel</p><br/><div style="border-top:1px solid black;margin-top:-20px;width:145px"><p style="margin-top:2px;">Assistant Librarian</p></div>				
			</div>
			<BR><BR>


			<p>"The page you were trying to access is beyond your limits.</p>
			<p>If you believe you that you should be given access, talk to the Librarian",</p>	
			<p>Zooey says.</p>
			

			</CENTER>

			





		</div>
			

		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	

	</div>


		

</body>

</html>