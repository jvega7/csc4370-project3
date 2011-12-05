<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar">
			<%String title = "Buy my crap!";
			for (int i = 0; i < title.length(); i++){
				out.print("<p class='left'>"+title.charAt(i)+"");
			}
			%>
</div>

<!-- end #sidebar -->
