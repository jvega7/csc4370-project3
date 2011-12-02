<jsp:useBean id="bean" scope="session" class="beans.User" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu">
    <ul>
        <li>
<a href="Menu?index=0">Main</a>
        </li>
        <li>
<a href="Menu?index=1">Inventory</a>
</li>
<%
if(session.getAttribute("username")!=null && session.getAttribute("username")!="")
{
String user = session.getAttribute("username").toString();
%>
 <li>
<a href="Menu?index=2">View Cart</a>
</li>
        <li>
<a href="Menu?index=3">Profile(past orders)</a>
</li>
        <li>
<a href="Menu?index=7">Logout</a>
</li>

<%
}else{
%>
        <li>
<a href="Menu?index=4">Login</a>
</li>
        <li>
<a href="Menu?index=5">Register</a>
</li>
<%
}
%>
</ul>
</div>
