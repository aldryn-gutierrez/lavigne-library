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

			<h3>Administrator Panel!</h3>
			<br>

			<CENTER><img src="${pageContext.request.contextPath}/resources/images/front.jpg" style="height:200px;width:500px" /></CENTER>
			<BR><BR>

			<div id="admin-action">

				<!-- <div style="float:left;position:relative;margin-left:134px;margin-right:15px;margin-top:15px;margin-bottom:25px;background:black;height:275px;width:180px">

					<div style="height:150px;width:150px;background-color:white;margin:16px">
						<img src="${pageContext.request.contextPath}/resources/images/key.jpg" style="height:150px;width:150px" />
					</div>

					<div style="height:75px;width:150px;background-color:white;margin:16px">
						<p style="padding-top:15px;margin-left:12px;">Show Serial Keys</p>
					</div>

				</div> -->

				<div style="float:left;position:relative;margin-left:234px;margin-top:15px;margin-right:15px;background:black;height:275px;width:180px">

					<div style="height:150px;width:150px;background-color:white;margin:16px">
						<img src="${pageContext.request.contextPath}/resources/images/human.jpg" style="height:150px;width:150px" />
					</div>

					<div style="height:75px;width:150px;background-color:white;margin:16px">						
						
						<spring:url value="/searchUsers" var="searchUsers"/>	 				
												
						<p style="padding-top:15px;margin-left:12px;"><a href="${searchUsers}">Search Users</a></p>
					</div>

				</div>

				<div style="float:left;position:relative;margin:15px;background:black;height:275px;width:180px">

					<div style="height:150px;width:150px;background-color:white;margin:16px">
						<img src="${pageContext.request.contextPath}/resources/images/book.jpg" style="height:150px;width:150px" />
					</div>

					<div style="height:75px;width:150px;background-color:white;margin:16px">
						
						<spring:url value="/books/add" var="addBook"/>	 				
						<p style="padding-top:12px;margin-left:12px;">
							<a href="${addBook}">Add Books</a>
						</p>
						
						<spring:url value="/searchBooks" var="searchBooks"/>
						<p style="margin-left:12px;"><a href="${searchBooks}">Search Books</a></p>
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