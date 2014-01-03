<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
<link href="resources/css/screen.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Abril+Fatface'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Exo+2'
	rel='stylesheet' type='text/css'>
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script src="resources/scripts/script.js"></script>
</head>
<body>
	<div id="header">REDIS</div>
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