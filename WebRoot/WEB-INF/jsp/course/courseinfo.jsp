<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<link rel="stylesheet" href="css/buttons.css">


<style type="text/css">
.icon-chevron-right {
	float: right;
	margin-top: 2px;
	margin-right: -6px;
	opacity: 0.25;
}
</style>


</head>

<body>
	<s:include value="../header2.jsp"></s:include>

	<div class="container">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			<li><a href="page!ruccourse.action">课程中心</a> <span class="divider">/</span></li>
			<li class="active"><s:property value="rucCourse.coursename"/></li>
		</ul>
		<div class="container">

			<div class="row-fluid">
				<!-- 左边栏 -->
				<div class="span3" id="course_left bs-docs-sidebar" >
				 <div data-spy="affix" data-offset-top="160">
					<ul class="nav nav-list bs-docs-sidenav" >
						<li id="1"><a href="main!maincourse.action?cid=1&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px;margin-right: -6px;"></i> 通识教育大讲堂</a></li>
						<li id="2"><a href="main!maincourse.action?cid=2&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 全校共同课</a></li>
						<li id="3"><a href="main!maincourse.action?cid=3&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 人文艺术类</a></li>
						<li id="4"><a href="main!maincourse.action?cid=4&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 原典选读类</a></li>
						<li id="5"><a href="main!maincourse.action?cid=5&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 应用基础课</a></li>
						<li id="6"><a href="main!maincourse.action?cid=6&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 经济类</a></li>
						<li id="7"><a href="main!maincourse.action?cid=7&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 管理类</a></li>
						<li id="8"><a href="main!maincourse.action?cid=8&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 法政类</a></li>
						<li id="9"><a href="main!maincourse.action?cid=9&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 理工类</a></li>
						<li id="10"><a href="main!maincourse.action?cid=10&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 专业选修</a></li>
						<li id="11"><a href="main!maincourse.action?cid=11&pageNow=1"><i class="icon-chevron-right" style="margin-top: 2px; margin-right: -6px;"></i> 专业必修</a></li>
					</ul>
                 </div>
				</div>
				
				<script type="text/javascript">
				    $(function(){
				       $("#${cid}").addClass("active");
				    });
				</script>
				<!-- 右边栏 -->
				<div class="span9">
				   <div id="course_header">
							<h4 style="padding-top: 10px; margin-bottom: 0px;color: rgb(2, 61, 92);margin-left: 7px;">课程信息</h4>
					</div>
				   
				   <div class="span12">
				      <div class="row-fluid">
					<div class="span8">
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
					<div class="span4">
					    <s:if test="rucCourse.courseimg==null">
				            <img alt="${rucCourse.coursename }" class="course_img2" src="<%=basePath%>data/course/default.jpg"/>
				        </s:if>
				        <s:else>
				             <img alt="${rucCourse.coursename }" class="course_img2" src="<%=basePath%>data/course/images/${rucCourse.coursetimeid }.jpg">
				        </s:else>
					    <p style="text-align: center;margin-top: 10px;"><a href="<%=basePath %>course!editeinfo.action?courseid=<s:property value="courseid"/>" class="button button-rounded button-flat-highlight"><i class="icon-cog icon-white" style="float: none;opacity:10;margin-top: 0px;margin-right: 5px;"></i>参与编辑该信息</a>
					</div>
					
					<div class="span12">
					    ${rucCourse.courseinfo }
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