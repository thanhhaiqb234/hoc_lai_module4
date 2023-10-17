<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 10/17/2023
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="setting" method="post" action="/setting/form/update">
    <table>
        <tr>
            <h1>Settings</h1>
        </tr>
        <tr>
            <td style="display: none"><form:input path="id"/></td>
        </tr>
        <tr>

            <td>Languages :
                <form:select path="languages">
                    <form:options  items="${stringList}" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size :
                <form:select path="size">
                    <form:options  items="${integerList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Spams filter :
                <form:checkbox value="Enable spam filters" path="spamsFilter" label="Enable spam filters"/>
            </td>
        </tr>
        <tr>
            <td>Signature :
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr style="display: flex">
            <td>
                <button>
                    <a href="/setting/list" style="text-decoration: none">Cancel</a>
                </button>
            </td>
            <td>
                <button type="submit">Update</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
