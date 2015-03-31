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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <link rel="stylesheet" href="css/buttons.css">

    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    
    <style type="text/css">
      li {
	   color: #999 !important;
       font-size: 12px;
       line-height: 19px;
     }
     a{
     color: #333333;
     }
    </style>

  </head>
  
  <body style="padding: 0">
    <s:set name="userfile" value="fileService.getfileByUser(#session.user.userid)"></s:set>
    <a href="page!userpage.action" target="_blank"><s:if test="#session.user.usericon==null">
       <img src="<%=basePath %>data/user/default.png" class="img-polaroid" style="height: 90px;margin-left: 3%;margin-top: 10px;float: left;">
    </s:if>
    <s:else>
       <img src="data:image/png;base64,<s:property value="#session.user.usericon"/>" class="img-polaroid" style="height: 90px;margin-left: 3%;margin-top: 10px;float: left;">
    </s:else></a>
    <div style="margin-top: 10px;float: left;margin-left: 4%;font-size: 12px;line-height: 28px;">
        <p style=" font-size: 17px;"><a href="page!userpage.action" title="<s:property value="#session.user.nickname"/>" target="_blank"><s:if test="#session.user.nickname.length()>6"><s:property value="#session.user.nickname.substring(0,6)"/>...</s:if><s:else><s:property value="#session.user.nickname"/></s:else></a><a href="<%=basePath %>user!logout.action" title="注销用户"><i class="icon-off" style="margin-left: 15px;margin-top: 2px;"></i></a>
        <p><a href="page!userfile.action" target="_blank">我的文档：<s:property value="#userfile.size()"/></a>
        <p><a href="page!usercredit.action" target="_blank">我的金币：<s:property value="#session.user.credit"/></a>
    </div>
    <div style="float: left;border-top: 1px dotted #DDD;margin-left: 3%;width: 90%;">
       <a href="<%=basePath%>page!userfile.action">最近文档：</a>
       <ul>
       <s:if test="#userfile.size()==0">
          <br/>
          <a href="page!uploadpage.action" target="_blank"><span style="font-size:12px;">还未上传过文档，赶紧上传吧！</span></a>
       </s:if>
       <s:if test="#userfile.size()>=3">
         <s:subset source="#userfile" start="0" count="4">
          <s:iterator>
             <a href="<%=basePath%>file!preview.action?fileid=<s:property value="fileid"/>" target="_blank" title="<s:property value="title"/>">
             <li><s:if test="title.length()>15">
                    <s:property value="title.substring(0,15)"/>......
                 </s:if>
                 <s:else>
                    <s:property value="title"/>
                 </s:else>
             </li></a>
          </s:iterator>
          <li class="pull-right"><a href="<%=basePath%>page!userfile.action" target="_blanke">更多>></a></li>
         </s:subset>
       </s:if>
       <s:else>
         <s:iterator value="#userfile">
           <a href="<%=basePath%>file!preview.action?fileid=<s:property value="fileid"/>" target="_blank" title="<s:property value="title"/>">
           <li><s:if test="title.length()>15">
                  <s:property value="title.substring(0,15)"/>......
               </s:if>
               <s:else>
                  <s:property value="title"/>
               </s:else>
           </li></a> 
         </s:iterator>
       </s:else>
       
       </ul>
    </div>
  </body>
</html>
