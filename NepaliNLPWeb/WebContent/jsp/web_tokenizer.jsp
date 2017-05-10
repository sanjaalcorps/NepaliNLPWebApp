<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.icodejava.research.nlp.database.WordsUnreferencedDB"%>
<%@ page import="com.icodejava.research.nlp.services.WordsUnreferencedService"%>
<%@ page import="com.icodejava.research.nlp.domain.Word"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tokenize a Website</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<style>
div.class1 {
    width:500px;
    margin: 40px;
}
</style>

<script>
$.validator.setDefaults({
		submitHandler: function() {
			alert("submitted!");
		}
	});

	$().ready(function() {
		
		// validate signup form on keyup and submit
		$("#submitForm").validate({
			rules: {
				website: "required"
				}
			},
			messages: {
				webste: "Please enter the website"
			}
		});

	});
	</script>


</head>
<body>

<!-- WEBSITE INPUT -->
<div class="class1">
<form name="submitForm" action="/NepaliNLPWeb/WebTokenizerServlet" method="post">
	Input a web page <input type="text" size="50" maxlength="500" name="website" id="website" required><input type="submit">
</form>
</div>

<!-- TEXT -->
<div>

</div>

<!-- SENTENCES -->
<div>
</div>

<!-- WORD FREQUENCY -->
<div>
</div>

</body>

	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script>
		$("[id*=controlgroup]").controlgroup();
		
		$("button").click(function(){
		    $.ajax({url: "demo_test.txt", success: function(result){
		        $("#div1").html(result);
		    }});
		});
	</script>
</html>