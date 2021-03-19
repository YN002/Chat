<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="AccountStyle.css" />
</head>
<body>
	<div id="form">
		<form action="./LoginServlet" method="post">
			<p class="title">Login</p>
			<p>UserID</p>
			<p class="loginid">
				<input type="text" name="loginid" />
			</p>
			<p>Password</p>
			<p class="pass">
				<input type="password" name="password" />
			</p>
			<p class="submit">
				<input type="submit" value="login" />
			</p>

		</form>
		<p>
			アカウント登録がまだの方は登録してください<br>
			<a href="NewAccount.jsp"><button>新規登録</button></a>
	</div>
</body>
</html>