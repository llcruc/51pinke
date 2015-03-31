<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<link rel="stylesheet" type="text/css" href="css/uploadify.css">

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>



</head>

<body>
	<s:include value="../header2.jsp"></s:include>

	<div id="bd">
		<div class="container">
			<ul class="breadcrumb">
			   <li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			   <li  class="active">上传我的文档</li>
		    </ul>
			<div class="upload_widget">
				<div class="upload_header" style="height: 55px;">
				  <div class="container-fluid">
						<div class="row-fluid">
						  <div class="span2">
					       <h2 style="color: #19A97B;margin-top: 0px;">上传文档</h2>
					      </div>
					      <div class="span6">
                          </div>
                          <div class="span4">
                           <div id="uploadinfo" style="margin-left: 5%;margin-top: 10px;"></div>
                          </div>
                    </div></div>
				</div>
                    <div style="margin-left: 24%; margin-top: 60px;">
				   <ul ><li class='upload_signsuc2'><h3>恭喜您，文件信息已成功保存</h3></li>
				        <li class="backupload"><a href="<%=basePath %>page!uploadpage.action" style="color: rgb(25, 169, 123);">继续上传</a></li>
				   </ul>
				
				    </div>
				
				</div>
				
				

			</div>

		</div>

	<!-- 底板 -->
	<s:include value="../footer.jsp"></s:include>


</body>
</html>
