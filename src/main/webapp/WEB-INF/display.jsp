<%@page 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" 
	session="false" %>
<jsp:useBean id="images" class="java.lang.String" scope="request" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  width: 100%;
}
img {
  height: auto;
  width: 80%;
}
td {
	padding: 5px;
}
</style>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="js/JSON-to-Table.min.1.0.0.js"></script>
<script type="text/javascript">
  var data = <% out.println(images); %>;
</script>
<script type="text/javascript">
$(document).ready(function () {
    var len = data.length;
    var src = '<table align="center" width="100%" border="0">\r\n<tr><th></th><th></th><th></th><th></th></tr>\r\n';
    for(var i=0; i < len; i++){
    	console.log("i=" + i);
    	console.log("(i % 4)=" + (i % 4));
        if ( i % 4 == 0) {
  	      src += '<tr><td><a href="' + data[i].url + 
  	  	        '" target=\"blank_\"><p align=\"center\"><img src="' + data[i].url +
  	  	        '" title="' + data[i].alt + '" ' +
  	  	        '" alt="' + data[i].alt + '"></p></a>' + 
  	            //'<br/>\r\n' +
  	            '<p align=\"center\">' + data[i].alt + '</p>\r\n' +
  	  	        '</td>';
        } else if ( (i % 4 == 1) || (i % 4 == 2)) {
   	      src += '<td><a href="' + data[i].url + 
  	        '" target=\"blank_\"><p align=\"center\"><img src="' + data[i].url + 
	        '" title="' + data[i].alt + '" ' +
  	        '" alt="' + data[i].alt + '"></p></a>' + 
            //'<br/>\r\n' +
            '<p align=\"center\">' + data[i].alt + '</p>\r\n' +
  	        '</td>\r\n';
        } else {
  	      src +=
  	  	        '<td><a href="' + data[i].url + 
  	  	        '" target=\"blank_\"><p align=\"center\"><img src="' + data[i].url + 
  	  	        '" title="' + data[i].alt + '" ' +
  	  	        '" alt="' + data[i].alt + '"></p></a>' + 
  	            //'<br/>\r\n' +
  	            '<p align=\"center\">' + data[i].alt + '</p>\r\n' +
  	  	        '</td></tr>\r\n';
        }
    }
/*    for(var i=0; i < len; i++){
    	console.log("i=" + i);
    	console.log("(i % 4)=" + (i % 4));
        if ( i % 4 == 0) {
  	      src += '<tr><td><a href="' + data[i].url + 
  	  	        '" target=\"blank_\"><div align=\"center\"><img src="' + data[i].url +
  	  	        '" title="' + data[i].alt + '" ' +
  	  	        '" alt="' + data[i].alt + '"></div></a>' + 
  	            '<br/>\r\n' +
  	            '<div align=\"center\">' + data[i].alt + '</div>\r\n' +
  	  	        '</td>';
        } else if ( (i % 4 == 1) || (i % 4 == 2)) {
   	      src += '<td><a href="' + data[i].url + 
  	        '" target=\"blank_\"><div align=\"center\"><img src="' + data[i].url + 
	        '" title="' + data[i].alt + '" ' +
  	        '" alt="' + data[i].alt + '"></div></a>' + 
            '<br/>\r\n' +
            '<div align=\"center\">' + data[i].alt + '</div>\r\n' +
  	        '</td>\r\n';
        } else {
  	      src +=
  	  	        '<td><a href="' + data[i].url + 
  	  	        '" target=\"blank_\"><div align=\"center\"><img src="' + data[i].url + 
  	  	        '" title="' + data[i].alt + '" ' +
  	  	        '" alt="' + data[i].alt + '"></div></a>' + 
  	            '<br/>\r\n' +
  	            '<div align=\"center\">' + data[i].alt + '</div>\r\n' +
  	  	        '</td></tr>\r\n';
        }
    } */
    src += '</table>';
    $("#headline_contents").append(src);
});
</script>
<title>Display Images</title>
</head>
<body>
	<div align="center">
		<h1>PhotoGallery</h1>
		<h5>Displaying your images.</h5>
	</div>
	<div align="right"><h3><%= request.getAttribute("id") %></h3></div>
	<hr/>
	<div id="headline_contents" class="customImage"></div>
	<div align="center">
		<form name="frm" method="post" action="/PhotoGallery/SignIn">
			<input type="hidden" name="id" value='<%= request.getAttribute("id") %>'" />
			<input type="button" class="btn btn-primary btn-sm" onClick=document.frm.submit(); value="back" />
		</form>	
	</div>
</body>
</html>
