<%@page import="java.util.Calendar"%>
<%@page import="beans.InventoryItem"%>
<%@page import="java.util.LinkedList"%>
<%@page import="beans.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User"/>
<jsp:useBean id="db" scope="session" class="beans.DB"/>
<jsp:include page="htmlheader.jsp" />
        <jsp:include page="menu.jsp"></jsp:include>
	<div id="sidebar">
		<h1>Customer Profile</h1>
		<table>
			<tr>
				<th>Username</th>
				<td colspan="3"><jsp:getProperty name="user" property="username" /></td>
			</tr>
			<tr>
				<th>First Name</th>
				<td colspan="3"><jsp:getProperty name="user" property="firstName"/></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td colspan="3"><jsp:getProperty name="user" property="lastName" /></td>
			</tr>
			<tr>
				<th>Address</th>
				<td colspan="3"><jsp:getProperty name="user" property="address" /></td>
			</tr>
			<tr>
				<th></th>
				<td><jsp:getProperty name="user" property="city" /></td>
				<td><jsp:getProperty name="user" property="state" /></td>
				<td><jsp:getProperty name="user" property="zipcode" /></td>
			</tr>
			<tr>
				<th>Phone</th>
				<td colspan="3"><jsp:getProperty name="user" property="phone"/></td>
			</tr>
			<tr>
				<th>Email</th>
				<td colspan="3"><jsp:getProperty name="user" property="email" /></td>
			</tr>
		</table>
	</div>
			<div id="content">
				<h1>Order History</h1>
					<%LinkedList<LinkedList<InventoryItem>> orders = user.getOrders();
					for (int i = 0; i < orders.size(); i++){
						if(user.getTimestamps().get(i) != null)
							out.println("<p>"+user.getTimestamps().get(i).toString());
						LinkedList<InventoryItem> cartList = orders.get(i);
						for (int j = 0 ; j < cartList.size(); j++){
							InventoryItem item = cartList.get(j);
							out.println("<br/>SKU: "+item.getSku()+"<br/>Name: "+item.getName()+"<br/>Price: "+item.getPrice());
						}
					}%>
			</div>
					<jsp:include page="htmlfooter.html" />
