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

<!-- 响应式 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>



</head>

<body>
	<s:include value="../header2.jsp"></s:include>

	<div class="container">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			<li><a href="page!userpage.action">个人中心</a> <span
				class="divider">/</span></li>
			<li><a href="page!usercourse.action">我的课程</a> <span class="divider">/</span></li>
			<li class="active">课程详情</li>
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
							<li  class="active"><a href="page!usercourse.action">我的课程</a></li>
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
							<h4>课程详情</h4>
						</div>
					</div>
					
					<div class="row-fluid">
					<div class="span7">
					<form class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">课程名</label>
							<div class="controls">
								<div id="info1">${rucCourse.coursename }</div>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">任课教师</label>
							<div class="controls">
								<div id="info1"><s:property value="rucTeacherService.getTeacherById(rucCourse.teacher).getTeachername()"/></div>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">课程类别</label>
							<div class="controls">
								<div id="info1">${rucCourse.coursecategory }</div>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">课程班</label>
							<div class="controls">
								<div id="info1">${rucCourse.classname }</div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">学分</label>
							<div class="controls">
								<div id="info1">${rucCourse.coursecredit }</div>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">上课时间</label>
							<div class="controls">
								<div id="info1">${rucCourse.coursetime }</div>
							</div>
						</div>
					</form>
					</div>
					<div class="span5">
					    
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