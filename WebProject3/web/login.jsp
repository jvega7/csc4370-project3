<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="htmlheader.jsp"/> 
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
