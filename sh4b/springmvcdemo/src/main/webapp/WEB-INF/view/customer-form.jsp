<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Form</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>

<div>
    <h3>Customer Registration Form</h3>

    <p><em>Fill out the form. Asterisk (*) means required</em></p>

    <form:form action="processForm" modelAttribute="customer">
        First Name: <form:input path="firstName"/>
        <br/><br/>
        Last Name (*): <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
        <br/><br/>
        Free Passes (*): <form:input path="freePasses"/>
        <form:errors path="freePasses" cssClass="error"/>
        <br/><br/>
        Postal Code: <form:input path="postalCode"/>
        <form:errors path="postalCode" cssClass="error"/>
        <br/><br/>
        <input type="submit" value="Submit"/>
    </form:form>
</div>

</body>
</html>
