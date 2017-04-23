<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NLP - Word Classify</title>
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

	Welcome to iNepal.ORG's natural language processing portal. You can do the following in this page.
	<br><a href="pos_tagger.jsp">POS Tagger</a>

	<br><a href="sentence_classify.jsp">Sentence Classification</a>
	<br><a href="sentence_roman_validate.jsp">Classify Romanization</a>
	<br><a href="sentence_search.jsp">Sentence Search</a>
	<br><a href="sentence_valid.jsp">--Sentence Validation</a>

	<br><a href="word_classify_root.jsp">--Words Classification (Root)</a>
	<br><a href="word_classify.jsp">--Words Classification</a>
	<br><a href="word_roman_validate.jsp">--Word Romanization</a>
	<br><a href="word_root_validate.jsp">Word Root Validation</a>
	<br><a href="word_search.jsp">Word Search</a>
	<br><a href="word_verify.jsp">Word Verification</a>
	<br/>
	<br><a href="statistics.jsp">Admin - Statistics</a>
	
	
	
	
	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
</body>
</html>