<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<c:set var="user" value='${requestScope["user"]}' />
				<p>
					Name :
					<c:out value='${user.userName}'></c:out>
				</p>
				<p>
					Email :
					<c:out value='${user.userEmail}'></c:out>
				</p>
				<p>
					Contact :
					<c:out value='${user.userContact}'></c:out>
				</p>
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
