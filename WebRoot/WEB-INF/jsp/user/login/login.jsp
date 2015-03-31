<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</head>

<body style="padding-left: 2px;padding-right: 5px;">
	<form name="login" action="user!login.action" method="post">
		<div class="loginform">
			<div class="form-horizontal">
				<div class="control-group">
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-user"></i></span> <input type="text" id="loginmail" name="mail" placeholder="账号/邮箱" value="<s:property value="mail"/>">
						</div>
					</div>
				</div>
				<div id="password-input" class="control-group">
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on"><i class="icon-lock"></i></span> <input
								type="password" id="loginpassword" name="password"
								placeholder="密码">
						</div>
					</div>
				</div>
				<div id="loginmsg">
				   <span style="color: red;"><s:property value="#loginmsg"/></span>
				</div>
				<button class="btn btn-primary" id="login">登录</button>
			</div>

			<div class="registe">
				忘记密码？&nbsp; |&nbsp; <a href="<%=basePath %>page!registepage.action" target="_blank">注册账号</a>
			</div>
		</div>
	</form>
		<script>
		$(document).ready(function() {
							//登录动作
							$('#login').click(function() {
							       $("from[name=login]").submit(function(data){
							          $('#loginmsg').empty();
									  $('#loginmsg').append("<font color='#B94A48'>"+ $(data).find('info').text()+ "</font color='#B94A48'>");
									  $('#password').val("");
							       });
							});
							$('#loginpassword').keyup(function() {
								$('#loginmsg').empty();
							});
						});
	  </script>
</body>
</html>
