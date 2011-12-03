<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart"/>
<jsp:useBean id="item" scope="session" class="beans.InventoryItem"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        	<title>Shopping</title>
	</head>
	<body>
        	<h1>Shopping Cart</h1>
        	<jsp:include page="menu.jsp"></jsp:include>
<%
	for(int i = 0; i < cart.getCartList().size(); i++){
		session.setAttribute("item", cart.getCartList().get(i));
%>
<table width="50%">
			<tr>
				<td colspan="2">
					<jsp:getProperty name="item" property="name"/>
				</td>
			</tr>
			<tr>
				<td>
					SKU: <jsp:getProperty name="item" property="sku"/>
				</td>
			</tr>
			<tr>
				<td>
					$<jsp:getProperty name="item" property="price"/>
				</td>
			<tr>
			</tr>
			<tr>
				<td colspan="2">
					<jsp:getProperty name="item" property="description"/>
				</td>
			</tr>
		</table>
					<br/>
<%
	}
%>
<p>Total: <jsp:getProperty name="cart" property="total"/>
	<br/>
<p><a href="Checkout">Checkout</a>
	</body>
</html>
