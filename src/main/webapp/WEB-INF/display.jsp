<%@page 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" 
	session="false" %>
<jsp:useBean id="images" class="java.lang.String" scope="request" />
<!DOCTYPE html>
<html>
<head>
<style>
table {
  width: 100%;
}
img {
  height: 200px;
  width: 266px;
}
td {
	padding: 30px;
}
</style>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="js/JSON-to-Table.min.1.0.0.js"></script>
<%  //images = new String(images.getBytes("UTF-8"), "UTF-8"); 
	System.out.println(images);
%>
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
        //console.log(src);
    }
    src += '</table>';
    $("#headline_contents").append(src);
});
</script>
<title>Display Images</title>
</head>
<body bgcolor="black">
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
