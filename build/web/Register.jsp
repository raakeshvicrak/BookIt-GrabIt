s<%-- 
    Document   : Register
    Created on : Mar 19, 2015, 10:59:47 PM
    Author     : raakesh-pt503
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>BookIt@GrabIt</title>

    <style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body{
	margin: 0;
	padding: 0;
	background: #fff;

	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(http://i.huffpost.com/gen/1670028/images/o-SHOPPING-BAGS-facebook.jpg);
	background-size: cover;
	-webkit-filter: blur(5px);
	z-index: 0;
}

.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(0,0,0,0)), color-stop(100%,rgba(0,0,0,0.65))); /* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header{
	position: absolute;
	top: calc(50% - 35px);
	left: calc(50% - 255px);
	z-index: 2;
}

.header div{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.header div span{
	color: #5379fa !important;
}

.login{
	position: absolute;
	top: calc(50% - 75px);
	left: calc(50% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.login input[type=text]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login input[type=password]{
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 10px;
}

.login input[type=button]{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.login input[type=submit]{
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}


.login input[type=button]:hover{
	opacity: 0.8;
}

.login input[type=button]:active{
	opacity: 0.6;
}

.login input[type=text]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.login input[type=button]:focus{
	outline: none;
}

::-webkit-input-placeholder{
   color: rgba(255,255,255,0.6);
}

::-moz-input-placeholder{
   color: rgba(255,255,255,0.6);
}
</style>

    <script src="js/prefixfree.min.js"></script>

</head>

<body>

  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Sign Up</div>
		</div>
		<br>
		<div class="login">
                    <form name="register" action="RegisterUserValidate" method="post">
                        <input type="text" placeholder="username" name="username" id="username"><br>
			<input type="password" placeholder="password" name="password" id="password"><br>
                        <input type="password" placeholder="Confirm password" name="confirmpassword" id="confirmpassword"><br>
                        <input type="text" placeholder="Email-ID" name="email" id="emailid"><br>
                        <input type="submit" value="Register" onclick="return validate(this.form)">
                    </form>
		</div>
                
                <script>
                    function validate(form){
                        var username=document.getElementById("username").value;
                        var password=document.getElementById("password").value;
                        var confirmpassword=document.getElementById("confirmpassword").value;
                        var flag=false;
                        if(username===""){
                            flag=false;
                            alert("Empty username");
                        }
                        else{
                            document.getElementById("username").value=username;
                            if(document.getElementById("password").value==="" || document.getElementById("confirmpassword").value===""){
                                  alert("passwords empty");
                            }
                            else if(document.getElementById("password").value!==document.getElementById("confirmpassword").value){
                              alert("password mismatch");
                            }  
                            else{
                                if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.getElementById("emailid").value))  
                                {  
                                    flag=true;
                                }
                                else{
                                   s
                                    alert("Enter valid email id");
                                }
                              }
                            }
                        
                        if(flag===true){
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                </script>

  <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

</body>

</html>