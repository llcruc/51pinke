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

<title>My JSP 'header.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="课程品鉴,课件分享,课表，名师">
<meta http-equiv="description" content="课程品鉴">

<!-- 响应式 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" href="css/buttons.css">

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</head>

<body>
	<div class="userbar">
		<ul class="userbar_inner">
			<s:if test="#session.user==null">
		    <li><a href="<%=basePath%>page!loginpage3.action">登录</a></li>
			<li><a href="<%=basePath %>page!registepage.action">注册</a></li>
		  </s:if>
		  <s:else>
		    <li><a href="<%=basePath%>page!userpage.action"><s:property value="#session.user.nickname"/></a></li>
		  </s:else>
		</ul>
	</div>

	<!-- 首頁和导航栏 -->
	<div class="container" id="header">
		<div class="masthead">
			<div class="span12" style="margin-left: 0px;">
				<div class="span3" style="margin-left: 0px; width: 15%;">
					<a href="<%=basePath%>"><img src="img/static/log.gif"
						style="width: 99%;height: 64%;margin-top:4;" /></a>
				</div>
				<div class="span7">
					<form>
				 	<input class="input-medium" type="text"
						style="width: 60%;margin-top: 14px;" name="word"/>
					<button class="btn btn-info" type="submit"
						style="margin-left: 4%; height: 36px;width: 20%;" id="search-button">
						<i class="icon-search icon-white"
							style="margin-right: 18px; margin-top: 2px;"></i>搜一搜
					</button>
				   </form>
				</div>
			</div>
		</div>

	</div>

	<div>
		<div class="navbar" id="navbar">
			<div class="navbar-inner">
				<div class="container">
					<div class="span6" style="margin-left: 0px;">
						<ul class="nav">
							<li class="menubar"><a href="<%=basePath%>">首页</a></li>
							<li class="menubar"><a href="main!maincourse.action?cid=1&pageNow=1">课程</a></li>
							<li class="menubar"><a href="#">名师</a></li>
							<li class="menubar"><a href="#">课件</a></li>
						</ul>
					</div>
					<ul class="myinfo">
						<li><a href="page!userpage.action"
							style="color: #FFF;font-size: 15px;margin-right:10px;">个人中心</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
   $("#search-button").click(function(){
      var word=$("input[name=word]").val();
      if(word.length==0){
         window.location.href="<%=basePath%>";
    	 return false;
      }else{
    	 window.location.href="<%=basePath%>search!search.action?word="+word;
      }
     });
</script>
<!-- 导航栏鼠标经过特效 -->
	<script>
		$(document).ready(function() {
			$('.menubar').hover(function() {
				$(this).addClass('active');
			}, function() {
				$(this).removeClass('active');
			});
		});
	</script>
</body>
</html>
