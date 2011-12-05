<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="htmlheader.jsp" />
        	<title>Shopping</title>
	</head>
	<body>
        	<h1>Shopping Cart</h1>
        	<jsp:include page="menu.jsp"></jsp:include>
<jsp:useBean id="cart" scope="session" class="beans.ShoppingCart"/>
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
                        <tr>    
                            <td>
                                <a href="Removefromcart?index=<%out.print(i);%>">Remove from Cart</a>
                            </td>
                        </tr>
		</table>
					<br/>
<%
	}
	if(!cart.getCartList().isEmpty()){
%>
<p>Total: <jsp:getProperty name="cart" property="total"/>
	<br/>
<p><a href="Checkout">Checkout</a>
	<%
	} else {
		out.print("<p>Shopping Cart is Empty<br/>");
	}
	%>
	</body>
</html>
