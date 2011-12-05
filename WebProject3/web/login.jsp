<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="htmlheader.jsp"/> 
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Login</h1>
	<form action="Login" method="POST">
		<table>
			<tr><th>Enter Username</th><td><div class="entry"><input type="text" name="username" value="" /></div></td></tr>
			<tr><th>Enter Password</th><td><div class="entry"><input type="password" name="password" value="" /></div></td></tr>
		</table>
		<div><input type="submit" value="Submit" name="submit" /></div>
	</form>
<jsp:include page="htmlfooter.html" />
