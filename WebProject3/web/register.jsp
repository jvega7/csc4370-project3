<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="htmlheader.jsp"></jsp:include>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Join!</h1>
        <form action ="Register" method="post">
		<table>
		<tr><td>Enter Username:</td><td><input type="text" name="username" value="" ></td></tr>
		<tr><td>Enter Password:</td><td><input type="password" name="password" value="" ></td></tr>
		<tr><td>Verify Password:</td><td><input type="password" name="verify" value="" ></td></tr>
		<tr><td>Enter First Name:</td><td><input type="text" name="first" value="" ></td></tr>
		<tr><td>Enter Last Name:</td><td><input type="text" name="last" value="" ></td></tr>
		<tr><td>Enter Address:</td><td><input type="text" name="address" value="" ></td></tr>
		<tr><td>Enter City:</td><td><input type="text" name="city" value="" ></td></tr>
		<tr><td>Enter State:</td><td><input type="text" maxlength="2" name="state" value="" ></td></tr>
		<tr><td>Enter Zip Code:</td><td><input type="text" maxlength="5" name="zipcode" value="" ></td></tr>
		<tr><td>Enter Phone:</td><td><input type="text" maxlength="10" name="phone" value="" ></td></tr>
		<tr><td>Enter Email:</td><td><input type="text" name="email" value="" ></td></tr>
		</table>
            <input type="submit" value="Register" name="register" >
        </form>
		<br/>
		<p><% out.print(session.getAttribute("exists"));%> </p>
	<jsp:include page="htmlfooter.html" ></jsp:include>
