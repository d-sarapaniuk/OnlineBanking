<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h1>Sign Up</h1>
<form action="SignupServlet" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required><br>
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required><br>
    <label for="phone">Phone Number:</label>
    <input type="text" id="phone" name="phone" required><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>
    <button type="submit">Register</button>
</form>
</body>
</html>