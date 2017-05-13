<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Word Search - Nepali NLP</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<style>
body {
	width:350px;
	font-family: "Trebuchet MS", sans-serif;
	margin: 50px;
}
div.class1 {
    width:300px;
    margin: 10px;
    border: 3px solid #73AD21;
}
div.right {
	width:350x;
	align:right;
}
</style>
</head>
<body>


	<div class="ui-widget">
		<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			Search NGrams Below</p>
		</div>
	</div>
	<br>

<!-- 	<form action="/NepaliNLPWeb/WordSearchServlet" method="post">

		Search Term: <input type="text" name="word_search_query" value=""><br/>
		<br/>
		The Search Term appears in the word at (Select One):
		&nbsp;&nbsp;&nbsp;<input type="radio" name="word_search_type" value="anywhere"> Anywhere<br/>
		&nbsp;&nbsp;&nbsp;<input type="radio" name="word_search_type" value="start"> Start<br/>
		&nbsp;&nbsp;&nbsp;<input type="radio" name="word_search_type" value="end"> End<br/>
		<br/>
		<input type="submit" value="Search Words">
		
	</form> -->


	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script>
		$("[id*=controlgroup]").controlgroup();
	</script>
</body>
</html>