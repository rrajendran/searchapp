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
			<li ><a href='<c:out value="${pageContext.request.contextPath}"/>/spring/home'><span>Contracts</span></a></li>
			<li ><a href='<c:out value="${pageContext.request.contextPath}"/>/spring/agents'><span>Agents</span></a></li>
			<li><a href='<c:out value="${pageContext.request.contextPath}"/>/spring/invoice'><span>Invoice</span></a></li>
			<li class='active'><a href='<c:out value="${pageContext.request.contextPath}"/>/spring/expenses'><span>Expense</span></a></li>
			<li class='last'><a href='#'><span>Contact</span></a></li>
		</ul>
	</div>
	<div id="page">
		<form>
			<c:out value="${pageContext.request.pathInfo}"/>
			<table>
				<tr>
					<td>
						<label>Date</label>
					</td>
					<td>
						<input id="date" name="date" width="100px"/>
					</td>
				</tr>
				<tr>
					<td>
						<label>Category</label>
					</td>
					<td>
						<select id="category" name="category">
							<option>Travelling</option>
							<option>Food and subsitence</option>
							<option>Postage</option>
							<option>Entertainment</option>
							<option>Car milage</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label>Enter amount</label>
					</td>
					<td>
						<input id="amount" name="amount" width="100px"/>
					</td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>