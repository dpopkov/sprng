<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring REST Demo</title>
</head>
<body>

<h3>Spring REST Demo</h3>

<p><a href="${pageContext.request.contextPath}/test/hello">test/hello</a></p>
<p><a href="${pageContext.request.contextPath}/api/students">api/students</a></p>
<p><a href="${pageContext.request.contextPath}/api/students/0">api/students/0</a></p>
<p><a href="${pageContext.request.contextPath}/api/students/123">api/students/123</a></p>

</body>
</html>
