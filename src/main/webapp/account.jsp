<%@ page import="model.BankAccount" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Account</title>
</head>
<body>
<h1>Your Account</h1>

<%
    BankAccount account = (BankAccount) session.getAttribute("account");
    if (account != null) {
%>

<p>Welcome, <%= account.getFirstName() %> <%= account.getLastName() %>!</p>
<p>Your balance: $<%= account.getBalance() %></p>
<h2>Transfer Money</h2>
<form action="account" method="post">
    <label for="toPhoneNumber">Recipient Phone Number:</label>
    <input type="text" id="toPhoneNumber" name="toPhoneNumber" required><br>
    <label for="amount">Amount:</label>
    <input type="number" id="amount" name="amount" step="0.01" required><br>
    <button type="submit">Transfer</button>
</form>

<form action="/" method="get">
    <button type="submit">Log out</button>
</form>

<%
    } else {
        response.sendRedirect("login");
    }
%>
</body>
</html>