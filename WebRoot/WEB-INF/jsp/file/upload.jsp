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
				<div class="upload_header">
				  <div class="container-fluid">
						<div class="row-fluid">
						  <div class="span2">
					       <h2 style="color: #19A97B;margin-top: 0px;">上传文档</h2>
					      </div>
					      <div class="span6">
					        <div class="progress progress-striped active" style="margin-top: 10px; margin-left: 10%; width: 90%;">
                                               <div class="bar" style="width: 0%;"></div>
                           </div>
                          </div>
                          <div class="span4">
                           <div id="uploadinfo" style="margin-left: 5%;margin-top: 10px;"></div>
                          </div>
                    </div></div>
				</div>

				<div class="upload_form">
					<div class="container-fluid">
						<div class="row-fluid">
							<div role="form" class="form-horizontal">
								<div class="span6" style="border-right: 1px solid #EBEBEB;">
									<div class="form-group">
										<label for="file" class="col-sm-2 control-label">选择文件：</label>
										<div class="col-sm-10">
											<div id="uploadbutton" style="height: 20px;"></div>
										</div>
									</div>
									<form id="fileinfo" method="post" action="fileinfo">
									<div class="form-group" style="margin-top: -30px;">
										<label for="title" class="col-sm-2 control-label">标题：</label>
										<div class="col-sm-10" style="margin-top: 55px;">
											<input type="text" class="form-control" id="title"
												placeholder="请输入文档标题" name="title" style="width: 70%; margin-left: 5%;">
										</div>
									</div>
									<div class="form-group">
										<label for="introduction" class="col-sm-2 control-label">简介：</label>
										<div class="col-sm-10">
											<textarea class="form-control" placeholder="请输入文档简介，200字以内"
												style="width: 70%; margin-left: 5%;height: 150px;resize: none;" id="introduction" name="introduction"></textarea>
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
											<input type="text" class="form-control" id="tips"
												placeholder="输入文档标签，多个标签逗号隔开"
												style="width: 70%; margin-left: 5%;" name="tips">
										</div>
									</div>

									<div class="form-group">
										<label for="tips2" class="col-sm-2 control-label">标签：</label>
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
											<select  class="form-control"
												style="margin-left: 5%;"  id="selector" name="fileprice">
												<option value=0>免费</option>
												<option value=1>1</option>
												<option value=2>2</option>
												<option value=5>5</option>
												<option value=8>8</option>
											</select>
										</div>
										
									</div>
							
									<input type="hidden" id="fileid" name="fileid"/>
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
	<s:include value="../footer.jsp"></s:include>

    
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
	
	<!-- 文件上传进度显示 -->
	<script>
	    $(document).ready(function(){
           $("#uploadbutton").uploadify({
	    		//开启调试
        'debug' : false,
        //是否自动上传
        //'auto':false,
        //超时时间
        'successTimeout':99999,
        //附带值
        'formData':{
            userid1:<s:property value="#session.user.userid"/>
        },
        'buttonClass' : 'uploadify-button',
        //flash
        'swf': "js/uploadify.swf",
        //不执行默认的onSelect事件
        //'overrideEvents' : ['onDialogClose'],
        //文件选择后的容器ID
        //'queueID':'uploadfileQueue',
        //服务器端脚本使用的文件对象的名称 $_FILES个['upload']
        'fileObjName':'file',
        //上传处理程序
        'uploader':'upload',
        //浏览按钮的背景图片路径
        //'buttonImage':'upbutton.gif',
        //浏览按钮的宽度
        'width':'120',
        //浏览按钮的高度
        'height':'34',
        //expressInstall.swf文件的路径。
        'expressInstall':'expressInstall.swf',
        //在浏览窗口底部的文件类型下拉菜单中显示的文本
        'fileTypeDesc':'支持的格式：',
        //允许上传的文件后缀
        'fileTypeExts':'*.doc;*.docx;*.ppt;*.pptx;*.pdf',
        //上传文件的大小限制
        'fileSizeLimit':'100MB',
        //上传数量
        'queueSizeLimit' : 1,
        //完成后
        //'removeCompleted' : false,
        //按钮文字
        'buttonText' : '选择文件',
        //每次更新上载的文件的进展
        'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
             //有时候上传进度什么想自己个性化控制，可以利用这个方法
             //使用方法见官方说明
             $(".bar").attr('style','width:'+ parseInt((totalBytesUploaded/totalBytesTotal)*100)+'%;');
             $("#uploadinfo").html(parseInt((totalBytesUploaded/totalBytesTotal)*100)+"%<a href='#' id='cancle'><img src='img/uploadify-cancel.png' style='margin-left:10px;'></img></a>");
             $('#cancle').click(function(){
       		  $('#uploadbutton').uploadify('cancel');
       	  });
        },
        //选择上传文件后调用
        'onSelect' : function(file) {
             $('.uploadify-queue-item').attr("style","display:none;");  
        },
        //返回一个错误，选择文件的时候触发
        'onSelectError':function(file, errorCode, errorMsg){
        	switch(errorCode) {
            case -100:
                alert("上传的文件数量已经超出系统限制的"+$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");
                break;
            case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
            	$("#uploadinfo").html("<ul><li class='upload_signerr'>文件大小超出规定</li></ul>");
                break;
            case -120:
            	$("#uploadinfo").html("<ul><li class='upload_signerr'>文件大小异常</li></ul>");
                break;
            case -130:
                alert("文件 ["+file.name+"] 类型不正确！");
                break;
        }
        },
        //检测FLASH失败调用
        'onFallback':function(){
            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
        },
        //上传到服务器，服务器返回相应信息到data里
        'onUploadSuccess':function(file, data, response){
        	var xmlinfo=$.parseXML(data);
            if($(xmlinfo).find('info').text()=='success'){
            	//alert($(xmlinfo).text());
               $('.progress').addClass('progress-success');
               $("#uploadinfo").html("<ul><li class='upload_signsuc'>文件上传成功，请编辑信息后提交</li></ul>");
               $("#title").val($(xmlinfo).find('filename').text());
               $("#fileid").val($(xmlinfo).find('fileid').text());
            }
        },
        'onUploadError' : function(file, errorCode, errorMsg, errorString) {
        	switch(errorCode) {
        	   case -280:
        		    $("#uploadinfo").html("<ul><li class='upload_signerr'>用户取消了上传文件</li></ul>");
        		    break;
        	   default:
               	    $("#uploadinfo").html("<ul><li class='upload_signerr'>上传失败"+errorCode+"</li></ul>");
        	        break;
        	}
        },
        'onCancel' : function(file) {
        	$("#uploadinfo").html("<ul><li class='upload_signerr'>用户取消了上传文件</li></ul>");
        }
           
          });
        });
	</script>
	
	<!-- 点击取消上传文件 -->
	<script>
	  $('#cancle').click(function(){
		  $('#uploadbutton').uploadify('cancel');
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
								cid : 12
							}, {
								cid : 111
							}, {
								cid : 2
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
		   if(introduction!=""){
			   $("#fileinfo").submit();
		   }else{
			   alert("请输入文档描述");
		   }
	   });
	
	</script>

</body>
</html>
