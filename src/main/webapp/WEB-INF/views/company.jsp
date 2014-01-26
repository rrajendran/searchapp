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
</head>
<body class="yui3-skin-sam">
	<div id='cssmenu'>
		<ul>
			<li class='active'><a
				href='<c:out value="${pageContext.request.contextPath}"/>/company/home'><span>Company</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/contracts/home'><span>Contracts</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/agency/home'><span>Agency</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/invoice/home'><span>Invoice</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/expenses/home'><span>Expense</span></a></li>
			<li class='last'><a href='#'><span>Contact</span></a></li>
		</ul>
	</div>
	<div id="companySection" class="section">
		<form:form method="POST" commandName="company" action="/searchapp/company/save">
			<h2>${company.companyName }</h2>
			<form:hidden path="companyNo"/>
			<fieldset style="padding:10px">
				<table class="tableclass">
					<tr>
						<td><form:label path="companyNo">Company No</form:label></td>
						<td><form:input path="companyNo" disabled="true"/></td>
					</tr>
					<tr>
						<td><form:label path="companyName">CompanyName</form:label></td>
						<td><form:input style="width:18em"  path="companyName" /></td>
					</tr>
					<tr>
						<td><form:label path="incorporationDate">Incorporation Date</form:label></td>
						<td><form:input path="incorporationDate" /></td>
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
						<td colspan="2"><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</fieldset>
		</form:form>
	</div>
	<div id="vatSection" class="section">
		<form:form method="POST" commandName="vat" action="/searchapp/vat/save">
			<form:hidden path="registrationNo"/>
			<h2>VAT</h2>
			<fieldset style="padding:10px">
				<table class="tableclass">
					<tr>
						<td><form:label path="registrationNo">Registration No</form:label></td>
						<td><form:input path="registrationNo" disabled="true"/></td>
					</tr>
					<tr>
						<td><form:label path="registrationDate">Registration Date</form:label></td>
						<td><form:input path="registrationDate" /></td>
					</tr>
					<tr>
						<td><form:label path="vatRate">VAT Rate (%)</form:label></td>
						<td><form:input path="vatRate" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</fieldset>
		</form:form>

	</div>
</body>
</html>