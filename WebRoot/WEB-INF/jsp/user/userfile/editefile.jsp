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

<style type="text/css">
   #editefile-header{
	     color: #2684C2;
         font: 26px "Microsoft Yahei","微软雅黑",SimSun,sans-serif;
         margin: 0px 17px;
         padding: 0px 0px 36px 30px;
	   }
</style>

</head>

<body>
	<s:include value="../../header2.jsp"></s:include>

	<div id="bd">
		<div class="container">
			<ul class="breadcrumb">
			   <li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			   <li  class="active">编辑文档信息</li>
		    </ul>
			<div class="upload_widget">
				<div class="upload_header">
				  <div class="container-fluid">
						<div class="row-fluid">
						  <div class="span12">
					       <h1 id="editefile-header">编辑文档信息</h1>
					      </div>
                    </div></div>
				</div>

				<div class="upload_form">
					<div class="container-fluid">
						<div class="row-fluid">
							<div role="form" class="form-horizontal">
								<div class="span6" style="border-right: 1px solid #EBEBEB;">
									<form id="fileinfo" method="post" action="file!deletefile.action">
									<div class="form-group" style="margin-top: -30px;">
										<label for="title" class="col-sm-2 control-label">标题：</label>
										<div class="col-sm-10" style="margin-top: 72px;">
											<input type="text" class="form-control" id="title"
												placeholder="请输入文档标题" name="title" value="<s:property value="fileEntity.title"/>" style="width: 70%; margin-left: 5%;">
										</div>
									</div>
									<div class="form-group">
										<label for="introduction" class="col-sm-2 control-label">简介：</label>
										<div class="col-sm-10">
											<textarea class="form-control" placeholder="请输入文档简介，200字以内"
												style="width: 70%; margin-left: 5%;height: 150px;resize: none;" id="introduction" name="introduction"><s:property value="fileEntity.introduction"/></textarea>
										</div>
									</div>
									<div class="form-group">
										<label for="divCate2" class="col-sm-2 control-label">选择分类：</label>
										<div class="col-sm-10">
											<div class="form-control" id="divCate2"
												style="width: 70%; margin-left: 22%;"></div>
										</div>
									</div>
								</div>

								<div class="span6">
									<div class="form-group">
										<label for="tips" class="col-sm-2 control-label">标签：</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="tips" placeholder="输入文档标签，多个标签逗号隔开" style="width: 70%; margin-left: 5%;" name="tips" value="<s:property value="fileEntity.tips"/>">
										</div>
									</div>

									<div class="form-group">
										<label for="tips2" class="col-sm-2 control-label">类型：</label>
										<div class="col-sm-10">
										  <div class="radiobutton" style="margin-left: 23%;">
											<label class="radio-inline"> <input type="radio"
												name="ispublic" id="inlineRadio1" value="0" checked>
												公开文档
											</label> <label class="radio-inline" style="margin-top: 12px;"> <input type="radio"
												name="ispublic" id="inlineRadio2" value="1">
												私有文档
											</label>
											</div>
										</div>
									</div>
                                   
                                   
									<div class="form-group" style="height: 32px;">
										<label for="selector" class="col-sm-2 control-label"  id="selector1">售价：</label>
										<div class="col-sm-10">
											<select  class="form-control" style="margin-left: 5%;"  id="selector" name="fileprice">
												<option value=0 <s:if test="fileEntity.price==0">selected="selected"</s:if>>免费</option>
												<option value=1 <s:if test="fileEntity.price==1">selected="selected"</s:if>>1</option>
												<option value=2 <s:if test="fileEntity.price==2">selected="selected"</s:if>>2</option>
												<option value=5 <s:if test="fileEntity.price==5">selected="selected"</s:if>>5</option>
												<option value=8 <s:if test="fileEntity.price==8">selected="selected"</s:if>>8</option>
											</select>
										</div>
										
									</div>
							
									<input type="hidden" id="fileid" name="fileid" value="<s:property value="fileEntity.fileid"/>"/>
									<input type="hidden" id="category" name="category"/>         
								</form>	
									<button id="savainfo" type="button" class="btn btn-primary btn-lg btn-block" style="font-size: 20px;margin-top: 70px; width: 50%; margin-left: 25%; height: 50px;">
									<span class="icon-circle-arrow-up icon-white" style="margin-right: 18px;"></span>保存信息</button>
									
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- 底板 -->
	<s:include value="../../footer.jsp"></s:include>

    
    <!-- 引入上传js -->
    <script type="text/javascript" src="js/swfobject.js"></script>
    <script type="text/javascript" src="js/jquery.uploadify.min.js"></script>
    <script type="text/javascript" src="js/category.js"></script>
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
	
	<!-- radio选中隐藏售价事件 -->
	<script>
	    $(function(){
	       $("#inlineRadio1").click(function(){
	          $("#selector").attr("style","display:inline;margin-left: 5%;");
	          $("#selector1").attr("style","display:inline");
	       });
	       $("#inlineRadio2").click(function(){
	          $("#selector,#selector1").attr("style","display:none");
	       });
	    });
	</script>
	

	<!-- 分类选择栏 -->
	<script>
		$(document)
				.ready(
						function() {
							var category2 = $("#divCate2").category({
								onSelect : function(cid, level, name) {
									this.setCategoryName();
								}
							});
							category2.selectItems = [ {
								cid :  ${fileEntity.category.substring(0,fileEntity.category.indexOf(','))}
							}, {
								cid : ${fileEntity.category.substring(fileEntity.category.indexOf(',')+1,fileEntity.category.lastIndexOf(','))}
							}, {
								cid : ${fileEntity.category.substring(fileEntity.category.lastIndexOf(',')+1,fileEntity.category.length())}
							} ];
							category2.getCategory = function(cid, level) {
								var cate = null;
								$
										.ajax({
											type : "GET",
											async : false,
											url : "js/data/categorydata.txt",
											data : "T=" + Math.random(),
											success : function(data) {
												var sourceData = eval("("
														+ data + ")");
												if (typeof cid == undefined
														|| cid == null) {
													cate = sourceData; //注意：这里直接return sourceData是不行的！
													return cate;
												}
												if (sourceData.list) {
													for (var i = 0; i < sourceData.list.length; i++) {
														if (sourceData.list[i].cid == cid) {
															cate = sourceData.list[i];
															break;
														}
													}
													if (cate == null) {
														for (var i = 0; i < sourceData.list.length; i++) {
															cate = category2
																	._getCategory(
																			sourceData.list[i],
																			cid);
															if (cate != null) {
																break;
															}
														}
													}
												}
											},
											error : function(data) {
												alert(data);
											}
										});
								return cate;
							};

							//设置完成后通过load方法加载
							category2.load();
						});
	</script>
	
	<!-- 点击提交按钮后表单验证与提交 -->
	<script>
	   $("#savainfo").click(function(){
		   var title=$("#title").val();
		   var introduction=$("#introduction").val();
		   var category=$("#hid_category0").val();
		   var tips=$("tips").val();
		   var ispublic=$("input[name='ispublic']").val();
		   var fileprice=$("selector").val();
		   $("#category").val(category);
		   if(introduction!="" && title!=""){
			   $("#fileinfo").submit();
		   }else{
			   return false;
		   }
	   });
	
	</script>

</body>
</html>
