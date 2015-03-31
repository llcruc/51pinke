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
	<link rel="stylesheet" href="css/buttons.css">
	
	<style type="text/css">
	   #registe-header{
	     color: #2684C2;
         font: 26px "Microsoft Yahei","微软雅黑",SimSun,sans-serif;
         margin: 0px 70px;
         background: url("<%=basePath%>img/static/registe-user.gif") no-repeat scroll 0px 5px transparent;
         padding: 0px 0px 36px 30px;
	   }
	   .help-block{
	      margin-left: 16%;
	      color: #999 !important;
	   }
	   #registe{
         margin-left: 18%;
         width: 45%;
         margin-top: 3%;
	   }
	</style>

  </head>
  
  <body>
    <s:include value="../../header2.jsp"></s:include>
    
    <div id="bd">
		<div class="container">
			<ul class="breadcrumb">
			   <li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			   <li  class="active">登录拼课网</li>
		    </ul>
			
			
			<div class="upload_widget">
				<div class="upload_header" style="height: 55px;">
				  <div class="container-fluid">
						<div class="row-fluid">
						  <div class="span12">
					       <h1 id="registe-header">请先登录</h1>
					      </div>
                    </div>
                   </div>
				</div>
				
                 <div class="container">
                    <form name="login" class="form-horizontal" style="margin-left: 19%;margin-top: 50px;" action="<%=basePath%>user!login2.action" method="post">
						<div class="control-group">
							<label class="control-label" for="#">邮箱</label>
							<div class="controls">
								<input type="text" name="mail" style="width: 50%; margin-left: 6%;" value='<s:property value="mail"/>'/>
								<span class="help-block" id="mail-help">请输入您的邮箱</span>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="#">密码</label>
							<div class="controls">
								<input type="password" name="password" style="width: 50%; margin-left: 6%;" maxlength="20" autocomplete="off"/>
								<span class="help-block" id="password-help">请输入您的密码</span>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="#"></label>
							<div class="controls">
								<a href="page!registepage.action" style="margin-left: 49%;">注册账号</a>
							</div>
						</div>
						
						<button id="registe" class="button-rounded button button-flat-primary button-large">立即登录</button>
					</form>
                 </div>
		     </div>
		</div>
	</div>
	
	<s:include value="../../footer.jsp"></s:include>
	
	<s:if test="#loginmsg!=null">
	   <s:if test="#loginmsg==2">
	      <script type="text/javascript">
	         $("#mail-help").html("<sapn class='form-err'>用户名不存在！</span>");
	      </script>
	   </s:if>
	   <s:elseif test="#loginmsg==1">
	      <script type="text/javascript">
	         $("#password-help").html("<sapn class='form-err'>密码错误！</span>");
	      </script>
	   </s:elseif>
	
	</s:if>
	
	<script type="text/javascript">
	   $(function(){
	      $("#registe").click(function(){
	         if($("input[name=mail]").val().length==0){
	            return false;
	         }else if($("input[name=password]".val().length==0)){
	            return false;
	         }else{
	            $("form[name=login]").submit();
	         }
	      });
	      
	       $('input[name=mail]').keyup(function(){
		    $('#mail-help').html('请输入您的邮箱'); 
		   });
		  
		   $('input[name=password]').keyup(function(){
		    $('#password-help').html('请输入您的密码');
		   });
	   
	   });
	</script>
    
  </body>
</html>
