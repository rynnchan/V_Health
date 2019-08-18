<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ServletのGet</title>
<script type="text/javascript">
	function exec() {
		location.href = "/test/TestGet?aaa="
				+ document.getElementById("aaa").value + "&bbb="
				+ document.getElementById("bbb").value;
	}
</script>
</head>
<body>
	<a href="/test/TestGet?aaa=パラメータも&bbb=受け取れるよ">リンクはこちら</a>
	<br />
	<br /> Javascriptはこちら
	<br />
	<input type="text" id="aaa" />
	<input type="text" id="bbb" />
	<input type="button" value="実行" onclick="exec()">
</body>
</html>