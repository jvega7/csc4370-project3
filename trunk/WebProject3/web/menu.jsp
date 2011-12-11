<%@page import="beans.User"%>
<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="header">
	<div id="menu">
    <ul>
        <li>
<h2><a href="Menu?index=0">Shop</a></h2>
        </li>
<%
if(user.isValid())
{
%>
        <li>
<h2><a href="Menu?index=3">View Profile & Order History</a></h2>
</li>
        <li>
<h2><a href="Menu?index=7">Logout</a></h2>
</li>

<%
}else{
	session.setAttribute("checkout", "Welcome");
%>
        <li>
<h2><a href="Menu?index=5">Register</a></h2>
</li>
<%
}
%>
</ul>
	</div>
	<!-- end #menu -->
	<div id="logo">
		<h1><a href="#">Hüten Sie sich vor Krampus!</a></h1>
	</div>
</div>
<!-- end #header -->
<!-- end #header-wrapper -->
<!-- end #logo -->
