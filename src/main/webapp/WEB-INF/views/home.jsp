<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
<link rel='stylesheet' type='text/css' href='resources/css/menu.css' />
<link href='http://fonts.googleapis.com/css?family=Abril+Fatface'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
<script src="resources/scripts/script.js"></script>
</head>
<body>
	<div id='cssmenu'>
		<ul>
			<li  class='active'><a href='<c:out value="${pageContext.request.contextPath}"/>/spring/home'><span>Contracts</span></a></li>
			<li ><a href='<c:out value="${pageContext.request.contextPath}"/>/spring/agents'><span>Agents</span></a></li>
			<li><a href='<c:out value="${pageContext.request.contextPath}"/>/spring/invoice'><span>Invoice</span></a></li>
			<li><a href='<c:out value="${pageContext.request.contextPath}"/>/spring/expenses'><span>Expense</span></a></li>
			<li class='last'><a href='#'><span>Contact</span></a></li>
		</ul>
	</div>
	<div id="page">
		<table>
			<tr>
				<td>Start Date</td>
			</tr>
			<tr>
				<td><input name="startDate" id="startDate" type="text"/></td>
			</tr>
			<tr>
				<td>End Date</td>
			</tr>
			<tr>
				<td><input name="endDate" id="endDate" type="text"/></td>
			</tr>
			<tr>
				<td>Agency</td>
			</tr>
			<tr>
				<td><input name="agency" id="agency" type="text"/></td>
			</tr>
			<tr>
				<td>Client</td>
			</tr>
			<tr>
				<td><input name="client" id="client" type="text"/></td>
			</tr>
			<tr>
				<td><button value="Create">Create</button></td>
			</tr>
		</table>
		
		<div style="width: 30%; font-size: 5em; float: right">${pageViews }
			views</div>
	</div>
</body>
</html>