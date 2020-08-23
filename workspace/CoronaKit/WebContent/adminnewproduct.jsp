<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SPS Corona Kit Online Store</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<h3>Please add the product information</h3>

	<form action="adminaddProduct" method="post">

		<table cellspacing="5px" cellpadding="5px">

			<tr>
				<td><label>ProductName</label></td>
				<td><input type="text" name="pproductName"
					value="${product.pproductName}" required /></td>
			</tr>
			<tr>
				<td><label>Description</label></td>
				<td><input type="text" name="pdescription"
					value="${product.pdescription}" required /></td>
			</tr>
			<tr>
				<td><label>Cost</label></td>
				<td><input type="decimal" name="pcost" value="${product.pcost}"
					required /></td>
			</tr>
			<tr>
				<td><label>AvailabilityStatus</label></td>
				<td><select name="pavailabilityStatus" required>
						<option value="">--SELECT--</option>
						<c:forEach items="${['AVAILABLE', 'SOLDOUT']}" var="opt">
							<option value="${opt }"
								${opt.equals(product.pavailabilityStatus?'selected':'') }>${opt }</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<button>SAVE</button>
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>