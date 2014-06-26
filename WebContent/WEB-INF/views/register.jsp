<!DOCTYPE>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<h3>Registration Page!</h3>
			<br>

			<img class="post" src="${pageContext.request.contextPath}/resources/images/front.jpg" style="height:200px;width:500px" />
			<BR><BR>

			<form:form method="POST" commandName="user" enctype="multipart/form-data">
			<form:errors path="*" cssClass="errorblock" element="div"/>			
			
				<table>
				
				<tr>
					<td>Serial Key:</td>
					<td><form:input path="serialKey.serialKey" /></td>
					<td><form:errors path="serialKey.serialKey" cssClass="error" /></td>
				</tr>
				
				<tr>
					<td>Username:</td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Retype Password:</td>
					<td><form:password path="confirmPassword" /></td>
					<td><form:errors path="confirmPassword" cssClass="error" /></td>
				</tr>

				<tr>
					<td>First Name:</td>
					<td><form:input path="userDetails.firstname" /></td>
					<td><form:errors path="userDetails.firstname" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><form:input path="userDetails.lastname" /></td>
					<td><form:errors path="userDetails.lastname" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Id Number:</td>
					<td><form:input path="userDetails.organizationIdNumber" /></td>
					<td><form:errors path="userDetails.organizationIdNumber" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Occupastion:</td>
					<td>
						<form:select path="userDetails.occupation">
							<form:options items="${occupationList}" itemValue="id" itemLabel="description" />
						</form:select>					
					</td>
					<td><form:errors path="userDetails.occupation" cssClass="error" /></td>
				</tr>
				
				<tr>
					<td>Profile Image:</td>
					<td><form:input path="userDetails.picture.image" type="file"/></td>
					<td><form:errors path="userDetails.picture.image" cssClass="error" /></td>
				</tr>


				<tr>
					<td></td>
					<td><input style="float:right" class="btn btn-success" type="submit" value="Register" /></td>
				</tr>

				</table>

			</form:form>


			</center>

		</div>
			

			

		</div>


		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	</div>

</body>

</html>