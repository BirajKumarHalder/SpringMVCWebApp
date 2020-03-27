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
	<jsp:useBean id="loggedInUser" class="com.tutorials.models.User"
		scope="session" />
	<div class="container mt-2">
		<%
			com.tutorials.models.User user = (com.tutorials.models.User) session.getAttribute("loggedInUser");
			pageContext.setAttribute("userRole", "pagecontextuser");
			if (user.getUserRole().equals("Admin")) {
		%>
		<div class="alert alert-success rounded-0" role="alert">
			Admin home (Welcome
			<jsp:getProperty property="userName" name="loggedInUser" />)
		</div>
		<%
			} else {
		%>
		<div class="alert alert-warning rounded-0" role="alert">
			User home (Welcome
			<jsp:getProperty property="userName" name="loggedInUser" />)
		</div>
		<%
			}
		%>
		<div class="card mx-auto mt-4">
			<div class="card-body">
				<h5 class="card-title">
					You have logged in this page as
					<%=pageContext.getAttribute("userRole")%></h5>
				<p>
					<a href="retrieveUserDetails?&userId=<%=user.getUserId()%>">View
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