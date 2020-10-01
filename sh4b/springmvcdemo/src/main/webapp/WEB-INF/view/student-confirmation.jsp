<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

<h2>Student Confirmation</h2>

<p>First Name: ${student.firstName}</p>
<p>Last Name: ${student.lastName}</p>
<p>Country: ${student.country}</p>
<p>Favorite Programming Language: ${student.favoriteLanguage}</p>
<div>Operation Systems:
    <ul>
    <c:forEach var="os" items="${student.operatingSystems}">
        <li>${os}</li>
    </c:forEach>
    </ul>
</div>

</body>
</html>
