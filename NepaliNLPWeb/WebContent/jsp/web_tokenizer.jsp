<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.icodejava.research.nlp.domain.WebProcessingResult"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Set"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tokenize a Website</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<style>

div.filler {
    width:800px;
    margin-top:40px;
    margin-bottom:40px;
}

div.class1 {
    width:1000px;
    margin:40px;
    ma`
}
div.parent{
	width:1000px;
	margin:20px;
	background:#009922
}
div.text {
	width:900px;
	margin:10px;
	background:#ee9933
}
div.sentences {
	width:900px;
	margin:10px;
	background:#ee9944
}
div.words {
	width:900px;
	margin:10px;
	background:#ee9955
}
div.wordsfrequencies {
	width:900px;
	margin:10px;
	background:#ee9966
}
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 7px 16px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button2 {background-color: #008CBA;margin:5px} /* Blue */
.button3 {background-color: #f44336;} /* Red */ 
.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 
.button5 {background-color: #555555;} /* Black */

</style>

</head>
<body>
	<%
		WebProcessingResult result = null;
		if (request.getSession().getAttribute("WebProcessingResult") != null) {
			result = (WebProcessingResult) request.getSession().getAttribute("WebProcessingResult");
		}
	%>
	


	<div class="parent">
	
	<div class="filler">
	<!-- FILLER -->
	</div>
	
	<!-- WEBSITE INPUT -->
	<div class="class1">
		<form name="submitForm" action="/NepaliNLPWeb/WebTokenizerServlet" method="post">
			Input a web page <input type="text" size="70" maxlength="500" name="website" id="website"><button class="ui-button ui-widget ui-corner-all">Submit</button>
		</form>
	</div>
	
	<!-- TEXT -->
	<div class="text">
		<br/>WEBSITE TEXT: <br/>
			<%
				if (result != null) {
			%>
			<br /><%=result.getText()%>
			<%
				}
			%>

		</div>
	
	<!-- SENTENCES -->
		<div class="sentences">
		<br/>SENTENCES<br/>

		<ol>
			<%
				if (result != null) {
					for (String sentence : result.getSentences()) {
			%>
			<li><%=sentence%></li>
			<%
				} //for loop
				} //if
			%>
			
			</ol>

		</div>

		<!-- WORDS -->
		<div class="words">
			<br/>WORDS<br/>
			
			<%
				if (result != null) {
					for (String word : result.getWords()) {
				%>
			
			<%=word + "|" %>
			<%
				} //for loop
				} //if
			%>

		</div>

		<!-- WORD FREQUENCY -->
		<div class="wordsfrequencies">
			<br />WORD FREQUENCIES<br />
			<%
				if (result != null) {
					int count = 0;
					Set<String> keys = result.getWordFrequencies().keySet();
					for (String wordKey : keys) {
					String buttonClass = count%2==0?"button2":"button3";
				%>
				<button class="button <%=buttonClass%>"><%=wordKey + "-->" + result.getWordFrequencies().get(wordKey) %></button>
			<%
				count++;
				} //for loop
				} //if
			%>

		</div>
	
</div>

</body>

	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script>
		$("[id*=controlgroup]").controlgroup();
		
		$("button").click(function(){
			alert:'Hello';
		   /*  $.ajax({url: "demo_test.txt", success: function(result){
		        $("#div1").html(result);
		    }}); */
		});
	</script>
</html>