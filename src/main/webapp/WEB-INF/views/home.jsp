<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
<link rel='stylesheet' type='text/css'
	href='/searchapp/resources/css/menu.css' />
<link rel='stylesheet' type='text/css'
	href='/searchapp/resources/css/login.css' />
<link rel='stylesheet' type='text/css'
	href='/searchapp/resources/css/jquery.dataTables_themeroller.css' />
<link rel='stylesheet' type='text/css'
	href='/searchapp/resources/css/jquery.dataTables.css' />
<link href='http://fonts.googleapis.com/css?family=Abril+Fatface'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="http://yui.yahooapis.com/3.6.0/build/yui/yui.js"></script>
<script type="text/javascript"
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
<script type="text/javascript"
	src="/searchapp/resources/scripts/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="/searchapp/resources/scripts/script.js"></script>
<script type="text/javascript"
	src="/searchapp/resources/scripts/agency.js"></script>
</head>

<body class="yui3-skin-sam">
	<div id='cssmenu'>
		<ul>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/company/home'><span>Company</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/agency/home'><span>Contracts</span></a></li>
			<li class='active'><a
				href='<c:out value="${pageContext.request.contextPath}"/>/agency/home'><span>Agency</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/invoice/home'><span>Invoice</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/expenses/home'><span>Expense</span></a></li>
			<li class='last'><a href='#'><span>Contact</span></a></li>
		</ul>
	</div>
	<div id="companySection" class="section">
		<form:form method="POST" commandName="agency"
			action="/searchapp/agency/save">
			<h2>Agency</h2>
			<fieldset style="padding: 10px">
				<table class="tableclass">
					<tr>
						<td><form:label path="name">Agency Name</form:label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><form:label path="address.address1">Address 1</form:label></td>
						<td><form:textarea path="address.address1"></form:textarea></td>
					</tr>
					<tr>
						<td><form:label path="address.address2">Address 3</form:label></td>
						<td><form:textarea path="address.address2"></form:textarea></td>
					</tr>
					<tr>
						<td><form:label path="address.city">City</form:label></td>
						<td><form:input path="address.city" /></td>
					</tr>
					<tr>
						<td><form:label path="address.town">Town</form:label></td>
						<td><form:input path="address.town" /></td>
					</tr>
					<tr>
						<td><form:label path="address.country">Country</form:label></td>
						<td><form:input path="address.country" /></td>
					</tr>
					<tr>
						<td><form:label path="address.postCode">Post Code</form:label></td>
						<td><form:input path="address.postCode" /></td>
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
			</fieldset>
		</form:form>
	</div>
	<div id="companySection" class="section">
		<div id="agencies"></div>
	</div>
</body>
</html>