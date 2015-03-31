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
			<li><a href="page!usercourse.action">导入课表</a>
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
							<li class="active"><a href="page!usercourse.action">我的课程</a></li>
							<li><a href="page!collect.action">我的收藏</a></li>
							<li><a href="page!mydownload.action">我的下载</a></li>
						</ul>
					</div>

				</div>
				<!-- 右边栏 -->
				<div class="span10" style="width: 80%;">
					<!-- 个人信息 -->
					<div id="userinfo_header">
						<div>
							<h4>我的课程</h4>
						</div>
					</div>
					
					<div class="row-fluid">
					<div class="span7">
					<form class="form-horizontal" action="coursetable!coursetable.action" method="post">
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">学号</label>
							<div class="controls">
								<input type="text" style="width: 50%; margin-left: 6%;" name="studentid"/>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">密码</label>
							<div class="controls">
								<input type="password" style="width: 50%; margin-left: 6%;" name="studentpassword"/>
								<span class="help-block" style="margin-left: 24%; color: red;">*&nbsp;哥们"绝对"不会泄露以及保存你的密码</span>
							</div>
						</div>
						<p><button type="submit" class="btn btn-primary" type="button" style="width: 100px; margin-left: 24%;">提&nbsp;交</button></p>
					</form>
					</div>
					
					
					
					</div>
					
					</div>
					</div>
					
				</div>
			</div>

		</div>

	<!-- 底板 -->
	<s:include value="../footer.jsp"></s:include>


</body>
</html>