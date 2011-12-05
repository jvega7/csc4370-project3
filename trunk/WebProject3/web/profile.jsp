<%@page import="java.util.Calendar"%>
<%@page import="beans.InventoryItem"%>
<%@page import="java.util.LinkedList"%>
<%@page import="beans.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User"></jsp:useBean>
<jsp:useBean id="db" scope="session" class="beans.DB"></jsp:useBean>
<jsp:include page="htmlheader.jsp" ></jsp:include>
        <jsp:include page="menu.jsp"></jsp:include>
	<div id="sidebar">
		<h1>Customer Profile</h1>
		<table>
			<tr>
				<th>Username</th>
				<td colspan="3"><jsp:getProperty name="user" property="username" ></jsp:getProperty></td>
			</tr>
			<tr>
				<th>First Name</th>
				<td colspan="3"><jsp:getProperty name="user" property="firstName"></jsp:getProperty></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td colspan="3"><jsp:getProperty name="user" property="lastName" ></jsp:getProperty></td>
			</tr>
			<tr>
				<th>Address</th>
				<td colspan="3"><jsp:getProperty name="user" property="address" ></jsp:getProperty></td>
			</tr>
			<tr>
				<th></th>
				<td><jsp:getProperty name="user" property="city" ></jsp:getProperty></td>
				<td><jsp:getProperty name="user" property="state" ></jsp:getProperty></td>
				<td><jsp:getProperty name="user" property="zipcode" ></jsp:getProperty></td>
			</tr>
			<tr>
				<th>Phone</th>
				<td colspan="3"><jsp:getProperty name="user" property="phone"></jsp:getProperty></td>
			</tr>
			<tr>
				<th>Email</th>
				<td colspan="3"><jsp:getProperty name="user" property="email" ></jsp:getProperty></td>
			</tr>
		</table>
                <br/>
                <h2><a href="editprofile.jsp">Edit Profile</a></h2>
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
							out.println("<br/>SKU: "+item.getSku()+"<br/>Title: \""+item.getName()+"\"<br/>Price: $"+item.getPrice());
						}
					}%>
			</div>
<jsp:include page="htmlfooter.html" ></jsp:include>
