<%-- 
    Document   : editprofile
    Created on : Dec 5, 2011, 2:41:01 PM
    Author     : Adam
--%>
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
            <h1>Edit Profile</h1>
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
            <h2><a href="profile.jsp">Back to Orders</a></h2>
    </div>
    <div id="content">
        <form action ="EditProfile" method="post">
		<table>
			<tr><td>Enter Password:</td><td><input type="password" name="password" value="<jsp:getProperty name="user" property="password"/>" ></td></tr>
			<tr><td>Verify Password:</td><td><input type="password" name="verify" value="<jsp:getProperty name="user" property="password"/>" ></td></tr>
			<tr><td>Enter First Name:</td><td><input type="text" name="first" value="<jsp:getProperty name="user" property="firstName"/>" ></td></tr>
			<tr><td>Enter Last Name:</td><td><input type="text" name="last" value="<jsp:getProperty name="user" property="lastName"/>" ></td></tr>
			<tr><td>Enter Address:</td><td><input type="text" name="address" value="<jsp:getProperty name="user" property="address"/>" ></td></tr>
			<tr><td>Enter City:</td><td><input type="text" name="city" value="<jsp:getProperty name="user" property="city"/>" ></td></tr>
			<tr><td>Enter State:</td><td><input type="text" maxlength="2" name="state" value="<jsp:getProperty name="user" property="state"/>" ></td></tr>
			<tr><td>Enter Zip Code:</td><td><input type="text" maxlength="5" name="zipcode" value="<jsp:getProperty name="user" property="zipcode"/>" ></td></tr>
			<tr><td>Enter Phone:</td><td><input type="text" maxlength="10" name="phone" value="<jsp:getProperty name="user" property="phone"/>" ></td></tr>
			<tr><td>Enter Email:</td><td><input type="text" name="email" value="<jsp:getProperty name="user" property="email"/>" ></td></tr>
		</table>
            <input type="submit" value="Update" name="update" >
        </form>
    </div>
<jsp:include page="htmlfooter.html" ></jsp:include>
