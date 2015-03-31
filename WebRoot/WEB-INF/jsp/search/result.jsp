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
<style type="text/css">
   
</style>
<script type="text/javascript">
      
    function iframeAutoFit(iframeObj){ 
    setTimeout(function(){if(!iframeObj) return;iframeObj.height=(iframeObj.Document?iframeObj.Document.body.scrollHeight:iframeObj.contentDocument.body.offsetHeight);},200) 
	}
   
</script>
</head>
<body>
	<s:include value="../header.jsp"></s:include>

	<div class="container" style="min-height: 70%;">
		<ul class="breadcrumb" style="padding: 0px 15px;">
			    <ul class="nav nav-tabs">
                    <li class="active" style="width: 130px;text-align: center;"><a href="" data-toggle="tab" id="file">文&nbsp;件(<span style="color:#993333"><s:property value="filenum"/></span>)</a></li>
                    <li style="width: 130px;text-align: center;"><a href="" data-toggle="tab" id="course">课&nbsp;程(<span style="color:#993333"><s:property value="coursenum"/></span>)</a></li>
                    <li style="width: 130px;text-align: center;"><a href="" data-toggle="tab" id="teacher">教&nbsp;师(<span style="color:#993333"><s:property value="teachernum"/></span>)</a></li>
               </ul> 
		</ul>
		<div class="container">
           <iframe frameborder="0" scrolling="no" width="100%" onload="Javascript:iframeAutoFit(this)"
  	       src="search!searchfile.action?word=<s:property value="word"/>&page=1" id="searchlist" ></iframe>

		</div>
	</div>

	<!-- 底板 -->
	<s:include value="../footer.jsp"></s:include>

    <script type="text/javascript">
    $(function(){
       $("input[name=word]").val("<s:property value="word" escape="false"/>");
    });
       
    </script>

	<!-- 导航栏鼠标经过特效 -->
	<script>
		$(document).ready(function() {
			$('.menubar').hover(function() {
				$(this).addClass('active');
			}, function() {
				$(this).removeClass('active');
			});
		});
	</script>
	
	<!-- iframe加载 -->
	<script type="text/javascript">
	   $(function(){
	      $("#file").click(function(){
	         $("#searchlist").attr("src","search!searchfile.action?word=<s:property value="word" escape="false"/>&page=1");
	      });
	      $("#course").click(function(){
	         $("#searchlist").attr("src","search!searchcourse.action?word=<s:property value="word" escape="false"/>&page=1");
	      });
	      $("#teacher").click(function(){
	         $("#searchlist").attr("src","search!searchteacher.action?word=<s:property value="word" escape="false"/>&page=1");
	      });
	   });
	</script>


</body>
</html>