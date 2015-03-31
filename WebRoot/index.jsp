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

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>


</head>

<body>
	<div class="userbar">
		<ul class="userbar_inner">
			<s:if test="#session.user==null">
		    <li><a href="<%=basePath%>page!loginpage3.action">登录</a></li>
			<li><a href="<%=basePath %>page!registepage.action">注册</a></li>
		  </s:if>
		  <s:else>
		    <li><a href="<%=basePath%>page!userpage.action"><s:property value="#session.user.nickname"/></a></li>
		  </s:else>
		</ul>
	</div>

	<!-- 首頁和导航栏 -->
	<div class="container" id="header">
		<div class="masthead">
			<div class="span12" style="margin-left: 0px;">
				<div class="span3" style="margin-left: 0px; width: 15%;">
					<a href="<%=basePath%>"><img src="img/static/log.gif"
						style="width: 99%;height: 64px;margin-top:4;" /></a>
				</div>
				<div class="span7">
				 <form name="form1" action="<%=basePath %>search!search.action" method="post" target="_blank">
				 	<input class="input-medium" type="text"
						style="width: 60%;margin-top: 14px;" name="word"/>
					<button class="btn btn-info" type="submit"
						style="margin-left: 4%; height: 36px;width: 20%;" id="search-button">
						<i class="icon-search icon-white"
							style="margin-right: 18px; margin-top: 2px;"></i>搜一搜
					</button>
				</form>
				</div>
			</div>
		</div>

	</div>

	<div>
		<div class="navbar" id="navbar">
			<div class="navbar-inner">
				<div class="container">
					<div class="span6" style="margin-left: 0px;">
						<ul class="nav">
							<li class="menubar"><a href="<%=basePath%>">首页</a></li>
							<li class="menubar"><a href="main!maincourse.action?cid=1&pageNow=1">课程</a></li>
							<li class="menubar"><a href="#">名师</a></li>
							<li class="menubar"><a href="#">课件</a></li>
						</ul>
					</div>
					<ul class="myinfo">
						<li><a href="page!userpage.action"
							style="color: #FFF;font-size: 15px;margin-right:10px;">个人中心</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- 轮转照片与登录 -->
	<div class="container">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span9">
					<div id="myCarousel" class="carousel slide">
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>

						<div class="carousel-inner">
							<div class="active item">
								<img src="img/static/01.jpg" id="img" />
							</div>
							<div class="item">
								<img src="img/static/02.gif" id="img" />
							</div>
							<div class="item">
								<img src="img/static/03.jpg" id="img" />
							</div>
						</div>
						<a class="carousel-control left" href="#myCarousel"
							data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
							href="#myCarousel" data-slide="next">&rsaquo;</a>
					</div>
				</div>
				<script>
					$('.carousel').carousel({
						interval : 4000
					});
				</script>

				<div class="bs-docs-grid">
					<div class="span3" id="slidermenu-right">
						<iframe frameborder="0" scrolling="no" width="100%" src="page!filenum.action" id="filenumpage" height="100"></iframe>
					</div>
					<div class="span3" id="slidermenu-right2">
					  <s:if test="#session.user==null">
					    <iframe frameborder="0" scrolling="no" width="100%" src="page!loginpage.action" id="loginpage" height="238"></iframe>
					  </s:if>
					  <s:else>
					    <iframe frameborder="0" scrolling="no" width="100%" src="page!loginpage2.action" id="loginpage" height="238"></iframe>
					  </s:else>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 分类介绍 -->
	<div class="container">
		<div class="container-fluid">
			<div class="row-fluid show-grid">

				<div class="span4" id="classification1">
					<div class="discipline">学科类别&nbsp;&gt;</div>
					<div class="discipline2">
						管理学&nbsp;&nbsp;&nbsp;经济学&nbsp;&nbsp;&nbsp;历史&nbsp;&nbsp;&nbsp;法学&nbsp;&nbsp;&nbsp;哲学&nbsp;&nbsp;<br />
						<p>
						<p>教育学&nbsp;&nbsp;&nbsp;医学&nbsp;&nbsp;&nbsp;农学&nbsp;&nbsp;&nbsp;工学

					</div>
				</div>
				<div class="span4" id="classification2">
					<div class="discipline">热门课程&nbsp;&gt;</div>
					<div class="discipline2">
						数据库&nbsp;&nbsp;&nbsp;JAVA
						EE&nbsp;&nbsp;&nbsp;历史文书&nbsp;&nbsp;&nbsp;知识管理<br />
						<p>
						<p>宏观经济学&nbsp;&nbsp;&nbsp;电子文件管理&nbsp;&nbsp;&nbsp;VFP
					</div>
				</div>
				<div class="span4" id="classification3">
					<div class="discipline">热门高校&nbsp;&gt;</div>
					<div class="discipline2">
						人民大学&nbsp;&nbsp;&nbsp;北京大学&nbsp;&nbsp;&nbsp;清华大学&nbsp;&nbsp;&nbsp;复旦大学<br />
						<p>
						<p>南开大学&nbsp;&nbsp;&nbsp;上海交大
					</div>
				</div>

			</div>
		</div>
	</div>


	<!-- 各种内容的tab介绍 -->
	<div class="container" style="overflow: hidden;">
		<div class="span11" id="homecontent">
			<!-- 普通<ul class="nav nav-tabs" id="myTab"> -->
			<ul class="nav nav-pills" role="tablist" id="myTab">
				<li class="active"><a href="#course">精品课程</a></li>
				<li><a href="#coursepaper">优秀课件</a></li>
				<li><a href="#teacher">名校教师</a></li>
			</ul>

			<div class="tab-content">
				<!-- 课程 -->
				<div class="tab-pane active" id="course">
					<div class="span9" id="course_content">
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/mysql.gif"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>数据库教程</strong><br> <font size="-14px">
									学习使用SQL 访问和处理数据系统中的数据，这类数据...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/javaee.png"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>JAVA EE教程</strong><br> <font size="-14px">Java
									EE是sun公司推出的企业级应用程序版本...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/vfp.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>VFP教程</strong><br> <font size="-14px">Visual
									FoxPro是微软公司从Fox公司的FoxBase数...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/宏观经济学.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>宏观经济学</strong><br> <font size="-14px">使用国民收入、经济整体投资和消费等总体性的统计概念...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/历史文书.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>历史文书</strong><br> <font size="-14px">将我国历史文书的起源、发展演变过程加以总结，分为...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/管理学.gif"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>管理学</strong><br> <font size="-14px">是研究管理活动的基本规律和一般方法的科学。管理学是...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!-- 课件 -->
				<div class="tab-pane" id="coursepaper">
					<div class="span9" id="course_content">
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/mysql.gif"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>数据库教程</strong><br> <font size="-14px">
									学习使用SQL 访问和处理数据系统中的数据，这类数据...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>

						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/vfp.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>VFP教程</strong><br> <font size="-14px">Visual
									FoxPro是微软公司从Fox公司的FoxBase数...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/javaee.png"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>JAVA EE教程</strong><br> <font size="-14px">Java
									EE是sun公司推出的企业级应用程序版本...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/宏观经济学.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>宏观经济学</strong><br> <font size="-14px">使用国民收入、经济整体投资和消费等总体性的统计概念...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/历史文书.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>历史文书</strong><br> <font size="-14px">将我国历史文书的起源、发展演变过程加以总结，分为...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/管理学.gif"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>管理学</strong><br> <font size="-14px">是研究管理活动的基本规律和一般方法的科学。管理学是...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!-- 教师 -->
				<div class="tab-pane" id="teacher">
					<div class="span9" id="course_content">

						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/javaee.png"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>JAVA EE教程</strong><br> <font size="-14px">Java
									EE是sun公司推出的企业级应用程序版本...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/mysql.gif"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>数据库教程</strong><br> <font size="-14px">
									学习使用SQL 访问和处理数据系统中的数据，这类数据...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/vfp.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>VFP教程</strong><br> <font size="-14px">Visual
									FoxPro是微软公司从Fox公司的FoxBase数...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/宏观经济学.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>宏观经济学</strong><br> <font size="-14px">使用国民收入、经济整体投资和消费等总体性的统计概念...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/历史文书.jpg"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>历史文书</strong><br> <font size="-14px">将我国历史文书的起源、发展演变过程加以总结，分为...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
						<div class="span3 course_content2">
							<div class="course_image image_border">
								<img src="data/course/images/管理学.gif"
									class="img-polaroid image_border">
							</div>
							<div class="course_name">
								<strong>管理学</strong><br> <font size="-14px">是研究管理活动的基本规律和一般方法的科学。管理学是...</font>
							</div>
							<div class="course_paper">
								<ul class="ul_homecontent">
									<li class="ppt">数据库程序设计</li>
									<li class="pdf">数据库程序设计</li>
									<li class="word">数据库程序设计</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- 底板 -->
