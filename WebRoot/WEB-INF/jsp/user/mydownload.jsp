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
<title>51pinke课件分享网</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="课程品鉴,课件分享,课表，名师">
<meta http-equiv="description" content="课程品鉴">


</head>

<body>
	<s:include value="../header2.jsp"></s:include>

	<div class="container">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			<li><a href="page!userpage.action">个人中心</a> <span
				class="divider">/</span></li>
			<li><a href="page!mydownload.action">我的下载</a>
		</ul>
		<div class="container">

			<div class="row-fluid">
				<!-- 左边栏 -->
				<div class="span2" id="userinfo">
					<div id="userinfo0">
						<s:include value="userinfo/userinfo-left.jsp"></s:include>
					</div>
					<div>
						<ul class="nav nav-pills nav-stacked" id="userinfo3">
							<li><a href="page!userpage.action">个人中心</a></li>
							<li><a href="page!userinfo.action">个人资料</a></li>
							<li><a href="page!userfile.action">我的文档</a></li>
							<li><a href="page!usercourse.action">我的课程</a></li>
							<li><a href="page!collect.action">我的收藏</a></li>
							<li class="active"><a href="page!mydownload.action">我的下载</a></li>
						</ul>
					</div>

				</div>
				<!-- 右边栏 -->
				<div class="span10" style="width: 80%;">
					<!-- 个人信息 -->
					<div id="userinfo_header">
						<div>
							<h4>我下载过的文档</h4>
						</div>
					</div>
					
					<!-- 我上传的课件 -->
					<iframe name="filelist" frameborder="0" scrolling="no" width="100%" onload="Javascript:iframeAutoFit(this)"
  	                      src="main!userdownfilelist.action?downlogpage=1" id="userfilelist" height="600px;"></iframe>
					
					</div>
					</div>
					
				</div>
			</div>

		</div>

	<!-- 底板 -->
	<s:include value="../footer.jsp"></s:include>


</body>
</html>