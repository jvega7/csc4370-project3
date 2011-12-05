<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:include page="htmlheader.jsp" />
        <title>Welcome</title>
    </head>
    <body>
	    <h1>Welcome <jsp:getProperty name="user" property="firstName"/>
		    <jsp:getProperty name="user" property="lastName" /></h1>
        <jsp:include page="menu.jsp"></jsp:include>
    </body>
</html>
