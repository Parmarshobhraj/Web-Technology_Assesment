<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
    <h2>Forgot Password</h2>
    <form action="forgotpassword" method="post">
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" id="email" class="form-control" required>
            <span id="emailError" class="text-danger"></span>
        </div>
        <button type="submit" class="btn btn-primary">Send OTP</button>
    </form>
</div>
<script>
    document.getElementById("email").addEventListener("input", function () {
        const email = this.value;
        fetch("validateEmail?email=" + email)
            .then((response) => response.text())
            .then((data) => {
                document.getElementById("emailError").innerText =
                    data === "false" ? "Email is not registered!" : "";
            });
    });
</script>
</body>
</html>