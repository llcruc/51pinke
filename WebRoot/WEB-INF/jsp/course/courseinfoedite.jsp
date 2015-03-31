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
#editor {min-height:300px;overflow: auto;border: 2px solid #ECF8F3;}
.editor-back{
 padding: 60px;
margin-bottom: 30px;
font-size: 18px;
font-weight: 200;
line-height: 30px;
color: inherit;
background-color: #EEE;
border-radius: 6px;
}

</style>


</head>

<body>
	<s:include value="../header2.jsp"></s:include>
	
	

	<div class="container">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			<li><a href="page!ruccourse.action?cid=1&pageNow=1">课程中心</a> <span class="divider">/</span></li>
			<li class="active"><s:property value="rucCourse.coursename"/></li>
		</ul>
		<div class="container">

			<div class="row-fluid">
				
				<!-- 右边栏 -->
				<div class="span12">
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
					<div class="span3">
					    <s:if test="rucCourse.courseimg==null">
				            <img alt="${rucCourse.coursename }" class="course_img2" src="<%=basePath%>data/course/default.jpg"/>
				        </s:if>
				        <s:else>
				             <img alt="${rucCourse.coursename }" class="course_img2" src="<%=basePath%>data/course/images/${rucCourse.coursetimeid }.jpg">
				        </s:else>
					    <p style="text-align: center;margin-top: 10px;"><button id="picbutton" class="button button-rounded button-flat-caution"><i class="icon-camera icon-white" style="float: none;opacity:10;margin-top: 0px;margin-right: 5px;"></i>更改该照片</button>
					</div>
				
<div class="span12">
	<div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
      <div class="btn-group">
        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="icon-font"></i><b class="caret"></b></a>
          <ul class="dropdown-menu">
          </ul>
        </div>
      <div class="btn-group">
        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
          <ul class="dropdown-menu">
          <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
          <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
          <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
          </ul>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
        <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="icon-th-list"></i></a>
        <a class="btn" data-edit="insertorderedlist" title="Number list"><i class="icon-list"></i></a>
        <a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
        <a class="btn" data-edit="indent" title="Indent (Tab)"><i class="icon-indent-right"></i></a>
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
        <a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
        <a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
        <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
      </div>
      
      <div class="btn-group">
        <a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="icon-picture"></i></a>
        <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
      </div>
      <div class="btn-group">
        <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
      </div>
      <input type="text" data-edit="inserttext" id="voiceBtn" x-webkit-speech="">
    </div>
 
    <div id="editor">${rucCourse.courseinfo }</div>
    
    <br>
    <input type="file"  id="picFile" onchange="readFile(this)" style="display: none;"/>
    <form action="course!check.action" name="checkform" method="post">
       <input type="hidden" name="coursetimeid" value="${rucCourse.coursetimeid }"/>
       <input type="hidden" name="courseinfo" value=" "/>
       <input type="hidden" name="courseimg" value="nochange"/> 
    </form>
    <a style="text-decoration: none;cursor: pointer;" id="checkinfo" class="button-rounded button-flat-action button-large pull-right"><i class="icon-hand-right icon-white" style="margin-right: 10px;margin-top: 3px;"></i>提交修改请求</a>

</div>
					
					
					</div>
				   </div>
				   
				</div>
			</div>

		</div>
	</div>

	<!-- 底板 -->
	<s:include value="../footer.jsp"></s:include>
	<script type="text/javascript" src="js/bootstrap-wysiwyg.js"></script>
	<script type="text/javascript" src="js/jquery.hotkeys.js"></script>
	<script type="text/javascript">
	   function initToolbarBootstrapBindings() {
      var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier', 
            'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
            'Times New Roman', 'Verdana'],
            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
      $.each(fonts, function (idx, fontName) {
          fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
      });
      $('a[title]').tooltip({container:'body'});
    	$('.dropdown-menu input').click(function() {return false;})
		    .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
        .keydown('esc', function () {this.value='';$(this).change();});
 
      $('[data-role=magic-overlay]').each(function () { 
        var overlay = $(this), target = $(overlay.data('target')); 
        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
      });
      if ("onwebkitspeechchange"  in document.createElement("input")) {
        var editorOffset = $('#editor').offset();
        $('#voiceBtn').css('position','absolute').offset({top: editorOffset.top, left: editorOffset.left+$('#editor').innerWidth()-35});
      } else {
        $('#voiceBtn').hide();
      }
	};
	function showErrorAlert (reason, detail) {
		var msg='';
		if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
		else {
			console.log("error uploading file", reason, detail);
		}
		$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
		 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
	};
    initToolbarBootstrapBindings(); 
	$('#editor').wysiwyg({ fileUploadError: showErrorAlert} );
	</script>
	
	<script type="text/javascript">
	   function readFile(obj){
	      var file = obj.files[0];      
           //判断类型是不是图片  
         if(!/image\/\w+/.test(file.type)){     
                alert("请确保文件为图像类型");   
                return false;   
           }   
           var reader = new FileReader();   
           reader.readAsDataURL(file);   
           reader.onload = function(e){   
             $(".course_img2").attr("src",this.result);
             $("input[name=courseimg]").val(this.result);
           }
	   }
	   
	   $(function(){
	      $("#picbutton").click(function(){
	          $("#picFile").click();
	      });
	      
	      $("#checkinfo").click(function(){
	          $("input[name=courseinfo]").val($("#editor").html());
	          $("form[name=checkform]").submit();
	      });
	      
	   });
	   
	</script>


</body>
</html>