<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar">
	<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart"></jsp:useBean>
	<jsp:useBean id="user" scope="session" class="beans.User"></jsp:useBean>
<%
	if(!cart.getCartList().isEmpty() && user.getFirstName() != null){
%>
<h1>Shopping Cart</h1>
	<%
	}%>
<ul>
<%
	for(int i = 0; i < cart.getCartList().size(); i++){
		session.setAttribute("item", cart.getCartList().get(i));
%>
<li>
<table width="50%">
			<tr>
				<th rowspan="4"><h2><% out.print((i+1));%></h2></th>
				<td>
					<jsp:getProperty name="item" property="name"></jsp:getProperty>
				</td>
			</tr>
			<tr>
				<td>
					SKU: <jsp:getProperty name="item" property="sku"></jsp:getProperty>
				</td>
			</tr>
			<tr>
				<td>
					$<jsp:getProperty name="item" property="price"></jsp:getProperty>
				</td>
                        <tr>    
                            <td>
                                <div class="menu"><h3><a href="Removefromcart?index=<%out.print(i);%>">Remove from Cart</a></h3></div>
                            </td>
                        </tr>
		</table>
			    </li>
<%
	}
%>
</ul>
<%
	if(!cart.getCartList().isEmpty() && user.getFirstName() != null){
%>
<p>Total: <jsp:getProperty name="cart" property="total"></jsp:getProperty>
	<br/>
<p><h2><a href="Checkout">Checkout</a></h2>
	<%
	} else { %>
	<h1>About Us</h1>
	<div class="entry">
<blockquote>Krampus is a mythical creature recognized in Alpine countries. According to legend, Krampus accompanies St. Nicholas during the Christmas season, warning and punishing bad children, in contrast to St. Nicholas, who gives gifts to good children.</blockquote>
<blockquote>In the Alpine regions, Krampus is represented by a demon-like creature. Traditionally young men dress up as the Krampus in Austria and southern Bavaria during the first two weeks of December, particularly on the evening of 5 December, and roam the streets frightening children with rusty chains and bells.</blockquote>
	<% }
	if(user.getFirstName() == null){
		%>
		<jsp:include page="login.jsp"/>
		<%

	}
	%>
	</div>
	</div>