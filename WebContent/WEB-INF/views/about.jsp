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
		


		<div id="content" style="padding:40px">

			<h3>Message From The Librarian</h3>
			<br>

			<div style="float:left;position:relative;margin:15px;height:575px;width:880px">
				<div style="float:left;height:400px;width:250px;margin:16px">
					<img class="post" src="${pageContext.request.contextPath}/resources/images/librarian.jpg" style="width:250px;height:340px" />
				<div style="margin-left:7px;margin-top:15px;height:40px;width:250px;"><center><p style="font-size:22px;">Avril Lavigne</p><br/><div style="border-top:1px solid black;margin-top:-20px;width:145px"><p style="margin-top:2px;">Librarian</p></div></center></div>
				</div>
				<div style="margin-top:40px;margin-left:36px;margin-right:16px;float:left;height:275px;width:525px;">

					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla lobortis eros ac mi tincidunt viverra imperdiet massa placerat. Praesent bibendum vestibulum mollis. Nam tincidunt mauris laoreet elit fringilla vitae iaculis massa suscipit. Sed vel mi sapien, id rutrum ligula. In tincidunt neque accumsan purus adipiscing ornare. Ut volutpat sodales elit, sit amet feugiat velit semper ac. Ut dolor sapien, tristique at ultrices et, elementum sed tellus. Donec congue tincidunt urna vel vestibulum. Praesent congue rhoncus metus et lacinia. Duis feugiat ante ut massa tincidunt suscipit. Proin et ligula sit amet nulla sodales sollicitudin non et justo. Proin a lacus metus, in egestas lorem. Praesent eleifend nisl id ante condimentum ac vulputate lectus pharetra. Aenean euismod nibh et dui porttitor et vehicula eros suscipit.</p>

					<p>Suspendisse volutpat dui in lacus auctor sit amet eleifend diam pulvinar. Curabitur nunc tellus, semper eu porta elementum, pellentesque sit amet ligula. Donec sem est, scelerisque nec interdum vitae, adipiscing non tortor. Sed elit eros, malesuada eu molestie ac, iaculis id nisl. In sodales malesuada lobortis. Cras dui felis, convallis quis rutrum nec, varius et dui. Phasellus elementum imperdiet orci id volutpat. Sed a nisl ipsum, a commodo neque. Sed non sem justo, et tempus odio. </p>




				</div>
			</div>


		</div>


		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	</div>

</body>

</html>