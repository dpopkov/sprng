<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

<div>
    <h3>Student Form</h3>
    <form:form action="processForm" modelAttribute="student">
        First Name: <form:input path="firstName"/>
        <br/><br/>
        Last Name: <form:input path="lastName"/>
        <br/><br/>
        <input type="submit" value="Submit"/>
    </form:form>
</div>

</body>
</html>
