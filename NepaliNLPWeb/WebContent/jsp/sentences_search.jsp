<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.icodejava.research.nlp.domain.Sentence"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sentence Search - Nepali NLP</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/nlpweb.css" rel="stylesheet">
<style>
body {
	width:500px;
	font-family: "Trebuchet MS", sans-serif;
	margin: 50px;
}
div.class1 {
    width:450px;
    margin: 10px;
    border: 3px solid #73AD21;
}

</style>
</head>
<body>

	<div id="Parent" class="parent" style="align:center">
		<h1>NEPALI NLP - SENTENCE SEARCH</h1>
		<div class="ui-widget">
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
				<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
				Search NGrams Below</p>
			</div>
		</div>
		<br>
		
		<div>
	
			<form action="/NepaliNLPWeb/SentencesSearchServlet" method="post">
				Search Term: <input type="text" name="sentences_search_query" value="नदी" style="width:300px"><br/>
				
				The Search Term appears in the word at (Select One):<br/>
				&nbsp;&nbsp;&nbsp;<input type="radio" name="sentences_search_type" value="anywhere"> Anywhere<br/>
				&nbsp;&nbsp;&nbsp;<input type="radio" name="sentences_search_type" value="start"> Start<br/>
				&nbsp;&nbsp;&nbsp;<input type="radio" name="sentences_search_type" value="end" checked="checked"> End<br/>
				<br/>
				
				Limit Search Results To (Select One):<br/>
				&nbsp;&nbsp;&nbsp;<input type="radio" name="ngrams_search_limit" value="50" checked ="checked"> 50
				&nbsp;&nbsp;&nbsp;<input type="radio" name="ngrams_search_limit" value="100"> 100
				&nbsp;&nbsp;&nbsp;<input type="radio" name="ngrams_search_limit" value="200"> 200<br/>
				<br/>
				
				<input type="submit" value="Search Sentences">
			</form>
		</div>
		
		<div id="searchResults" style="margin-top: 20px; padding: 0 .7em;">
			Search Results Will Appear Here <br/>
			<%
				if (request.getSession().getAttribute("SentencesSearchResult") != null) {
					System.out.println("Found");

					int count = 0;
					for (Sentence sentence : (List<Sentence>) request.getSession().getAttribute("SentencesSearchResult")) {
						String buttonClass = count%2==0?"button2":"button3";
						%>
						<button class="button <%=buttonClass%>"><%=sentence.getValue()%></button><br/>
			
						<%
				count++;
				}
				}
			%>

		</div>
	
	</div> <!-- PARENT -->

	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script>
		$("[id*=controlgroup]").controlgroup();
	</script>
</body>
</html>