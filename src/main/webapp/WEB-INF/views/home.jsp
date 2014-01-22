<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='resources/css/menu.css' />
<link rel='stylesheet' type='text/css'
	href='resources/css/jquery.dataTables_themeroller.css' />
<link rel='stylesheet' type='text/css'
	href='resources/css/jquery.dataTables.css' />
<link href='http://fonts.googleapis.com/css?family=Abril+Fatface'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>
<script  type="text/javascript"  src="http://yui.yahooapis.com/3.6.0/build/yui/yui.js"></script>
<script  type="text/javascript"  src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
<script type="text/javascript" src="resources/scripts/jquery.dataTables.js"></script>
<script  type="text/javascript"  src="resources/scripts/script.js"></script>
<script  type="text/javascript"  src="resources/scripts/agency.js"></script>
</head>

<body class="yui3-skin-sam">
	<div id='cssmenu'>
		<ul>
			<li class='active'><a
				href='<c:out value="${pageContext.request.contextPath}"/>/spring/home'><span>Contracts</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/spring/agents'><span>Agents</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/spring/invoice'><span>Invoice</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/spring/expenses'><span>Expense</span></a></li>
			<li class='last'><a href='#'><span>Contact</span></a></li>
		</ul>
	</div>
	<div id="page">
		<div style="clear: left;width:30%;float:left">
			<form:form method="POST" commandName="agency"
				action="/searchapp/spring/agency/save">
				<table class="tableclass">
					<tr>
						<td><form:label path="name">Agency Name</form:label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><form:label path="address1">Address 1</form:label></td>
						<td><form:textarea path="address1"></form:textarea></td>
					</tr>
					<tr>
						<td><form:label path="address2">Address 3</form:label></td>
						<td><form:textarea path="address2"></form:textarea></td>
					</tr>
					<tr>
						<td><form:label path="city">City</form:label></td>
						<td><form:input path="city" /></td>
					</tr>
					<tr>
						<td><form:label path="town">Town</form:label></td>
						<td><form:input path="town" /></td>
					</tr>
					<tr>
						<td><form:label path="country">Country</form:label></td>
						<td><form:input path="country" /></td>
					</tr>
					<tr>
						<td><form:label path="postCode">Post Code</form:label></td>
						<td><form:input path="postCode" /></td>
					</tr>
					<tr>
						<td><form:label path="mobile">Mobile</form:label></td>
						<td><form:input path="mobile" /></td>
					</tr>
					<tr>
						<td><form:label path="telephone">Telephone</form:label></td>
						<td><form:input path="telephone" /></td>
					</tr>
					<tr>
						<td><form:label path="emailId">Email Id</form:label></td>
						<td><form:input path="emailId" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div id="dynamic" style="clear: right;float:left">
			<div id="agencies"></div>
		</div>
	</div>

</body>
</html>