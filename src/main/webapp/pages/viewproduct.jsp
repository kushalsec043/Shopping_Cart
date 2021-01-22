<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp to App!!!</title>
</head>

<style>
.center {
  margin: center;
  width: 60%;
  border: 3px solid orange;
  padding: 2px;
}
.btn {
  border: none; /* Remove borders */
  color: white; /* Add a text color */
  padding: 10px 40px; /* Add some padding */
  cursor: pointer; /* Add a pointer cursor on mouse-over */
}

.success {background-color: #4CAF50;} /* Green */
.success:hover {background-color: #46a049;}

.info {background-color: #2196F3;} /* Blue */
.info:hover {background: #0b7dda;}

.button4 {border-radius: 12px;}

img {
  border-radius: 12px;
}


* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 40%;
  padding: 30px;
  height: 600px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

.form-group {
    float:left;
    margin-left: 25px;
}

.product-preview-container {
    border: 1px solid #ccc;
    padding: 5px;
    width: 300px;
    margin: 10px ;
    display: inline-block;
    text-align:center;
}

.myImage {
  float: left;
  height: 75px;
  width: 135px;
  font-family: Veranda;
}
.heading {
  float:left;
}
</style>

<body>
<%

response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

if(session.getAttribute("username") == null)
{
	response.sendRedirect("welcome");
}
%>
<br></br>
<div class="form-group">
<form action="/homepage" method="get">
<button class="btn info button4" "type="submit">Back to Home-Page</button>
 </form>
 </div>
 

<div class="row">
<div class="column">

<form action="/homepage" method="get">
  <div>

    <h3><font color="blue">.__Product Information__.</font></h3>
    <hr>
  </div>
  <tr>
<h3><font color="black">Product: ${viewproduct.pname}</font></h3>
<h3><font color="black">Price: ${viewproduct.pprice} $</font></h3>
  <div>
	
	<img id="rcorners3" src="${viewproduct.pimage}" width="460" height="280"><br>
	
	<form action="/addtocartrepo" method="post">
<br>
    <h3><font color="red">${viewproduct.pname}  :-) <a href="/addtocartrepo?code=${viewproduct.pid}">  Add To Cart</a></h3><br>
  <br>
</form>
  </div>
      </tr>
</form>
</div>
<div class="column">
<h3><font color="blue">.__Ingredients__.</font></h3>
    <hr>
<br></br>
<c:forEach items="${viewingredient}" var="element"> 
   <div class="product-preview-container">
   <img src="${element.ingimage}" class="myImage"/>
  <h3 class="heading">${element.ingname}</h3>
      </div>
      
</c:forEach>
</div>
</div>

</body>

</html>
