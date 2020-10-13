<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<h2>Home Page</h2>

<hr/>

<p>Welcome to the Home Page</p>

<hr/>

<!-- Display User name and Role -->
<p>
    User: <security:authentication property="principal.username"/>
    <br/>
    Role(s): <security:authentication property="principal.authorities"/>
</p>

<div>
    <%-- Logout button --%>
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">
        <input type="submit" value="Logout"/>
    </form:form>
</div>

</body>
</html>
