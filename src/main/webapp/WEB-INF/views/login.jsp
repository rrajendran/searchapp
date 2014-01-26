<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Varela+Round">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/>">
</head>
<body onload='document.f.j_username.focus();'>
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<div id="login">

		<h2><span class="fontawesome-lock"></span>Sign In</h2>

		<form action="<c:url value='j_spring_security_check' />" method="POST">

			<fieldset>

				<p><label for="username">Username</label></p>
				<p><input type="username" id="j_username"  name="j_username" value="ramesh" onBlur="if(this.value=='')this.value='mail@address.com'" onFocus="if(this.value=='mail@address.com')this.value=''"></p> <!-- JS because of IE support; better: placeholder="mail@address.com" -->

				<p><label for="password">Password</label></p>
				<p><input type="password"  id="j_password"  name="j_password"  value="welcome1" onBlur="if(this.value=='')this.value='password'" onFocus="if(this.value=='password')this.value=''"></p> <!-- JS because of IE support; better: placeholder="password" -->

				<p><input type="submit" value="Sign In"></p>
			</fieldset>

		</form>

	</div> <!-- end login -->
</body>
</html>