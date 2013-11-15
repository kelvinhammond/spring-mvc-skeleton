<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="kelvin hammond">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="//netdna.bootstrapcdn.com/bootswatch/3.0.0/spacelab/bootstrap.min.css" rel="stylesheet">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <style>
	    .form-signin
		{
		    max-width: 330px;
		    padding: 15px;
		    margin: 0 auto;
		}
		.form-signin .form-signin-heading, .form-signin .checkbox
		{
		    margin-bottom: 10px;
		}
		.form-signin .checkbox
		{
		    font-weight: normal;
		}
		.form-signin .form-control
		{
		    position: relative;
		    font-size: 16px;
		    height: auto;
		    padding: 10px;
		    -webkit-box-sizing: border-box;
		    -moz-box-sizing: border-box;
		    box-sizing: border-box;
		}
		.form-signin .form-control:focus
		{
		    z-index: 2;
		}
		.form-signin input[type="text"]
		{
		    margin-bottom: -1px;
		    border-bottom-left-radius: 0;
		    border-bottom-right-radius: 0;
		}
		.form-signin input[type="password"]
		{
		    margin-bottom: 10px;
		    border-top-left-radius: 0;
		    border-top-right-radius: 0;
		}
		.account-wall
		{
		    margin-top: 20px;
		    padding: 40px 0px 20px 0px;
		    background-color: #f7f7f7;
		    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
		    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
		    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
		}
		.login-title
		{
		    color: #555;
		    font-size: 18px;
		    font-weight: 400;
		    display: block;
		}
		.profile-img
		{
		    width: 96px;
		    height: 96px;
		    margin: 0 auto 10px;
		    display: block;
		    -moz-border-radius: 50%;
		    -webkit-border-radius: 50%;
		    border-radius: 50%;
		}
		.need-help
		{
		    margin-top: 10px;
		}
		.new-account
		{
		    display: block;
		    margin-top: 10px;
		}
    </style>
    
  </head>

  <body>
	<div class="container">
	    <div class="row">
	        <div class="col-sm-6 col-md-4 col-md-offset-4">
	            <h1 class="text-center login-title">Sign in to continue</h1>
	            <div class="account-wall">
	                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
	                    alt="">
	                <form class="form-signin" method="POST" action="<c:url value='j_spring_security_check' />">
	                	<c:if test="${not empty error}">
	                		<div class="alert alert-danger">
	                			Login failed
							</div>
						</c:if>
		                <input type="text" name="j_username" class="form-control" placeholder="Username" required autofocus>
		                <input type="password" name="j_password" class="form-control" placeholder="Password" required>
		                <button class="btn btn-lg btn-primary btn-block" type="submit">
		                    Sign in</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>

  </body>
</html>
