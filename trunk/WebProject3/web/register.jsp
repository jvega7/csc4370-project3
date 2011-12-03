<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; 
charset=UTF-8">
        <title>Shopping</title>
    </head>
    <body>
        <h1>Register</h1>
        <jsp:include page="menu.jsp"></jsp:include>
        <form action ="Register" method ="POST">
            <div>Create Username: <input type="text" name="username" value="" /></div>
            <div>Create Password: <input type="password" name="password" value="" /></div>
            <div>Verify Password: <input type="password" name="verifypass" value="" /></div>
            <input type="submit" value="Register" name="register" />
        </form>
    </body>
</html>
