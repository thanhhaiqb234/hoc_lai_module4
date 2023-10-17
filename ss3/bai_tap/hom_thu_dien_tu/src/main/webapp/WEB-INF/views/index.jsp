<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<table class="table table-hover">
    <tr>
        <th>STT</th>
        <th>languages</th>
        <th>page size</th>
        <th>Spams filter</th>
        <th>signature</th>
    </tr>
    <tr>
        <c:forEach items="${settings}" var="setting" varStatus="count">
            <td><c:out value="${count.count}"/></td>
            <td><c:out value="${setting.languages}"/></td>
            <td><c:out value="${setting.size}"/></td>
            <c:choose>
                <c:when test="${setting.spamsFilter == true}">
                    <td>Enable spam filters</td>
                </c:when>
                <c:when test="${setting.spamsFilter == false}">
                    <td>No Spam filter enabled</td>
                </c:when>
            </c:choose>
            <td><c:out value="${setting.signature}"/></td>
            <td>
                <button><a href="/setting/edit/form/${setting.id}" style="text-decoration: none ; color: black">Edit</a>
                </button>
            </td>

        </c:forEach>
    </tr>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>