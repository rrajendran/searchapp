<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='/searchapp/resources/css/menu.css' />
<link rel='stylesheet' type='text/css' href='/searchapp/resources/css/login.css' />
<link rel='stylesheet' type='text/css'
	href='/searchapp/resources/css/jquery.dataTables_themeroller.css' />
<link rel='stylesheet' type='text/css'
	href='/searchapp/resources/css/jquery.dataTables.css' />
<link href='http://fonts.googleapis.com/css?family=Abril+Fatface'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>
<script  type="text/javascript"  src="http://yui.yahooapis.com/3.6.0/build/yui/yui.js"></script>
<script  type="text/javascript"  src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
<script type="text/javascript" src="/searchapp/resources/scripts/jquery.dataTables.js"></script>
<script  type="text/javascript"  src="/searchapp/resources/scripts/script.js"></script>
<script  type="text/javascript"  src="/searchapp/resources/scripts/invoice.js"></script>
</head>
<body class="yui3-skin-sam">
	<div id='cssmenu'>
		<ul>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/company/home'><span>Company</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/contracts/home'><span>Contracts</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/agency/home'><span>Agency</span></a></li>
			<li class='active'><a
				href='<c:out value="${pageContext.request.contextPath}"/>/invoice/home'><span>Invoice</span></a></li>
			<li><a
				href='<c:out value="${pageContext.request.contextPath}"/>/expenses/home'><span>Expense</span></a></li>
			<li class='last'><a href='#'><span>Contact</span></a></li>
		</ul>
	</div>
	<div id="page">
		<div style="clear: left;width:30%;float:left">
			<form:form method="POST" commandName="invoice" action="/searchapp/invoice/save">
				<table class="tableclass">
					<tr>
						<td><form:label path="agency.name">Agency Name</form:label></td>
						<td>
							<form:select path="agency.name">
								<c:forEach items="${agencies}" var="a">
								  	 <form:option  id="${a.id }" value="${a.name }"/>
								</c:forEach>
							   
							</form:select>
						</td>
					</tr>
					<tr>
						<td><form:label path="fromDate">From Date</form:label></td>
						<td><form:input path="fromDate"/></td>
					</tr>
					<tr>
						<td><form:label path="toDate">To Date</form:label></td>
						<td><form:input path="toDate" /></td>
					</tr>
					<tr>
						<td><form:label path="rate">Rate Per Day(£)</form:label></td>
						<td><form:input path="rate" /></td>
					</tr>
					<tr>
						<td><form:label path="days">No of days</form:label></td>
						<td><form:input path="days" /></td>
					</tr>
					<tr>
						<td><form:label path="vat">Vat(%)</form:label></td>
						<td><form:input path="vat" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div id="dynamic" style="clear: right;float:left">
			<div id="invoices"></div>
		</div>
	</div>
</body>
</html>