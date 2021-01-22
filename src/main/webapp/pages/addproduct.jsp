<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp to App!!!</title>
</head>

<style>
.center {
  margin: auto;
  width: 60%;
  border: 3px solid #73AD21;
  padding: 10px;
}
.btn {
  border: none; /* Remove borders */
  color: white; /* Add a text color */
  padding: 10px 18px; /* Add some padding */
  cursor: pointer; /* Add a pointer cursor on mouse-over */
}

.success {background-color: green;} /* Green */
.success:hover {background-color: #46a049;}

.success1 {background-color: red;} /* Green */
.success1:hover {background-color: #46a049;}

.info {background-color: #2196F3;} /* Blue */
.info:hover {background: #0b7dda;}

.button4 {border-radius: 12px;}


</style>

<body>
<%

response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

if(session.getAttribute("username") == null)
{
	response.sendRedirect("welcome");
}
%>
<br>
<form action="/products" method="get">
		<h3 class="center">ADD PRODUCT TO MART DATABASE!!!</h3>
		<div class="center">
    <button  class="btn info button4" type="submit">Back to Products Page</button>
 </div>
 </form><br>

<div class="row">
<div class="column">
<form action="/addtorepo" method="post">

  <div class="center">
   <div class="row">
	<div class="column">
	<h5><font color="red">${ProductMessage}</font></h5>
	
    <label for="pname"><b>Enter Product_Name</b></label>
    <input type="text" placeholder="Enter ProductName" name="pname" required><br>

	<br></br>
	
    <label for="pprice"><b>Enter Product_Price</b></label>
    <input type="number" placeholder="Enter ProductPrice" name="pprice" required><br>
    
    <br></br>
    
     <label for="pimage"><b>Enter a _Image_Url_</b></label>
    <input type="text" placeholder="Enter ProductImage" name="pimage" required><br>
    
    <br></br>
    </div>
    <div class="column">

    <button class="btn success button4" type="submit">_ADD_PRODUCT_</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>
</form>
</div>
<div class="column">
 <h5><font color="red">${addingredient}</font></h5>
 <h5><font color="red">${IngredientMessage}</font></h5>
<form action="/addingredients" method="post">

  <div class="center">
  <label for="ingname"><b>._Add INGREDIENTS_.</b></label><br></br>
 
    <input type="text" placeholder="Enter Ingredient-Name" name="ingname" required><br></br>
     <input type="text" placeholder="Enter Ingredient-ImageUrl" name="ingimage" required><br></br>
    <button class="btn success1 button4" type="submit">_ADD_Ingredient_</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
</div>
</form>
</div>
</div>
</body>

</html>