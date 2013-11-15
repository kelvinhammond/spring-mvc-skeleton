<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home Page</title>
	
	<!-- JQuery -->
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
	
    <!-- Bootstrap core CSS -->
    <!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="//netdna.bootstrapcdn.com/bootswatch/3.0.0/spacelab/bootstrap.min.css" rel="stylesheet">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
    
    <!-- MomentJS -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.4.0/moment.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
	<style type="text/css">
	  	.media
	    {
	        /*box-shadow:0px 0px 4px -2px #000;*/
	        margin: 20px 0;
	        padding:30px;
	    }
	    .dp
	    {
	        border:10px solid #eee;
	        transition: all 0.2s ease-in-out;
	    }
	    .dp:hover
	    {
	        border:2px solid #eee;
	        transform:rotate(360deg);
	        -ms-transform:rotate(360deg);  
	        -webkit-transform:rotate(360deg);  
	        /*-webkit-font-smoothing:antialiased;*/
	    }
	</style>
	
	<script type="text/javascript">
	$(function() {
		$("#lastlogin_timeago").text(
			moment(${lastlogin}).fromNow(true)
		);
	});
	</script>
</head>
<body>
	<div class="container">
		<div class="row">
		    <div class="col-lg-5">
		        <div class="media">
		            <a class="pull-left" href="#">
		                <img class="media-object dp img-circle" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100" style="width: 100px;height:100px;">
		            </a>
		            <div class="media-body">
		                <h4 class="media-heading">Hello, ${firstname} ${lastname}<small> USA</small></h4>
		                <h5>it has been <span id="lastlogin_timeago">a while</span> since you last logged in.</h5>
		                <hr style="margin:8px auto">
		
		                <span class="label label-default">HTML5/CSS3</span>
		                <span class="label label-default">jQuery</span>
		                <span class="label label-default">Bootstrap 3</span>
		                <span class="label label-default">Java</span>
		                <span class="label label-info">Spring</span>
		                <span class="label label-default">Hibernate</span>
		            </div>
		        </div>
		    </div>
		</div>
	</div>
</body>
</html>