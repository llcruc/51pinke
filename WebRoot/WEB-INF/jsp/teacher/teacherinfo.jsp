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
</style>


</head>

<body>
	<s:include value="../header2.jsp"></s:include>

	<div class="container">
		<ul class="breadcrumb">
			<li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			<li><a href="">教师中心</a> <span class="divider">/</span></li>
			<li class="active"><s:property value="rucTeacher.teachername"/></li>
		</ul>
		<div class="container">

			<div class="row-fluid">
				<!-- 右边栏 -->
				<div class="span12">
				   <div id="course_header">
							<h4 style="padding-top: 10px; margin-bottom: 0px;color: rgb(2, 61, 92);margin-left: 7px;">教师信息</h4>
					</div>
				   
				   <div class="span12">
				      <div class="row-fluid">
					<div class="span8">
					<form class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">教师姓名</label>
							<div class="controls">
								<div id="info1"><s:property value="rucTeacher.teachername"/></div>
							</div>
						</div>
						<div class="control-group">
						    <label class="control-label" for="#" style="color: #999;">讲授课程</label>
							<div class="controls">
								<div id="info1">
                                    <s:iterator value="courselist" status="index">
                                        <p><s:if test="#index.odd">
                                           <a href="<%=basePath%>course!info2.action?courseid=<s:property value="coursetimeid"/>" class="button glow button-rounded button-flat-primary"><s:property value="coursename"/></a>
                                        </s:if>
                                        <s:else>
                                           <a href="<%=basePath%>course!info2.action?courseid=<s:property value="coursetimeid"/>" class="button glow button-rounded button-flat-highlight"><s:property value="coursename"/></a>
                                        </s:else>
                                    </s:iterator>
                                </div>
							</div>
						</div>
						
						<div class="control-group">
							<label class="control-label" for="#" style="color: #999;">教师评分</label>
							<div class="controls">
							  <div id="info1">
								<span><div id="teacherscore" style="float: left;"></div>&nbsp;平均得分：<s:property value="rucTeacher.score"/></span>
								<br/>
								<br/>
								<a href="<%=basePath %>teacher!teacherinfo.action?teacherid=<s:property value="rucTeacher.teacherid"/>#teacherscore2" class="button glow button-pill button-rounded button-flat-action button-tiny">我要评分</a>
								
							  </div>
							</div>
						</div>
						
					</form>
					</div>
					<div class="span4" style="text-align: center;">
					    <s:if test="rucTeacher.teacherimg==null">
				            <img alt="<s:property value="rucTeacher.teachername"/>" style="width: 65%;" class="course_img2" src="<%=basePath%>data/teacher/default_teacher.jpg"/>
				        </s:if>
				        <s:else>
				             <img alt="<s:property value="rucTeacher.teachername"/>" style="width: 65%;" class="course_img2" src="data:image/jpg;base64,<s:property value="rucTeacher.teacherimg"/>">
				        </s:else>
					    <p style="text-align: center;margin-top: 10px;"><a href="<%=basePath %>teacher!editeinfo.action?teacherid=<s:property value="rucTeacher.teacherid"/>" class="button button-rounded button-flat-action"><i class="icon-cog icon-white" style="float: none;opacity:10;margin-top: 0px;margin-right: 5px;"></i>参与编辑该信息</a>
					</div>
					
					<div class="span12 info"  style="margin-top: 15px;">
					    ${rucTeacher.teacherinfo }
					    <br/>
					    我要评分：<div id="teacherscore2"></div>
					</div>
					
					
					</div>
				   </div>
				   
				</div>
			</div>

		</div>
	</div>

	<!-- 底板 -->
	<s:include value="../footer.jsp"></s:include>
	
    <script type="text/javascript" src="js/jquery.raty.js"></script>
    <script type="text/javascript" src="js/layer/layer.min.js"></script>
    <script type="text/javascript">
       $(function(){
          $("#teacherscore").raty({
             readOnly:  true,
             path:'img',
  	         starOn:    'star-on-l.png',
             starOff:   'star-off-l.png',
  	         score:   ${rucTeacher.score},
             starHalf: 'stat-half-l.png',
             number:10
          });
          
          $("#teacherscore2").raty({
             path:'img',
  	         starOn:    'star-on-l.png',
             starOff:   'star-off-l.png',
  	         score:   ${rucTeacher.score},
             hints: ['1分', '2分', '3分', '4分', '5分', '6分', '7分', '8分', '9分', '10分'],
             number:10,
             click:function(score, evt){
                var url="teacher!teacherscore.action";
                var userscore=score;
                $.post(
                   url,
                   {
                     'userscore':userscore,
                     'teacherid':${rucTeacher.teacherid }
                   },
                   function(data){
                      $("#teacherscore2").raty({
                               path:'img',
                               readOnly:true,
                               starOn:    'star-on-l.png',
                               starOff:   'star-off-l.png',
                               starHalf: 'stat-half-l.png',
                               score:score,
                               number:10
                      });
                      $.layer({
                                 type:0,
                                 shadeClose:true,
                                 shade: [0],
                                 fix: true,
                                 dialog: {
                                 type: -1,
                                 msg: '评分成功！'
                                 },
                                 end:function(){
                                     location.reload();
                                 }
                      });
                   }
                );
             }
          });
       });
    </script>
    


</body>
</html>