<%@page import="org.apache.struts2.components.Else"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'filecomment.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <link rel="stylesheet" href="css/buttons.css">

    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/layer/layer.min.js"></script>

  </head>
  
  <body>
    <div class="container" style="width: 90%; margin-top: 10px;">
    
    
    <div class="highlight comment-header">
       <h4>最新评论</h4>
       <span class="pull-right">已有<span style="color:red;"><s:property value="cdatanum"/></span>条评论</span>
    </div>
    
    <s:iterator value="commentlist">
     <s:set name="user" value="userService.findUserById(userid)"></s:set>
    <div class="comment-body" style="height: 100px;border-bottom: 1px dotted #CCC;">
      <div class="media" style="margin-top: 10px;">
           <a class="media-left" style="float: left;margin-left: 3%;">
           <s:if test="user.usericon==null">
             <img src="<%=basePath %>data/user/<s:property value="userid"/>/userinfo/usericon.png" alt="..." style="height: 65px;">
           </s:if>
           <s:else>
             <img src="data:image/png;base64,<s:property value="#user.usericon"/>" alt="..." style="height: 65px;">
           </s:else>
      </a>
      <div class="media-body" style="margin-left:3%;float: left;height: auto;">
        <span style="color: #999;"><h6 class="media-heading"><s:property value="#user.nickname"/></h6></span>
           <span style="max-width:90%;"><h5 style="width: 860px;"><s:property value="comment"/></h5></span>
           <span style="color: #999;"><s:property value="commentdate"/></span>
           
       </div>
       </div>
    </div>  
    </s:iterator>
    
    
    
  <div class="pagination pagination-right">
  <%
  int pageNum=(Integer)request.getAttribute("pageNum");
  int pageNow=(Integer)request.getAttribute("page");
  
  if(pageNum<10){%>
    <ul>
    <% for(int i=1;i<=pageNum;i++){
    if(i==pageNow){%>
      <li class="active"><a><%=i %></a></li>
    <%}else{%>
      <li><a href="file!loadcomment.action?fileid=<s:property value="fileid"/>&cpage=<%=i %>"><%=i %></a></li>
      <%}
      }%>
    </ul>
  <%}else if(pageNum>=10){
       if(pageNow<=5){%>
       <ul>
        <%
          for(int i=1;i<=9;i++){
          if(i==pageNow){%>
             <li class="active"><a><%=i %></a></li>
             <%}else{%>
             <li><a href="file!loadcomment.action?fileid=<s:property value="fileid"/>&cpage=<%=i %>"><%=i %></a></li>
             <%}} %> 
        </ul>
    <%}else if(pageNow>5 && pageNow<pageNum-3){%>
       <ul>
        <%
        for(int i=pageNow-4;i<=pageNow+4;i++){
            if(i==pageNow){%>
             <li class="active"><a><%=i %></a></li>
             <%}else{%>
             <li><a href="file!loadcomment.action?fileid=<s:property value="fileid"/>&cpage=<%=i %>"><%=i %></a></li>
             <%}
           }
           %></ul><%
      }else if(pageNow>=pageNum-3){%>
       <ul>
        <%
        int j=1;
        for(int i=pageNow-4-j;i<=pageNum;i++){
             if(i==pageNow){%>
             <li class="active"><a><%=i %></a></li>
             <%}else{%>
             <li><a href="file!loadcomment.action?fileid=<s:property value="fileid"/>&cpage=<%=i %>"><%=i %></a></li>
             <%}
             j++;
      }%></ul><%
      }
      } %>
    </div>
    
    <div class="highlight" style="height: 205px;margin-top: 20px;">
       <span style="color: #999;"><h4>我要评论...</h4></span>
       <s:if test="#session.user!=null">
          <textarea class="form-control" rows="4" style="resize:none;margin-top: 5px;width: 100%;" data-toggle="tooltip" data-placement="bottom" title="请输入内容！"></textarea>
          <button id="docomment" type="button" class="btn btn-info pull-right" style="margin-top: 10px;"><span class="icon-comment icon-white" style="margin-top: 1px;"></span>&nbsp;评论</button>
       </s:if>
       <s:else>
          <div class="well" style="max-width: 400px; margin: 0 auto 10px;">
              <a href="page!loginpage3.action" target="_blank" style="text-decoration: none;"><button type="button" class="btn btn-large btn-block btn-primary">请登录过后再评论</button></a>
          </div>
       </s:else>
    </div>
    
    </div>
    
    

    
    <script type="text/javascript">
       $(function(){
          $(document).keyup(function(){
             $('textarea').tooltip('destroy');
          });
          $("#docomment").click(function(){
             var fileid="<s:property value="fileid"/>";
             var url="file!newcomment.action";
             var comment=$("textarea").val();
             if(comment.length==0){
                $("textarea").tooltip('show');
             }else{
                $.post(url,
                       {'fileid':fileid,
                        'comment':comment
                       },
                       function(data){
                          if($(data).find('msg').text()=='success'){
                              $.layer({
                                 type:0,
                                 shadeClose:true,
                                 shade: [0],
                                 fix: true,
                                 dialog: {
                                 type: -1,
                                 msg: '评论成功！'
                                 },
                                 end:function(){
                                     location.reload();
                                 }
                              });
                          }
                       }
                );
             }
          });
       });
    </script>
    
  </body>
</html>
