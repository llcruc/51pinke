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
			<li><a href="page!usercourse.action">我的课程</a>
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
					
					<div class="usercoursetable">
					    <table class="table table-hover">
                           <thead>
								<tr>
									<th style="text-align: left;width: 60px;">大课节</th>
									<th style="width: 148px;">周一</th>
									<th style="width: 148px;">周二</th>
									<th style="width: 148px;">周三</th>
									<th style="width: 148px;">周四</th>
									<th style="width: 148px;">周五</th>
								</tr>
							</thead>
							<tbody>
							    <s:iterator value="coursenamelist" var="mycoursename">
							       <tr>
							          <td><s:property value="coursenum"/></td>
							          <td><a href="coursetable!info.action?courseid=${mon }"><s:property value="name1"/></a></td>
							          <td><a href="coursetable!info.action?courseid=${tues }"><s:property value="name2"/></a></td>
							          <td><a href="coursetable!info.action?courseid=${wed }"><s:property value="name3"/></a></td>
							          <td><a href="coursetable!info.action?courseid=${thur }"><s:property value="name4"/></a></td>
							          <td><a href="coursetable!info.action?courseid=${fri }"><s:property value="name5"/></a></td>
							       </tr>
							    </s:iterator>
							</tbody>
                        </table>
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