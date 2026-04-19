<!DOCTYPE html>
<html>
<head>
<title>User Form</title>

<script>
function validateForm() {
    let name = document.forms["myForm"]["username"].value;
    let email = document.forms["myForm"]["email"].value;
    let designation = document.forms["myForm"]["designation"].value;

    if (name == "" || email == "" || designation == "") {
        alert("All fields are required!");
        return false;
    }

    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if (!email.match(emailPattern)) {
        alert("Invalid Email format!");
        return false;
    }

    return true;
}
</script>

</head>
<body>

<h2>User Details Form</h2>

<form name="myForm" action="UserDataServlet" method="post" onsubmit="return validateForm()">

    Username: <input type="text" name="username"><br><br>
    Email: <input type="text" name="email"><br><br>
    Designation: <input type="text" name="designation"><br><br>

    <input type="submit" value="Submit">

</form>

</body>
</html>