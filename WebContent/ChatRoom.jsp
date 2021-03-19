<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="account" scope="session" type="beans.AccountBeans"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="ChatRoomStyle.css" />

<meta charset="UTF-8">
<title>チャットルーム</title>
<script type="text/javascript">
	function frmsubmit() {
		var answer = confirm("本当に削除しますか");
		if (answer == true) {
			return true;
		} else {
			return false;
		}
	}
</script>

</head>
<body>

	<div class="right">
		<form action="./LogoutServlet" method="get">
			<input type="submit" value="ログアウト" />
		</form>
	</div>
	<div class="config">
		<form action="./ChatServlet" method="post" name="config"
			onSubmit="return check()">
			<div id="title">
				<img src="男性社員.gif" height="25" width="25" />
				<%=account.getName()%>さんチャットルームへようこそ <img src="女性社員.gif" height="25"
					width="25" />
			</div>
			<p>
				名前:<input type="text" name="userName" />
			</p>
			<br>

			<p>
				顔アイコン: <input type="radio" name="icon" value="icon0.gif" checked><img
					src="icon0.gif" height="25" width="25" /> <input type="radio"
					name="icon" value="icon1.gif"><img src="icon1.gif"
					height="25" width="25" /> <input type="radio" name="icon"
					value="icon2.gif"><img src="icon2.gif" height="25"
					width="25" /> <input type="radio" name="icon" value="icon3.gif"><img
					src="icon3.gif" height="25" width="25" /> <input type="radio"
					name="icon" value="icon4.gif"><img src="icon4.gif"
					height="25" width="25" /><input type="radio" name="icon"
					value="icon5.gif"><img src="icon5.gif" height="25"
					width="25" /><br>

				<textarea name="comment" rows="5" cols="40"></textarea>
			<p class="submit">
				<input type="submit" value="発言" />
			</p>
		</form>

		<form action="CommentDeleteServlet" method="get">
			<c:forEach var="list" items="${listAttribute}">
				<p>
					<img src=<c:out value = "${list.icon }"/> height="25" width="25" />
					<input type = "submit" value = <c:out value = "${list.id }"/> 	name="deleteid" onclick=" return frmsubmit()">
					<c:out value="${list.userName}" />
					 日付:
					<c:out value="${list.date}" />
					<br>
					<c:out value="${list.comment}" />
				</p>
			</c:forEach>
		</form>


	</div>
</body>
</html>