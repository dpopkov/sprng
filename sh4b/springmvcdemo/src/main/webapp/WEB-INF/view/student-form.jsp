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
        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}"/>
        </form:select>
        <br/><br/>
        Favorite Language:
        <form:radiobutton path="favoriteLanguage" value="Java" label="Java"/>
        <form:radiobutton path="favoriteLanguage" value="Kotlin" label="Kotlin"/>
        <form:radiobutton path="favoriteLanguage" value="Python" label="Python"/>
        <form:radiobutton path="favoriteLanguage" value="JavaScript" label="JavaScript"/>
        <br/><br/>
        Operating Systems:
        <form:checkbox path="operatingSystems" value="Linux" label="Linux"/>
        <form:checkbox path="operatingSystems" value="MacOS" label="Mac OS"/>
        <form:checkbox path="operatingSystems" value="MsWindows" label="MS Windows"/>
        <br/><br/>
        <input type="submit" value="Submit"/>
    </form:form>
</div>

</body>
</html>
