<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html>

<head>
	<title></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
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
			<center>
			<h3>Login User!</h3>
			<br>

			<img  class="post" src="${pageContext.request.contextPath}/resources/images/front.jpg" style="height:200px;width:500px" />
			<BR><BR>
			
			<c:if test="${error != ''}">
				<div class="errorblock">${error}</div>
			</c:if>		

			<form action="j_spring_security_check" method="POST">

				<table>
				
				<tr>
					<td>Username:</td>
					<td><input id="j_username" name="j_username" type="text" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><input id="j_password" name="j_password" type="text" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input style="float:right" class="btn btn-success" type="submit" value="Login" /></td>
				</tr>

				</table>

			</form>


			</center>
		</div>
			

			

		</div>


		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	</div>

</body>

</html>