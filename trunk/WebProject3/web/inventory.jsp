<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User" ></jsp:useBean>
<jsp:useBean id="db" scope="session" class="beans.DB"></jsp:useBean>
<jsp:useBean id="item" scope="session" class="beans.InventoryItem"></jsp:useBean>
<jsp:include page="htmlheader.jsp"/> 
        	<jsp:include page="menu.jsp"></jsp:include>
		<% if(user.isValid()){ %>
		<h1><% out.print(session.getAttribute("checkout"));%>&nbsp;<jsp:getProperty name="user" property="firstName"></jsp:getProperty>
			<jsp:getProperty name="user" property="lastName" ></jsp:getProperty></h1>
		    <% } %>
		<div id="content">
					<h2 class="title"><img src="images/krampusnacht-blog.png" alt="Krampus Nacht" /></h2>
<%
	for(int i = 0; i < db.getInventory().size(); i++){
		session.setAttribute("item", db.getInventory().get(i));
%>
				<div class="post">
					<div class="entry">
<table>
			<tr>
				<td colspan="4">
					<h1>
					<jsp:getProperty name="item" property="name"></jsp:getProperty>
					</h1>
				</td>
			</tr>
			<tr>
				<td>
					<h2>
					SKU: <jsp:getProperty name="item" property="sku"></jsp:getProperty>
					</h2>
				</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td>
					<h2>$<jsp:getProperty name="item" property="price"></jsp:getProperty></h2>
				</td>
				<td>
					<h2>Quantity: <jsp:getProperty name="item" property="available"/>
				</td>
				<td colspan="2"></td>
			<tr><td colspan="4">
                                <%
                                if(user.isValid())
                                {
                                %>
                                <a href="Addtocart?index=<%out.print(i);%>">Add to Cart</a>
                                <%
                                }else{
                                %>
					<div><a href="register.jsp">Register</a> or Login to Add to Cart</div>
				                                <%
                                }
                                %>
				</td><td></td></tr>
			<tr>
				<td colspan="4">
					<img src="<jsp:getProperty name="item" property="image"/>" alt="No Image" height="256" style="float:right;margin:4px;"/>
					<div class="entry"><br/><br/>
					<jsp:getProperty name="item" property="description"></jsp:getProperty>
					</div>
				</td>
			</tr>
		</table>
				</div>
			</div>
			<!-- end #content -->
<%
	}
%>
		<img src="images/footer.png" alt="Village"/>
		</div>
		<jsp:include page="viewcart.jsp"/>
<jsp:include page="htmlfooter.html" ></jsp:include>