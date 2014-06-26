<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

			<h3>Welcome to The Online Bookstore!</h3>
			<br>

			<div style="float:left;position:relative;margin-left:34px;margin-right:15px;margin-top:15px;margin-bottom:25px;min-height:710px;width:810px">

					<div style="min-height:60px;min-width:515px;background-color:white;margin:16px">
						<form action="${pageContext.request.contextPath}/searchUsers" method="post">
						<table style="margin-left:90px;padding:6px;">
							<tr >
								<td>Search Bar:</td>
								<td><input type="text" name="searchText" /></td>	
								<td>
									<select name="searchCategory">
										<option value="username">Username</option>
										<option value="firstname">First Name</option>
										<option value="lastname">Last Name</option>
										<option value="organizationId">Organization ID</option>
										<option value="occupation">Occupation</option>
									</select>
								</td>							
								<td><input type="submit" value="Search" class="btn btn-success" /></td>
							</tr>
						</table>							
						</form>
					</div>


					<div style="min-height:650px;min-width:515px;background-color:white;margin:16px">
						
						<c:if test="${usersSearched != null }">
						
							<c:forEach items="${usersSearched}" var="user">
							
							<spring:url value="/profile" var="viewProfile">
								<spring:param name="username" value="${user.username}" />
							</spring:url>
							
							
							<div class="thumbnail" style="float:left;position:relative;margin:12px;min-height:305px;width:220px">
								<div style="min-height:150px;width:190px;background-color:white;margin:16px">
									<img src="${pageContext.request.contextPath}${user.userDetails.picture.location}" style="height:150px;width:150px;margin-left:20px" />
								</div>
								<div style="min-height:105px;width:190px;background-color:white;margin:16px">
								
									<table style="font-size:11px;">
										<tr>
											<td>Username</td>
											<td>${user.username}</td>
										</tr>
										<tr>
											<td>Name:</td>
											<td>${user.userDetails.firstname} ${user.userDetails.lastname}</td>
										</tr>										
										<tr>
											<td>Organization Id:</td>
											<td>${user.userDetails.organizationIdNumber}</td>
										</tr>
										<tr>
											<td>Occupation:</td>
											<td>${user.userDetails.occupation.description}</td>
										</tr>										
										<tr>
											<td></td>
											<td><a href="${viewProfile}">View this Profile!</a></td>
										</tr>
									</table>
									
								</div>
							</div>	
						
							</c:forEach>
						
						</c:if>

<%-- 						<div style="float:left;position:relative;margin:15px;background:black;height:275px;width:180px">
							<div style="height:150px;width:150px;background-color:white;margin:16px">
								<img src="${pageContext.request.contextPath}/resources/images/book.jpg" style="height:150px;width:150px" />
							</div>
							<div style="height:75px;width:150px;background-color:white;margin:16px"></div>
						</div>
				
						<div style="float:left;position:relative;margin:15px;background:black;height:275px;width:180px">
							<div style="height:150px;width:150px;background-color:white;margin:16px">
								<img src="${pageContext.request.contextPath}/resources/images/book.jpg" style="height:150px;width:150px" />
							</div>
							<div style="height:75px;width:150px;background-color:white;margin:16px"></div>
						</div>

						<div style="float:left;position:relative;margin:15px;background:black;height:275px;width:180px">
							<div style="height:150px;width:150px;background-color:white;margin:16px">
								<img src="${pageContext.request.contextPath}/resources/images/book.jpg" style="height:150px;width:150px" />
							</div>
							<div style="height:75px;width:150px;background-color:white;margin:16px"></div>
						</div>	

						<div style="float:left;position:relative;margin:15px;background:black;height:275px;width:180px">
							<div style="height:150px;width:150px;background-color:white;margin:16px">
								<img src="${pageContext.request.contextPath}/resources/images/book.jpg" style="height:150px;width:150px" />
							</div>
							<div style="height:75px;width:150px;background-color:white;margin:16px"></div>
						</div>
				
						<div style="float:left;position:relative;margin:15px;background:black;height:275px;width:180px">
							<div style="height:150px;width:150px;background-color:white;margin:16px">
								<img src="${pageContext.request.contextPath}/resources/images/book.jpg" style="height:150px;width:150px" />
							</div>
							<div style="height:75px;width:150px;background-color:white;margin:16px"></div>
						</div> --%>

						



						

					</div>

					
	
					
					


				</div>




		</div>


		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	</div>

</body>

</html>