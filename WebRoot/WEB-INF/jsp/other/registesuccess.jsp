<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>51pinke课程品鉴与课件分享</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	 #registe-header{
	     color: #2684C2;
         font: 26px "Microsoft Yahei","微软雅黑",SimSun,sans-serif;
         margin: 0px 70px;
         background: url("<%=basePath%>img/static/registe-user.gif") no-repeat scroll 0px 5px transparent;
         padding: 0px 0px 36px 30px;
	   }
	</style>

  </head>
  
  <body>
    <s:include value="../header2.jsp"></s:include>
    <div id="bd">
		<div class="container">
			<ul class="breadcrumb">
			   <li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			   <li  class="active">欢迎注册</li>
		    </ul>
			
			
			<div class="upload_widget">
				<div class="upload_header" style="height: 55px;">
				  <div class="container-fluid">
						<div class="row-fluid">
						  <div class="span12">
					       <h1 id="registe-header">注册成功</h1>
					      </div>
                    </div>
                   </div>
				</div>
				
                 <div class="container">
                    <div style="margin-left: 16%; margin-top: 110px;">
				      <ul ><li class='upload_signsuc2'><h3>恭喜您，注册成功，请尽快完善您的信息</h3></li>
				        <li class="backupload"><a href="<%=basePath %>page!editeuserinfo.action" style="color: rgb(25, 169, 123);">>>完善我的信息</a></li>
				      </ul>
				
				    </div>
                 </div>
		     </div>
		</div>
	</div>
	
	<s:include value="../footer.jsp"></s:include>
  </body>
</html>
