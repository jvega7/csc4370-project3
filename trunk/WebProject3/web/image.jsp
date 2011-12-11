<%@page import="beans.InventoryItem"%>
<%@ page import = "java.io.*" %>
<%
	InventoryItem item = (InventoryItem) session.getAttribute("item");
    try
    {  
  
       // get the image from the database
       byte[] imgData = item.getImage();
       // display the image
       response.setContentType("image/jpeg");
       OutputStream o = response.getOutputStream();
       o.write(imgData);
       o.flush(); 
       o.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
%>