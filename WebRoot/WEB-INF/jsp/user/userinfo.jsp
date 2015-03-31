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



</head>

<body>
	<s:include value="../header2.jsp"></s:include>

	<div class="container">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			<li><a href="page!userpage.action">个人中心</a> <span
				class="divider">/</span></li>
			<li class="active"><a href="page!userinfo.action">我的资料</a> 
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
							<li class="active"><a href="page!userinfo.action">个人资料</a></li>
							<li><a href="page!userfile.action">我的文档</a></li>
							<li><a href="page!usercourse.action">我的课程</a></li>
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
							<h4>我的资料</h4><a href="page!editeuserinfo.action" style="float: right;"><i class="icon-pencil" style="margin-top: 1px; margin-right: 6px;"></i>编辑</a>
						</div>
					</div>
					
					<div class="row-fluid">
					<div class="span7">
					<form class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">账号</label>
							<div class="controls">
								<div id="info1"><s:property value="#session.user.mail"/></div>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">性别</label>
							<div class="controls">
								<div id="info1">
                                   <s:if test="#session.user.gender==0">男</s:if>
                                   <s:else>女</s:else>
                                </div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">昵称</label>
							<div class="controls">
								<div id="info1"><s:property value="#session.user.nickname"/></div>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">出生日期</label>
							<div class="controls">
								<div id="info1"><s:property value="#session.user.borndate.substring(0,10)"/></div>
							</div>
						</div>
						
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">学校</label>
							<div class="controls">
								<div id="info1"><s:property value="#session.user.college"/></div>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">住址</label>
							<div class="controls">
								<div id="info1"><s:property value="#session.user.address"/></div>
							</div>
						</div>
					</form>
					</div>
					<div class="span5">
					    <s:if test="#session.user.usericon==null">
					        <img src="<%=basePath%>data/user/default.png" class="img-polaroid" id="usericon2">
					    </s:if>
					    <s:else>
		                    <img src="data:image/png;base64,<s:property value="#session.user.usericon"/>" class="img-polaroid" id="usericon2"/>
		                </s:else>
					    <p class="changeicon"><a href="page!editeicon.action" ><button class="btn" type="button"><i class="icon-wrench "
							style="margin-right: 13px; margin-top: 2px;"></i>修改头像</button></a></p>
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