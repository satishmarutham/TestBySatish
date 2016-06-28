
<html>
	<head>
	
	<link rel="apple-touch-icon" sizes="57x57" href="images/fevicon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="images/fevicon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="images/fevicon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="images/fevicon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="images/fevicon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="images/fevicon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="images/fevicon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="images/fevicon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="images/fevicon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="images/fevicon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="images/fevicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="images/fevicon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="images/fevicon/favicon-16x16.png">
<link rel="manifest" href="images/fevicon/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

<link type="text/css" rel="stylesheet" href="CSS/newUI/bootstrap.min.css">

<link rel="stylesheet" href="CSS/login/font-awesome.min.css">

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>

<script type="text/javascript" src="JS/login/Admin.js"></script>

<script src="JS/newUI/jquery-1.9.1.min.js"></script>
		<style>
		h2{background: #07aab9;
    color: #fff;
    font-family: Roboto Regular;
    margin: 0;
    padding: 5px 35%;
    width: 100%;
	text-align:center}
	
	.up3:after{
		    background: none repeat scroll 0 0 rgb(255, 255, 255);
    bottom: 0;
    content: "";
    display: block;
    height: 1px;
        margin-top: 4px;
    width: 100%;
    float: left;
    z-index: 9999;
	}
	.up4:after{
		    background: none repeat scroll 0 0 rgb(255, 255, 255);
    bottom: 0;
    content: "";
    display: block;
    height: 1px;
        margin-top: -40px;
    width: 100%;

    z-index: 9999;
	}
	.btn-primary{
		    background-color: #07AAB9;
    border-color: #07AAB9;
	}
	.btn-primary.active, .btn-primary.focus, .btn-primary:active, .btn-primary:focus, .btn-primary:hover, .open>.dropdown-toggle.btn-primary{
		    background-color: #15848E;
    border-color: #15848E;
	}
	</style>
		<title>Log in form</title>
	</head>
	<body style="padding-top: 0px;background:#1f3f56 !important">
	<div class="col-md-12" style="border-bottom:1px solid #07AAB9;">
		<img src="images/logo.png">
	</div>
	<div class="col-md-12">
	&nbsp;&nbsp;<br/><br/><br/><br/><br/><br/>
	</div>
	<div class="col-md-4 col-md-offset-4" style="padding:0;border: 1px solid #07aab9;border-radius: 5px 5px 0px 0px;">
		<span class="up3" style="    padding: 0;
    margin: 0;
    float: left;
    width: 35%;">&nbsp;</span><h2>Sign In</h2><span class="up4" style="    padding: 0;
    margin: 0;
    float: right;
    width: 35%;">&nbsp;</span>
	</div>
	
		<div class="col-md-4 col-md-offset-4" style="border-right: 1px solid #07aab9;border-left: 1px solid #07aab9;border-radius: 0;background: #fff;">
			<form action="login.html?method=login" method="post" method="post">
			 <hr> 
			
				<div class="input-group">
					<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
					<input type="text" class="form-control" name="username" id="user_name" placeholder="User Name" >
				</div><br/>
				
				<div class="input-group">
					<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
					<input type="password" class="form-control" name="password"  id="user_password" placeholder="Password" >
				</div>
					<br/>
					<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return validateFields()" style="border-radius: 5px;margin-top: 10px;font-family: Roboto Medium;"><i class="fa fa-sign-in"></i> Login</button><br/>
					<center><span style="padding-left: 10%; color: red;" class="loginTips"></span></center>
				</form>
		</div>
		<div class="col-md-4 col-md-offset-4" style="padding:0;background: #fff;    border-radius: 0 0 5px 5px;    border-right: 1px solid #07aab9;    border-left: 1px solid #07aab9;    border-bottom: 1px solid #07aab9;">
			
		</div>
				
			
		<div class="col-md-12">
			<p style="border-top: 1px solid #07AAB9;    width: 100%;    margin: 155px 0 10px;font-family:Roboto Regular;color: #fff;">Powered By &nbsp;<span><a href="http://www.centrisinfotech.com" target="blank"style="color: #fff;">CENTRIS INFOTECH</a></span></p>
		</div>
		 <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
	</body>
</html>
