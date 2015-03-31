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

<link rel="stylesheet" type="text/css" href="css/datepicker/bootstrap-datetimepicker.min.css">

</head>

<body>
	<s:include value="../header2.jsp"></s:include>

	<div class="container">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			<li><a href="page!userpage.action">个人中心</a> <span
				class="divider">/</span></li>
			<li><a href="page!userinfo.action">我的资料</a><span
				class="divider">/</span></li> 
			<li class="active"><a href="page!editeuserinfo.action">修改资料</a> 
		</ul>
		<div class="container">

			<div class="row-fluid">
				<!-- 左边栏 -->
				<div class="span2" id="userinfo">
					<s:include value="userinfo/userinfo-left.jsp"></s:include>
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
							<h4>修改资料</h4>
						</div>
					</div>
					
					<div class="row-fluid">
					<div class="span7">
					<form class="form-horizontal" action="user!userinfoedite.action" method="post">
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">账号</label>
							<div class="controls">
								<div id="info1"><s:property value="#session.user.mail"/></div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">昵称</label>
							<div class="controls">
								<input type="text" name="nickname" style="width: 50%; margin-left: 6%;" value='<s:property value="#session.user.nickname"/>' maxlength="20" data-toggle="tooltip" title="请输入用户昵称"/>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">性别</label>
							<div class="controls">
							  <s:if test="#session.user.gender==0">
							    <input type="radio" name="gender" value="0" checked="checked" style="margin-left: 6%;"/>&nbsp;男
								<input type="radio" name="gender" value="1" style="margin-left: 6%;"/>&nbsp;女
							  </s:if>
							  <s:else>
							    <input type="radio" name="gender" value="0" style="margin-left: 6%;"/>&nbsp;男
								<input type="radio" name="gender" value="1" checked="checked" style="margin-left: 6%;"/>&nbsp;女
							  </s:else>
								
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">出生日期</label>
							<div class="controls">
								<input type="text" name="borndate" style="width: 50%; margin-left: 6%;cursor: pointer;" id="datetimepicker" value="<s:property value="#session.user.borndate.substring(0,10)"/>" readonly="readonly"/>
						
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">学校</label>
							<div class="controls">
								<input type="text" name="college" style="width: 50%; margin-left: 6%;" value='<s:property value="#session.user.college"/>' maxlength="25"/>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">住址</label>
							<div class="controls">
								<input type="text" name="address" style="width: 50%; margin-left: 6%;" value='<s:property value="#session.user.address"/>' maxlength="25"/>
							</div>
						</div>
						<p><button class="btn btn-primary" id="editeinfo" style="width: 100px; margin-left: 24%;">保&nbsp;存</button></p>
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
	</div>

	<!-- 底板 -->
	<s:include value="../footer.jsp"></s:include>

<script type="text/javascript" src="js/datepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript">
       $.fn.datetimepicker.dates['cn'] = {
          days: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周末"],
          daysShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
          daysMin: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"],
          months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
          monthsShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
          today: "today"
        };       
        $('#datetimepicker').datetimepicker({
          autoclose:true,
          format: 'yyyy-mm-dd',
          startView:2,
          minView:2,
          viewSelect:'month',
        });
</script>

<script type="text/javascript">
   $("#editeinfo").click(function(){
      if($("input[name=nickname]").length==0){
         $("input[name=nickname]").tooltip('show');
      }else{
         $("form").submit();
      }
   });
</script>

</body>
</html>