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
					       <h1 id="registe-header">欢迎注册拼课网账号</h1>
					      </div>
                    </div>
                   </div>
				</div>
				
                 <div class="container">
                    <form name="registe" class="form-horizontal" style="margin-left: 19%;margin-top: 50px;" action="<%=basePath%>user!registe.action" method="post" onsubmit="return (nicknamecheck()&&passwordcheck()&&repasswordcheck()&&mailcheck());">
						<div class="control-group">
							<label class="control-label" for="#">邮箱</label>
							<div class="controls">
								<input type="text" name="mail" style="width: 50%; margin-left: 6%;"/>
								<span class="help-block" id="mail-help">请输入您的邮箱</span>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="#">昵称</label>
							<div class="controls">
								<input type="text" name="nickname" style="width: 50%; margin-left: 6%;" maxlength="12" autocomplete="off"/>
								<span class="help-block" id="nickname-help">请输入一个昵称</span>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="#">密码</label>
							<div class="controls">
								<input type="password" name="password" style="width: 50%; margin-left: 6%;" maxlength="20" autocomplete="off"/>
								<span class="help-block" id="password-help">6-20个字符，区分大小写</span>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="#">确认密码</label>
							<div class="controls">
								<input type="password" name="repassword" style="width: 50%; margin-left: 6%;" autocomplete="off"/>
								<span class="help-block" id="repassword-help">请再次输入密码</span>
							</div>
						</div>
						
						<button id="registe" type="submit" class="button-rounded button button-flat-primary button-large">立即注册</button>
						
					</form>
                 </div>
		     </div>
		</div>
	</div>
	
	<s:include value="../footer.jsp"></s:include>
	
	<!-- 验证用户名 -->
	<script type="text/javascript">
	   function mailcheck(){
	       var mail=$('input[name=mail]').val();
	       var url = "validatemail";
		   var search_str = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
		   var ok=false;
		   if(!search_str.test(mail)){
		      $('#mail-help').html("<sapn class='form-err'>邮箱格式错误！</span>");
		   }else{
		      $.ajax({
		         url:url,
		         type:"post",
		         data:{'mail':mail},
		         async : false, 
		         success :function(data){
		            if($(data).find('info').text()=='error'){
		               $('#mail-help').html("<sapn class='form-err'>邮箱已经被注册！</span>");
		            }else if($(data).find('info').text()=='success'){
		               $('#mail-help').html("<sapn class='form-suc'></span>");
		               ok=true;
		            }
		         }
		         }
		      );
		   }
		   return ok;
	     };
	     
	     function passwordcheck(){
	        var password=$('input[name=password]').val();
	        if(password.length<6){
	           $('#password-help').html("<sapn class='form-err'>请输入6-20位密码！</span>");
	           return false;
	        }else{
	           $('#password-help').html("<sapn class='form-suc'></span>");
	           return true;
	        } 
	     };
	     
	     function repasswordcheck(){
	        var password=$('input[name=password]').val();
	        var repassword=$('input[name=repassword]').val(); 
	        if(password!=repassword){
	           $('#repassword-help').html("<sapn class='form-err'>两次输入的密码不一致！</span>");
	           return false;
	        }else{
	           $('#repassword-help').html("<sapn class='form-suc'></span>");
	           return true;
	        }
	     };
	     
	     function nicknamecheck(){
	        var nickname=$('input[name=nickname]').val();
	        if(nickname.length==0){
	           $('#nickname-help').html("<sapn class='form-err'>请输入您的昵称！</span>");
	           return false;
	        }else{
	           $('#nickname-help').html("<sapn class='form-suc'></span>");
	           return true;
	        }
	     };
	     
	   $(function(){
	     $('input[name=mail]').blur(mailcheck);
         
         $('input[name=password]').blur(passwordcheck);
         
         $('input[name=repassword]').blur(repasswordcheck);
         
         $('input[name=nickname]').blur(nicknamecheck);
         
		 $('input[name=mail]').keyup(function(){
		    $('#mail-help').html('请输入您的邮箱'); 
		 });
		 $('input[name=password]').keyup(function(){
		    $('#password-help').html('6-20个字符，区分大小写');
		 });
		 $('input[name=repassword]').keyup(function(){
		    $('#repassword-help').html('请再次输入密码');
		 });
		 $('input[name=nickname]').keyup(function(){
		    $('#nickname-help').html('请输入一个昵称');
		 });
	   });
	</script>
	<!-- 注册表单提交 -->
	<script type="text/javascript">
	    function checkform(){
	       return false;
	    }
	</script>
	
	
	
  </body>
</html>
