<!DOCTYPE>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
	<title></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
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
			<li><a href="search.php">THE LIBRARY</a></li>
			<li><a href="search.php">FAQ</a></li>
			<li><a href="search.php">CONTACT US</a></li>
			</ul>
			</center>
		</div>


		<div id="content" style="padding:40px">

			<h3>Book Registration Page!</h3>
			<br>

			<img src="${pageContext.request.contextPath}/resources/images/front.jpg" style="height:200px;width:500px" />
			<BR><BR>

			<form:form method="POST" commandName="book" enctype="multipart/form-data">
			<form:errors path="*" cssClass="errorblock" element="div"/>			
			

				<table>
				
				<tr>
					<td>Title:</td>
					<td><form:input path="bookDetails.title" /></td>
					<td><form:errors path="bookDetails.title" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Author:</td>
					<td><form:input path="bookDetails.author" /></td>
					<td><form:errors path="bookDetails.author" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Published:</td>
					<td><form:input path="bookDetails.published" /></td>
					<td><form:errors path="bookDetails.published" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Publisher:</td>
					<td><form:input path="bookDetails.publisher" /></td>
					<td><form:errors path="bookDetails.publisher" cssClass="error" /></td>
				</tr>

				<tr>
					<td>ISBN:</td>
					<td><form:input path="bookDetails.ISBN" /></td>
					<td><form:errors path="bookDetails.ISBN" cssClass="error" /></td>
				</tr>
				
				<tr>
					<td>Description:</td>
					<td><form:textarea path="bookDetails.description" rows="5" cols="30"/></td>
					<td><form:errors path="bookDetails.description" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Category:</td>
					<td>
						<form:select path="bookDetails.category">
							<form:options items="${categoryList}" itemValue="id" itemLabel="description" />
						</form:select>					
					</td>
					<td><form:errors path="bookDetails.category" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Stock:</td>
					<td><form:input path="bookStatistics.stock" /></td>
					<td><form:errors path="bookStatistics.stock" cssClass="error" /></td>
				</tr>

				<tr>
					<td>For Public:</td>
					<td><form:checkbox path="bookStatistics.forPublic" value="1"/><td>
					<td><form:errors path="bookStatistics.forPublic" cssClass="error" /></td>
				</tr>
				
				<tr>
					<td>Book Image:</td>
					<td><form:input path="bookDetails.picture.image" type="file"/></td>
					<td><form:errors path="bookDetails.picture.image" cssClass="error" /></td>
				</tr>

				


				<tr>
					<td></td>
					<td><input style="float:right" class="btn btn-success" type="submit" value="Register" /></td>
				</tr>

				</table>

			</form:form>

		



		<!-- </div>  -->
			

			

		</div>


		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	</div>

</body>

</html>