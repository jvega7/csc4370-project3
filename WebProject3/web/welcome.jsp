<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; 
charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
	    <h1>Welcome <jsp:getProperty name="user" property="firstName"/>
		    <jsp:getProperty name="user" property="lastName" /></h1>
        <jsp:include page="menu.jsp"></jsp:include>
    </body>
</html>
