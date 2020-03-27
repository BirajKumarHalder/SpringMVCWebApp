<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<head>
<body>
<jsp:include page="resources.jsp" />
<jsp:include page="header.jsp" />
<div class="container mt-2">
	<div class="card mx-auto mt-4" style="width: 30rem;">
		<div class="card-body">
			<c:set var="errorMsg" value='${requestScope["error"]}' />
			<c:if test='${not empty errorMsg}'>
				<div class="alert alert-danger" role="alert">
					<c:out value='${errorMsg}'></c:out>
				</div>
			</c:if>
			<h5 class="card-title">Provide credentials</h5>
			<form action="login.htm" method="post">
				<div class="form-group">
					<label for="userId">User Id</label> <input type="text"
						class="form-control" id="userId" name="userId">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" name="password">
				</div>
				<button type="submit" class="btn btn-primary btn-block">Login</button>
			</form>
		</div>
	</div>
</div>


</body>
</html>