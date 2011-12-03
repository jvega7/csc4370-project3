<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; 
charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <jsp:include page="menu.jsp"></jsp:include>
	<form action="Login" method="POST">
		<div>Username:<input type="text" name="username" value="" /></div>
		<div>Password:<input type="password" name="password" value="" /></div>
		<div><input type="submit" value="Submit" name="submit" /></div>
	</form>
    </body>
</html>
