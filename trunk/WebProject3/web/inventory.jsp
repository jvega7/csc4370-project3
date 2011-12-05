<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:useBean id="db" scope="session" class="beans.DB"/>
<jsp:useBean id="item" scope="session" class="beans.InventoryItem"/>
<jsp:include page="htmlheader.jsp"/> 
        	<jsp:include page="menu.jsp"></jsp:include>
		<% if(user.isValid()){ %>
	    <h1>Welcome <jsp:getProperty name="user" property="firstName"/>
		    <jsp:getProperty name="user" property="lastName" /></h1>
		    <% } %>
		<jsp:include page="viewcart.jsp"/>
		<div id="content">
<%
	for(int i = 0; i < db.getInventory().size(); i++){
		session.setAttribute("item", db.getInventory().get(i));
%>
				<div class="post">
					<h2 class="title"><img src="images/krampusnacht-blog.png" alt="Krampus Nacht" /></h2>
					<div class="entry">
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
			<tr><td>
                                <%
                                if(user.isValid())
                                {
                                %>
                                <a href="Addtocart?index=<%out.print(i);%>">Add to Cart</a>
                                <%
                                }else{
                                %>
					<div><a href="Menu?index=4">Log in</a> to Add to Cart</div>
				                                <%
                                }
                                %>
                        </td></tr>
		</table>
		<img src="images/footer.png" alt="Village"/>
				</div>
			</div>
			<!-- end #content -->
<%
	}
%>
		</div>
<jsp:include page="htmlfooter.html" />