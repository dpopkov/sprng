<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring CRM REST Demo</title>
</head>
<body>

<h2>Spring CRM REST Demo</h2>

<p>List all Customers: <a href="${pageContext.request.contextPath}/api/customers">api/customers</a></p>
<p>Get 1-st Customer: <a href="${pageContext.request.contextPath}/api/customers/1">api/customers/1</a></p>
<p>Get 123-rd Customer (not existing): <a href="${pageContext.request.contextPath}/api/customers/123">api/customers/123</a></p>
<p>Bad request: <a href="${pageContext.request.contextPath}/api/customers/abc">api/customers/abc</a></p>

</body>
</html>
