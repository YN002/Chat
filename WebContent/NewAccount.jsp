<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
<link rel="stylesheet" href="AccountStyle.css" />
</head>
<body>
<div id="form">
	<form action= ./NewRegistarServlet method="post">
	<p class="title">ユーザー登録してください</p>
			<p>UserID</p>
			<p class="loginid">
				<input type="text" name="loginid" />
			</p>
			<p>Password</p>
			<p class="pass">
				<input type="password" name="password" />
			</p>
			<p>Name
			<p class="name">
				<input type="text" name="name" />
			<p class="submit">
				<input type="submit" value="登録" />
			</p>
	</form>
</div>
</body>
</html>