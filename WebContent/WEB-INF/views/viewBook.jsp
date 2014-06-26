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

			<h3>Twilight Page</h3>
			<br>


			<div id="book-action">

				<div style="float:left;position:relative;margin-left:34px;margin-right:15px;margin-top:15px;margin-bottom:25px;min-height:375px;width:230px">

					<div style="height:200px;width:200px;background-color:white;margin:16px">
						<img class="post" src="${pageContext.request.contextPath}${book.bookDetails.picture.location}" style="height:200px;width:200px;" />
					</div>
					<br>
					<div style="min-height:125px;width:240px;background-color:white;margin:0 auto">
						<p style="padding-top:15px;margin-left:12px;">
							<table>
								<tr>
									<td>Title:</td>
									<td>${book.bookDetails.title}</td>
								</tr>
								<tr>
									<td>Author:</td>
									<td>${book.bookDetails.author}</td>
								</tr>
								<tr>
									<td>Category:</td>
									<td>${book.bookDetails.category.description}</td>
								</tr>
								<tr>
									<td>Publisher:</td>
									<td>${book.bookDetails.publisher}</td>
								</tr>
								<tr>
									<td>ISBN:</td>
									<td>${book.bookDetails.ISBN}</td>
								</tr>
							</table>
						</p>
					</div>

				</div>

				<div style="float:left;position:relative;margin:15px;min-height:275px;width:550px">
					
					<div style="min-height:10px;min-width:515px;background-color:white;margin:16px">
							
						<table style="margin-left:290px;padding:6px;">
							<tr >
								
								<spring:url value="/reserveBook" var="reserveBook">
									<spring:param name="id" value="${book.id}" />
								</spring:url>
							
								<td>Stock Remaining:</td>
								<td>${book.bookStatistics.stock}</td>							
								<td>
									<c:if test="${book.bookStatistics.stock ne 0 and book.bookStatistics.forPublic eq true }">
									<a href="${reserveBook}" class="btn btn-success">Reserve!</a>
									</c:if>
								</td>
								
							</tr>
						</table>							
						
					</div>

					<div style="padding:5px;min-height:150px;max-width:515px;background-color:white;margin:16px">
						
						<h3>Description</h3>
						<p>${book.bookDetails.description}</p>
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