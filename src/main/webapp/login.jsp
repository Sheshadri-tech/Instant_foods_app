<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
 
<style>
body {
font-family: Arial, sans-serif;
background: #f4f4f4;
}
 
.container {
width: 400px;
margin: 100px auto;
background: white;
padding: 30px;
border-radius: 10px;
box-shadow: 0 0 15px rgba(0,0,0,0.2);
}
 
h1 {
text-align: center;
}
 
label {
display: block;
margin-top: 10px;
}
 
input[type="email"],
input[type="password"] {
width: 100%;
padding: 10px;
margin-top: 5px;
margin-bottom: 15px;
box-sizing: border-box;
}
 
input[type="submit"] {
width: 100%;
padding: 10px;
background: orange;
color: white;
border: none;
cursor: pointer;
font-size: 16px;
}
 
input[type="submit"]:hover {
background: darkorange;
}
 
.link {
text-align: center;
margin-top: 15px;
}
</style>
 
</head>
 
<body>
 
<div class="container">
 
<h1>Login</h1>
 
login
 
<label>Email</label>
<input type="email" name="email" required>
 
<label>Password</label>
<input type="password" name="password" required>
 
<input type="submit" value="Login">
 
</form>
 
<div class="link">
New User?
register.jspRegister Here</a>
</div>
 
</div>
 
</body>
</html>