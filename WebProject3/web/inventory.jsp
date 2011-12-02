<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="db" scope="session" class="beans.DB"/>
<jsp:useBean id="item" scope="session" class="beans.InventoryItem"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        	<title>Shopping</title>
	</head>
	<body>
        	<h1>Inventory</h1>
        	<jsp:include page="menu.jsp"></jsp:include>
		<table>
<%
	for(int i = 0; i < db.getInventory().size(); i++){
		session.setAttribute("item", db.getInventory().get(i));
%>
			<tr>
				<td>
					<jsp:getProperty name="item" property="name"/>
				</td>
			</tr>
<%
	}
%>
		</table>
	</body>
</html>
