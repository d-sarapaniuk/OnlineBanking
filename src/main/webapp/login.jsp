<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <label for="phone">Phone Number:</label>
    <input type="text" id="phone" name="phone" required><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>
    <button type="submit">Login</button>
</form>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<p style="color: red;"><%= errorMessage %></p>
<%
    }
%>

</body>
</html>