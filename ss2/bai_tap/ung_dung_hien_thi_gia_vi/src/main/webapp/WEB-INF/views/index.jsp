<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="form">
  <h1>Sandwich Condiments</h1>
  <input type="checkbox" name="spice" value="Lettuce">Lettuce
  <input type="checkbox" name="spice" value="Tomato">Tomato
  <input type="checkbox" name="spice" value="Mustard">Mustard
  <input type="checkbox" name="spice" value="Sprouts">Sprouts
  <br>
  <button type="submit">save</button>
</form>
<c:forEach var="spice" items="${spice}">
  <h3>${spice}</h3>
</c:forEach>
</form>
</body>
</html>