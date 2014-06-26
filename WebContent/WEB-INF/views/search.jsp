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

			<h3>Welcome to The Online Bookstore!</h3>
			<br>

			<div style="float:left;position:relative;margin-left:34px;margin-right:15px;margin-top:15px;margin-bottom:25px;min-height:910px;width:810px">

					<div style="min-height:60px;min-width:515px;background-color:white;margin:16px">
						<br>
						<form  action="${pageContext.request.contextPath}/searchBooks" method="post">
						<table style="margin-left:90px;padding:6px;">
							<tr >
								<td>Search Bar:</td>
								<td><input type="text" name="searchText" /></td>	
								<td>
									<select name="searchCategory">
										<option value="title">Title</option>
										<option value="author">Author</option>
										<option value="publisher">Publisher</option>
										<option value="isbn">ISBN</option>
										<option value="category">Category</option>
									</select>
								</td>							
								<td><input type="submit" value="Search" class="btn btn-success" /></td>
							</tr>
						</table>							
						</form>
					</div>


					<div style="min-height:850px;min-width:515px;background-color:white;margin:16px">
						
						<c:if test="${booksSearched != null }">
						
							<c:forEach items="${booksSearched}" var="book">
							
							<spring:url value="/bookProfile" var="viewBook">
								<spring:param name="id" value="${book.id}" />
							</spring:url>
							
							
							<div class="thumbnail" style="float:left;position:relative;margin:12px;height:305px;width:220px">
								<div style="height:150px;width:190px;background-color:white;margin:16px">
									<img src="${pageContext.request.contextPath}${book.bookDetails.picture.location}" style="height:150px;width:150px;margin-left:20px" />
								</div>
								<div style="height:105px;width:190px;background-color:white;margin:16px">
								
									<table style="font-size:11px;">
										<tr>
											<td>Title</td>
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
											<td>ISBN:</td>
											<td>${book.bookDetails.ISBN}</td>
										</tr>
										<tr>
											<td>Publisher</td>
											<td>${book.bookDetails.publisher}</td>
										</tr>
										<tr>
											<td>Published:</td>
											<td>${book.bookDetails.published}</td>
										</tr>
										<tr>
											<td></td>
											<td><a href="${viewBook}">View this Book!</a></td>
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