<%@page import="beans.User"%>
<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:useBean id="cart" scope="session" class="beans.ShopingCart" />
<jsp:useBean id="db" scope="session" class="beans.DB" />
<jsp:useBean id="item" scope="session" class="beans.InventoryItem" />
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
if(user.isValid())
{
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
