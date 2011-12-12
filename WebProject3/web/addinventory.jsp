<jsp:include page="htmlheader.jsp"/>
<form name="addinventory" action="AddInventory" method="POST" enctype="multipart/form-data"><table border="0">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<td>SKU</td>
				<td><input type="text" name="sku" value="" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" value="" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" value="" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea name="description" rows="4" cols="20"></textarea>
</td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="image" value="Select Image" /></td>
			</tr>
	</table>
</form>
<jsp:include page="htmlfooter.html"/>
