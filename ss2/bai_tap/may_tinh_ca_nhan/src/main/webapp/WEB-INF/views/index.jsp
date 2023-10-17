<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="computer/sum">
  <h1>Caculator</h1>
  <input name="number1" required min="1" max="100" type="number">
  <input name="number2" required type="number">
  <br><br>
  <button name="calculation" value="+" type="submit">Addition(+)</button>
  <button name="calculation" value="-" type="submit">Addition(-)</button>
  <button name="calculation" value="*" type="submit">Addition(X)</button>
  <button name="calculation" value="/" type="submit">Addition(/)</button>
</form>
<c:choose>
  <c:when test="${sum != null}">
    <h1>${sum}</h1>
  </c:when>
  <c:when test="${sum == null}">
    <h1>${message}</h1>
  </c:when>
</c:choose>

</body>
</html>