<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
<head>
<body>
	<jsp:include page="resources.jsp" />
	<div class="container mt-2">
		<div class="card mx-auto mt-4" style="width: 60rem;">
			<div class="card-body">
				<div class="alert alert-danger" role="alert">Error information
				</div>
				<c:if test='${not empty requestScope["exceptionType"]}'>
					<c:out value='${requestScope["exceptionType"]}'></c:out>
				</c:if>
				<c:if test='${not empty requestScope["exceptionMessage"]}'>
					<c:out value='${requestScope["exceptionMessage"]}'></c:out>
				</c:if>
				<c:if test='${empty requestScope["exceptionMessage"]}'>
  Unknown error occured
</c:if>
				<p>
					<a href="login">Login here</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>