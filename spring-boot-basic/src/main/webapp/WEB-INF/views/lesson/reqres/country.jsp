<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HELLO</title>
</head>
<body>
<form action="/countries/addCountry3" method="post">
    <input type="text" name="country">
    <input type="text" name="capital">
    <input type="submit">
</form>
<h1>${country}</h1>
<h1>${capital}</h1>
</body>
</html>