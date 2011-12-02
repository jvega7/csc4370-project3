<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; 
charset=UTF-8">
        <title>Shopping</title>
    </head>
    <body>
        <h1>Profile</h1>
	<div class="menu">
        <jsp:include page="menu.jsp"></jsp:include>
	</div>
	<div class="profile">
		<table>
			<tr>
				<td>Username:</td>
				<td><jsp:getProperty name="user" property="username" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><jsp:getProperty name="user" property="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><jsp:getProperty name="user" property="lastName" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><jsp:getProperty name="user" property="address" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><jsp:getProperty name="user" property="city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><jsp:getProperty name="user" property="state" /></td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td><jsp:getProperty name="user" property="zipcode" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><jsp:getProperty name="user" property="phone"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><jsp:getProperty name="user" property="email" /></td>
			</tr>
		</table>
	</div>
    </body>
</html>
