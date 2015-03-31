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
  </head>
  
  <body>
    <p align="center" style="margin-top:15px; "><a href="<%=basePath %>page!uploadpage.action" target="_blank" class="button button-rounded button-flat-highlight button-large" style="width: 70%;"><i class="icon-upload icon-white" style="margin-top: 2px;margin-right: 2px;"></i>上传我的文档</a>
    <p align="center"><span>一共收藏了<span style="color: red;font-size:16px;font-weight:600;"><s:property value="filetotalnum"/></span>份课件</span>
  </body>
</html>