<footer class="bs-docs-footer" role="contentinfo">
  <div class="container">
    <ul class="bs-docs-footer-links muted">
      <p  style="margin-bottom: 0px;">当前版本： v1.0.0</p>
      <p style="margin-bottom: 0px;">项目作者：刘力超</p>
      <p style="margin-bottom: 0px;">联系我们：274564873@qq.com</p>
      <p style="margin-bottom: 0px;">友情链接：<a href="http://liulichao.com/ructime/" target="_blank">人大时光</a>
      <p style="margin-bottom: 0px;"><a href="http://www.irm.cn/" target="_blank">School Of Information Resourse Management</a>.<a href="http://www.ruc.edu.cn/" target="_blank">RenMin University Of China</a></p>
      <p style="margin-bottom: 0px;"><a href="http://page.renren.com/601564038?checked=true" target="_blank">2012级档案班</a></p>
    </ul>
  </div>
</footer>


	<!-- tab鼠标经过特效 -->
	<script>
		$(function() {
			$('#myTab a').hover(function(e) {
				$(this).tab('show');
			});
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


	<!-- 注册表单 -->
	<script>
		$(function() {
			//tooltips
			$('#email_address,#password,#password2,#registebutton').tooltip({
				trigger : 'focus',
				placement : 'top'
			});
			//验证邮箱
			$("#email_address").blur(function() {
				var mail = $('#email_address').val();
				var url = "validatemail";
				var search_str = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
				$.post(url, {
					'mail' : mail
				}, function(data) {
					if (($(data).find('info').text()) == 'error') {
						$('.validate_signsuc').attr("style", "display:none;");
						$('#error2').attr("style", "display:none;");
						$('#error1').removeAttr("style");
					}
					if (($(data).find('info').text()) == 'success') {
						$('#error2').attr("style", "display:none;");
						$('#error1').attr("style", "display:none;");
						$('.validate_signsuc').removeAttr("style");
					}
					if (!search_str.test(mail)) {
						$('.validate_signsuc').attr("style", "display:none;");
						$('#error1').attr("style", "display:none;");
						$('#error2').removeAttr("style");
					}
					;
				});
			});

			//验证密码
			$('#password').keyup(function() {
				var password = $(this).val();
				var password2 = $('#password2').val();
				if (password.length<6 || password.length>12) {
					$('.validate_signsuc2').attr("style", "display:none;");
					$('.validate_signerr2').removeAttr("style");
				} else {
					$('.validate_signerr2').attr("style", "display:none;");
					$('.validate_signsuc2').removeAttr("style");
				}
				if (password != password2) {
					$('.validate_signsuc3').attr("style", "display:none;");
					$('.validate_signerr3').removeAttr("style");
				} else {
					$('.validate_signerr3').attr("style", "display:none;");
					$('.validate_signsuc3').removeAttr("style");
				}
			});

			//验证第二次输入密码
			$('#password2').keyup(function() {
				var password2 = $(this).val();
				var password = $('#password').val();
				if (password != password2) {
					$('.validate_signsuc3').attr("style", "display:none;");
					$('.validate_signerr3').removeAttr("style");
				} else {
					$('.validate_signerr3').attr("style", "display:none;");
					$('.validate_signsuc3').removeAttr("style");
				}
			});

			//整体表单验证
			$(document)
					.keyup(
							function(e) {
								if ($(".validate_signsuc").attr('style') == null
										&& $(".validate_signsuc2")
												.attr('style') == null
										&& $(".validate_signsuc3")
												.attr('style') == null) {
									$("#registebutton").removeClass("disabled");
									$("#registebutton").removeAttr(
											"data-original-title");
									$("#registebutton").removeAttr("disabled");
								} else {
									$("#registebutton").addClass("disabled");
									$("#registebutton").attr(
											"data-original-title", "请输入完整信息");
									$("#registebutton").attr("disabled",
											"disabled");
								}
							});

			//注册动作
			$("#registebutton").click(function() {
				var mail = $('#email_address').val();
				var password = $('#password').val();
				var url = "registe";
				var $btn = $(this).button('loading');
				$.post(url, {
					'mail' : mail,
					'password' : password
				}, function(data) {
					if (($(data).find('info').text()) == 'success') {
						$btn.button('reset');
						$("#myModal").modal('hide');
						$("#myModal2").modal('show');
					}
				});
			});
		});
	</script>

	<!-- 其他各种ajax动作 -->
	
   
   <script type="text/javascript">
     $("#search-button").click(function(){
      var word=$("input[name=word]").val();
      if(word.length==0){
          location.reload();
    	  return false;
      }else{
    	  $("form[name=form1]").submit();
      }
     });
  </script>
</body>
</html>
