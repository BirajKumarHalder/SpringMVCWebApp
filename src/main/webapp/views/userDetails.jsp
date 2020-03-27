<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<head>
<body>
	<jsp:include page="resources.jsp" />
	<jsp:include page="header.jsp" />
	<div class="container mt-2">
		<div class="card mx-auto my-2">
			<div class="card-body">
				<div class="alert alert-light rounded-0" role="alert">User
					details</div>
				<%
					com.tutorials.models.User user = (com.tutorials.models.User) request.getAttribute("user");
				%>
				<p>
					Name :
					<%=user.getUserName()%></p>
				<p>
					Email :
					<%=user.getUserEmail()%></p>
				<p>
					Contact :
					<%=user.getUserContact()%></p>
				<h5 class="card-title">
					You have logged in this page as
					<%=pageContext.getAttribute("userRole")%></h5>
				<p>
					<a href="home">Home</a>
				</p>
				<p>
					<a href="logout">Logout here</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
