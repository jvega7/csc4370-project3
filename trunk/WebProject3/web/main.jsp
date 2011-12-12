<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.setAttribute("exists", "");%>
<jsp:include page="htmlheader.jsp"></jsp:include> 
        <jsp:include page="menu.jsp"></jsp:include>
	<jsp:forward page="/Inventory"></jsp:forward>
	<jsp:include page="htmlfooter.html" ></jsp:include>
