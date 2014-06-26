<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

			<h3>${user.username} Profile!</h3>
			<br>


			<div id="profile-action">

				<div style="float:left;position:relative;margin-left:34px;margin-right:15px;margin-top:15px;margin-bottom:25px;height:375px;width:230px">
					<!-- ${pageContext.request.contextPath}/resources/images/human.jpg -->
					<div class="polaroid" style="">
						<p style="margin-left:8px;">${user.userDetails.firstname} ${user.userDetails.lastname}</p>
						<img src="${pageContext.request.contextPath}${user.userDetails.picture.location}" style="height:200px;width:200px" />						
					</div>

					<div style="min-height:125px;width:200px;border-top:1px solid black;margin:16px">
						<p style="padding-top:15px;margin-left:12px;">
							<table>
								<tr>
									<td>Name:</td>
									<td>${user.userDetails.firstname} ${user.userDetails.lastname}</td>
								</tr>
								<tr>
									<td>ID Number:</td>
									<td>${user.userDetails.organizationIdNumber}</td>
								</tr>
								<tr>
									<td>Position:</td>
									<td>${user.userDetails.occupation.description}</td>
								</tr>
							</table>
						</p>
					</div>

				</div>

				<div style="float:left;position:relative;margin:15px;min-height:575px;width:550px">

					<div style="padding:7px;min-height:250px;max-width:515px;background-color:white;margin:16px">
						<fieldset>
							<h3>Reserved</h3>
							<h5>Pick up time is before 8PM</h5>
							<table class="table">
								<tr>
									<th>Book</th>
									<th></th>
									
								</tr>
								
								<c:forEach var="reserved" items="${user.libraryCard.books}">
								
								<c:if test="${reserved.borrowed eq null and reserved.returned eq null }">
								
								<tr>
									<td>${reserved.sbook.bookDetails.title}</td>
									<td>
									
										<sec:authorize access="hasRole('ROLE_ADMIN')">
										
											<spring:url value="/books/lendBook" var="allowBorrow">											
												<spring:param name="bookStatusId" value="${reserved.id}" />
												<spring:param name="username" value="${user.username}" />											
											</spring:url>
	 										<a href="${allowBorrow}">Allow Borrow of Book</a>
										
										</sec:authorize>
									
									</td>
								</tr>
								
								</c:if>	
								
								</c:forEach>
								
							</table>
						</fieldset>
					</div>

					<div style="padding:7px;min-height:250px;max-width:515px;background-color:white;margin:16px">
						<fieldset>
							<h3>Borrowed</h3>
							<table class="table">
								<tr>
									<th>Book</th>
									<th>Borrowed</th>
									<th>To Return</th>
									<th></th>
								</tr>
								
								<c:forEach var="reserved" items="${user.libraryCard.books}">
								
								<c:if test="${reserved.borrowed != null and reserved.returned eq null }">
																								
								<tr>
									<td>${reserved.sbook.bookDetails.title}</td>
									<td>${reserved.borrowed}</td>
									<td>${reserved.toReturn}</td>
									<td>
										<sec:authorize access="hasRole('ROLE_ADMIN')">
										
											<spring:url value="/books/returnBook" var="returnBorrow">											
												<spring:param name="bookStatusId" value="${reserved.id}" />
												<spring:param name="username" value="${user.username}" />											
											</spring:url>
	 										<a href="${returnBorrow}">Book returned?</a>
										
										</sec:authorize>
									</td>
								</tr>
								
								</c:if>
								
								</c:forEach>
								
							</table>
						</fieldset>
					</div>

					<div style="padding:7px;min-height:250px;max-width:515px;background-color:white;margin:16px">
						<fieldset>
							<h3>Previously Borrowed</h3>
							<table class="table">
								<tr>
									<th>Book</th>
									<th>Borrowed</th>
									<th>To Return</th>
									<th>Returned</th>
								
								</tr>
								
								<c:forEach var="reserved" items="${user.libraryCard.books}">
								
								<c:if test="${reserved.borrowed != null and reserved.returned != null }">
								
								
								<tr>
									<td>${reserved.sbook.bookDetails.title}</td>
									<td>${reserved.borrowed}</td>
									<td>${reserved.toReturn}</td>
									<td>${reserved.returned}</td>								
								</tr>
								
								</c:if>
								</c:forEach>
								
								
							</table>
							
						</fieldset>
					</div>


				</div>

				

				<!-- <div style="float:left;position:relative;margin:15px;background:black;height:275px;width:180px">

					<div style="height:150px;width:150px;background-color:white;margin:16px"></div>
					<div style="height:75px;width:150px;background-color:white;margin:16px"></div>

				</div> -->


			</div>
			

			

		</div>


		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	</div>

</body>

</html>