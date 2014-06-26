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

			<h3>Are you sure, User?</h3>
			<br>

			<CENTER><img src="${pageContext.request.contextPath}/resources/images/FRONT.jpg" style="height:200px;width:500px" />
			<BR><BR>

			<P>You are currently reserving this book...</P>

			<form action="" method="">

				<table>
				
				<tr>
					<td colspan="2"><img src="${pageContext.request.contextPath}/resources/images/book.jpg" style="height:180px;width:200px" /></td>
				</tr>

				<tr>
					<td>Title:</td>
					<td>Twilight</td>
				</tr>
				<tr>
					<td>Author:</td>
					<td>Stephanie Meyer</td>
				</tr>
				<tr>
					<td>Category:</td>
					<td>Horror</td>
				</tr>
				<tr>
					<td>Publisher:</td>
					<td>Manning Co.</td>
				</tr>
				<tr>
					<td>ISBN:</td>
					<td>1234567899</td>
				</tr>

				</table>

			</form>


			<P>Pick up time is on or before 8:00 PM</P>


			<P>
				Are you sure you want this book?
				<button class="btn btn-success">Yes</button>
				<button class="btn btn-danger">No</button>
			</P>




			</CENTER>



		</div>
			

			

		</div>


		<div id="footer"><p style="float:right;margin:5px"><br>&copy; aldryn.com 2011. All rights reserved.</p></div>
	
	</div>

</body>

</html>