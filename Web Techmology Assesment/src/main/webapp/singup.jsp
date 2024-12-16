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
  <h2>User Sign Up</h2>
  <form id="signupForm" action="register" method="post">
    <div class="form-group">
      <label>First Name</label>
      <input type="text" class="form-control" name="firstName" required>
    </div>
    <div class="form-group">
      <label>Last Name</label>
      <input type="text" class="form-control" name="lastName" required>
    </div>
    <div class="form-group">
      <label>Email</label>
      <input type="email" id="email" class="form-control" name="email" required>
      <span id="emailError" class="text-danger"></span>
    </div>
    <div class="form-group">
      <label>Password</label>
      <input type="password" class="form-control" name="password" required>
    </div>
    <div class="form-group">
      <label>Confirm Password</label>
      <input type="password" class="form-control" name="confirmPassword" required>
    </div>
    <button type="submit" class="btn btn-primary">Sign Up</button>
  </form>
</div>
<script src="js/validation.js"></script>
</body>
</html>