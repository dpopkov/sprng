<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World - Input Form</title>
</head>
<body>

<div>
    <h3>Process Form</h3>
    <form action="processForm" method="GET">
        <label>
            Name:
            <input type="text" name="studentName" placeholder="What's your name?"/>
        </label>
        <input type="submit"/>
    </form>
</div>

<div>
    <h3>Process Form ver.2</h3>
    <form action="processFormVersionTwo" method="GET">
        <label>
            Name:
            <input type="text" name="studentName" placeholder="What's your name?"/>
        </label>
        <input type="submit"/>
    </form>
</div>

</body>
</html>
