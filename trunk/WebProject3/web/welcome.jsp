<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User" ></jsp:useBean>
<jsp:include page="htmlheader.jsp" ></jsp:include>
<h1>Welcome <jsp:getProperty name="user" property="firstName"></jsp:getProperty>
	<jsp:getProperty name="user" property="lastName" ></jsp:getProperty></h1>
        <jsp:include page="menu.jsp"></jsp:include>
	<jsp:forward page="Inventory"></jsp:forward>
	<jsp:include page="htmlfooter.html" ></jsp:include>
