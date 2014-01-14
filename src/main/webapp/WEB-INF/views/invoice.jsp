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
	<%@include file="menu.jsp" %>
	<div id="page">

		<div class="ui-widget" style="width: 30%; float: left">
			Search country <input id="search">
			<div id="result"></div>
		</div>
		<div style="width: 30%; font-size: 5em; float: right">${pageViews }
			views</div>
	</div>
</body>
</html>