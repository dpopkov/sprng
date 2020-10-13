<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Login Page</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>

<h3>Custom Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
    <%-- Check for login erro --%>
    <c:if test="${param.error != null}">
        <p><em class="failed">Sorry! You entered invalid username/password!</em></p>
    </c:if>
    <p>User Name: <input type="text" name="username"/></p>
    <p>Password: <input type="password" name="password"/></p>
    <p><input type="submit" value="Login"/></p>
</form:form>

</body>
</html>
