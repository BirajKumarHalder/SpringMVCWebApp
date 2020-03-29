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
		<c:set var="user" value='${sessionScope["loggedInUser"]}' />
		<c:if test='${user.userRole == "Admin"}'>
			<div class="alert alert-success rounded-0" role="alert">
				Admin home (Welcome
				<c:out value='${user.userName}'></c:out>
				)
			</div>
		</c:if>
		<c:if test='${user.userRole == "User"}'>
			<div class="alert alert-warning rounded-0" role="alert">
				User home (Welcome
				<c:out value='${user.userName}'></c:out>
				)
			</div>
		</c:if>
		<div class="card mx-auto mt-4">
			<div class="card-body">
				<h5 class="card-title">
					You have logged in this page as
					<c:out value='${user.userRole}'></c:out>
				</h5>
				<p>
					<a
						href="retrieveUserDetails?&userId=<c:out value='${user.userId}'></c:out>">View
						Details</a>
				</p>
				<p>
					<a href="logout">Logout here</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>