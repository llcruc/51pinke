<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:property value="fileEntity.title"/></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/jquery.raty.css">
	
	<script type="text/javascript">
      
    function iframeAutoFit(iframeObj){ 
    setTimeout(function(){if(!iframeObj) return;iframeObj.height=(iframeObj.Document?iframeObj.Document.body.scrollHeight:iframeObj.contentDocument.body.offsetHeight);},200); 
	}
   
   </script>

  </head>
  
  <body>
     
     <s:include value="../header2.jsp"></s:include>
     <script type="text/javascript" src="js/jquery.raty.js"></script>
     <div class="container">
        <ul class="breadcrumb">
			<li><a href="<%=basePath%>">首页</a> <span class="divider">/</span></li>
			<li><a href=""><s:property value="categoryfirst"/></a> <span class="divider">/</span></li>
			<li><a href=""><s:property value="categorysecond"/></a><span class="divider">/</span></li>
			<li><a href=""><s:property value="categoryname"/></a></li>
		</ul>
		<p><h3><s:property value="fileEntity.title"/></h3>
		<p><span><fmt:formatNumber type="number" value="${fileEntity.filesize/(1024*1024)}" maxFractionDigits="2"/>  MB | 
		 <span id="filescore"></span>(<s:if test="fileEntity.scoretimes==0">暂无评价</s:if><s:else><s:property value="fileEntity.scoretimes"/>人评价 <fmt:formatNumber type="number" value="${fileEntity.score}" maxFractionDigits="1"/>分</s:else>) |浏览次数：<s:property value="fileEntity.browsetimes"/> |下载次数:<s:property value="fileEntity.downloadtimes"/> 次</span>
         <div class="row-fluid">
          <div class="span9">
           <iframe frameborder="0" scrolling="no" width="100%" height="700px" 
  	       src="file!flexpaper.action?fileid=<s:property value="fileid"/>" id="fileview" ></iframe>
  	       </div>
  	       <div class="span3">
  	         <div style="width: 100%;height: 150px;">
  	           <p><h5>文档贡献者</h5>
  	            <p><div class="file-user">
  	             <s:set name="usericon" value="user.usericon"></s:set>
  	              <s:if test="#usericon==null">
  	                 <img src="<%=basePath%>data/user/default.png" width="80%" class="img-polaroid">
  	              </s:if>
  	              <s:else>
  	                 <img src="data:image/png;base64,<s:property value="#usericon"/>" width="80%" class="img-polaroid">
  	              </s:else>
  	            </div>
  	            <div class="file-userinfo">
  	                <p><h6><s:property value="user.nickname"/></h6>
  	                <p>贡献于：<p>${fn:substringBefore(fileEntity.uploadtime, " ")}
  	            </div>
  	         </div>
  	         <hr/>
  	           <div style="height: 50px;">
  	           <s:if test="fileScoreService.findbyUserAndFile(fileEntity.userid,fileEntity.fileid).getId()!=0">
  	               <c:set var="score" value="${fileScoreService.findbyUserAndFile(fileEntity.userid,fileEntity.fileid).getUserscore()}"/>
  	               <div id="star1" class="score-star">
  	                  <div class="score-text">已评分：</div>
  	               </div>
  	               <div class="alert alert-success" style="width: 175px; text-align: center; margin-top: 5px;">
                     您的评分：${score }分
                   </div>
  	                  <script type="text/javascript">
  	                      $(function(){
  	                         $("#star1").raty({
  	                            readOnly:true,
  	                            path:'img',
  	                            starOn:    'star-on-l.png',
                                starOff:   'star-off-l.png',
  	                            score:   ${score},
                                starHalf: 'stat-half-l.png',
  	                         });
  	                      });
  	                  
  	                  </script>
  	           </s:if>
  	           <s:else>
  	            <div id="star" class="score-star">
  	               <div class="score-text">评分：</div>
  	            </div>
  	            <div class="alert alert-success" style="width: 175px; text-align: center; margin-top: 5px;display: none;">
                     评分成功！
                </div>
                <script type="text/javascript">
                  $("#star").raty({
	                  path:'img',
	                  hints: ['1分', '2分', '3分', '4分', '5分'],
	                  starOn:    'star-on-l.png',
                      starOff:   'star-off-l.png',
                      starHalf: 'stat-half-l.png',
                      click: function(score, evt) {
                      var url="file!filescore.action";
                      var userscore=score;
                      $.post(
                         url,
                         {
                           'userscore':userscore,
                           'fileid':<s:property value="fileid"/>
                         },
                         function(data){
                            $(".alert-success").text("评分成功，您的评分："+score+"分");
                            $(".alert-success").alert();
                            $(".alert-success").show();
                            $("#star").raty({
                               path:'img',
                               readOnly:true,
                               starOn:    'star-on-l.png',
                               starOff:   'star-off-l.png',
                               starHalf: 'stat-half-l.png',
                               score:score
                            });
                         }
                      );
               }
	        });
                </script>
               </s:else>
  	           </div>
  	         <hr/>
  	          <div>
  	           <p><s:if test="#session.user==null">
  	              <a href="page!loginpage3.action" style="text-decoration: none;"><button class="btn btn-large btn-block btn-primary" type="button"><i class="icon-star-empty icon-white"></i>&nbsp;收&nbsp;藏</button></a>
  	           </s:if>
  	           <s:else>
  	              <s:if test="fileCollectionService.findByUseridAndFileid(#session.user.userid,fileid).size()==0">
  	                 <button class="btn btn-large btn-block btn-primary" type="button" id="collectbutton"><i class="icon-star-empty icon-white"></i>&nbsp;收&nbsp;藏</button>
  	              </s:if>
  	              <s:else>
  	                 <button class="btn btn-large btn-block btn-primary disabled" type="button"><i class="icon-star-empty icon-white"></i>已&nbsp;收&nbsp;藏</button>
  	              </s:else>
  	           </s:else>
                <p>
                <p><s:if test="#session.user==null">
  	                 <a href="page!loginpage3.action" style="text-decoration: none;">
  	                     <button class="btn btn-large btn-block btn-success" type="button" id="downfile"><i class="icon-download-alt icon-white"></i>&nbsp;下&nbsp;载
                            <s:if test="fileEntity.fileprice==0">(免费)</s:if>
                            <s:else>(<s:property value="fileEntity.fileprice"/>金币)</s:else>
                         </button>
                     </a>
  	               </s:if>
  	               <s:else>
  	                 <button class="btn btn-large btn-block btn-success" type="button" id="downfile"><i class="icon-download-alt icon-white"></i>&nbsp;下&nbsp;载
                        <s:if test="fileEntity.fileprice==0">(免费)</s:if>
                        <s:else>(<s:property value="fileEntity.fileprice"/>金币)</s:else>
                     </button>
  	              </s:else>
                
  	          </div>
  	          <script type="text/javascript">
  	             $("#collectbutton").click(function(){
  	                var url="file!filecollect.action";
  	                $.post(url,
  	                  {
  	                    'fileid': "<s:property value="fileid"/>"
  	                  },
  	                  function(data){
  	                    $(this).addClass("disabled");
  	                  }
  	                );
  	                $(this).addClass("disabled");
  	                $(this).removeAttr("id");
  	                $(this).html("<i class='icon-star-empty icon-white'></i>已&nbsp;收&nbsp;藏");
  	             });
  	          </script>
  	          <hr/>
  	          
  	          <div class="likelyfile">
  	            <p><h5>相关文档推荐</h5>
  	             <ul class="ul_homecontent" var="file">
					<s:iterator value="likelylist">
					   <s:if test="filetype=='doc'||filetype=='docx'">
                           <li class="word">
                       </s:if>
                       <s:elseif test="filetype=='ppt'||filetype=='pptx'">
                           <li class="ppt">
                       </s:elseif>
                       <s:elseif test="filetype=='pdf'">
                           <li class="pdf">
                       </s:elseif>
                       
                       <a href="<%=basePath%>file!preview.action?fileid=<s:property value="fileid"/>" target="_blank" title="<s:property value="title"/>">
                          <s:if test="title.length()>10">
                             <s:property value="title.substring(0,10)"/>......
                          </s:if>
                          <s:else>
                            <s:property value="title"/>
                          </s:else>
                       </a>
					</s:iterator>
				</ul>
  	          </div>
  	          
  	          <hr/>
  	          
  	       </div>
         </div>
	 </div>
	 
	 
	 <iframe frameborder="0" scrolling="no" style="min-height: 330px;"width="100%" onload="Javascript:iframeAutoFit(this)"
  	src="file!loadcomment.action?fileid=<s:property value="fileid"/>&cpage=1" id="commentlist" ></iframe>
	 
	 
	 <div id="downmsg" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
        <h4 class="modal-title"><span class="glyphicon glyphicon-comment"></span>&nbsp;提示</h4>
      </div>
      <div class="modal-body" style="height: 100px;">
        <p><h4>下载将扣除<s:property value="fileEntity.fileprice"/>金币，确认继续吗？</h4></p>
      </div>
           <div class="modal-footer">
              <button type="button" class="btn" data-dismiss="modal" id="downbutton1">取消</button>
              <button type="button" class="btn btn-primary" id="downbutton2">确认</button>
           </div>
         </div>
       </div>
     </div>
	 
	 <s:include value="../footer.jsp"></s:include>
	 <s:if test="#session.user==null">
	     <script type="text/javascript">
	        $(function(){
	           $("#downfile").click(function(){
	            window.location.href="<%=basePath%>";
	          });
	        });
	    </script>
	 </s:if>
	 <s:else>
	 <s:if test="fileDownLogService.findByUserAndFile(#session.user.userid,fileid).getDownloadtime()==null">
	 <script type="text/javascript">
	     $(function(){
	          $("#downfile").click(function(){
	            $("#fileview").attr('style','display:none;');
	            $("#downmsg").modal('show');
	          });
	          $("#downbutton2").click(function(){
	            window.open("<%=basePath%>file!downfile.action?fileid=<s:property value="fileid"/>");
	            $("#downmsg").modal('hide');
	            $("#fileview").removeAttr('style');
	          });
	          $("#downbutton1,.close").click(function(){
	             $("#fileview").removeAttr('style');
	          });
	        
	     });
	 </script>
	 </s:if>
	 <s:else>
	    <script type="text/javascript">
	        $(function(){
	           $("#downfile").click(function(){
	            window.open("<%=basePath%>file!downfile.action?fileid=<s:property value="fileid"/>");
	          });
	        });
	    </script>
	 </s:else>
	 </s:else>
	 <script type="text/javascript" src="js/jquery.raty.js"></script>
	 <script type="text/javascript">
	     $(function(){
	        $("#filescore").raty({
	           readOnly:true,
	           hints: ['<fmt:formatNumber type="number" value="${fileEntity.score}" maxFractionDigits="1"/>分', '<fmt:formatNumber type="number" value="${fileEntity.score}" maxFractionDigits="1"/>分', '<fmt:formatNumber type="number" value="${fileEntity.score}" maxFractionDigits="1"/>分', '<fmt:formatNumber type="number" value="${fileEntity.score}" maxFractionDigits="1"/>分', '<fmt:formatNumber type="number" value="${fileEntity.score}" maxFractionDigits="1"/>分'],
	           score:     <fmt:formatNumber type="number" value="${fileEntity.score}" maxFractionDigits="1"/>,
               showHalf:  true,
	           path:'img',
	        });
	        
	     });
	 </script>
	 
  </body>
</html>
