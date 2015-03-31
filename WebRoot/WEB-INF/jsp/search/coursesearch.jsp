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
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 响应式 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css">
    <link rel="stylesheet" type="text/css" href="css/mystyle.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.raty.css">
    <link rel="stylesheet" href="css/buttons.css">

    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/jquery.raty.js"></script>
    
    <style type="text/css">
       p{
         text-align: left;
       }
    </style>
    

  </head>
  
  <body>
    <h5 style="color: #CCC;">一共为您找到&nbsp;<span style="color:#993333"><s:property value="num"/></span>&nbsp;条结果</h5>
    <table class="table table-hover" id="resulttable">
      <s:iterator value="rucCourseslist" status="index">
        <tr>
          <td  style="text-align: left;">
            <div class="span12">
               <div class="span3">
                  <s:if test="courseimg==null">
                     <a href="<%=basePath%>course!info2.action?courseid=<s:property value="coursetimeid"/>&cid=<s:property value="cid"/>" target="_blank">
                       <img class="course_img" src="<%=basePath%>data/course/default.jpg"/>
                     </a>
                  </s:if>
                  <s:else>
                     <a href="<%=basePath%>course!info2.action?courseid=<s:property value="coursetimeid"/>&cid=<s:property value="cid"/>" target="_blank">
				       <img class="course_img" src="<%=basePath%>data/course/images/<s:property value="coursetimeid"/>.jpg"/>
				     </a>
                  </s:else>
               </div>
               <div class="span8">
                  <div class="course_title">
				      <a href="<%=basePath%>course!info2.action?courseid=<s:property value="coursetimeid"/>&cid=<s:property value="cid"/>" target="_blank"><s:property value="coursename"/></a>
				  </div>
				  <div class="course_maininfo">
				      <s:property value="courseinfo"/>
				  </div>
				  <div class="course_teacher">
				      课节信息：<s:property value="coursetime"/>
				  </div>
				  <div class="course_teacher">
				      任课教师：<a class="button button-rounded button-flat-highlight teacher_button"><s:property value="rucTeacherService.getTeacherById(teacher).getTeachername()"/></a>
				  </div>
               </div>
            </div>
          </td>
        </tr>
      </s:iterator>
    </table>
    <hr/>
     <div class="pagination">
  <%
  int pageNum=(Integer)request.getAttribute("pageNum");
  int pageNow=(Integer)request.getAttribute("page");
  
  if(pageNum<10){%>
    <ul>
    <% for(int i=1;i<=pageNum;i++){
    if(i==pageNow){%>
      <li class="active"><a><%=i %></a></li>
    <%}else{%>
      <li><a href="search!searchcourse.action?word=<s:property value="word" escape="false"/>&page=<%=i %>"><%=i %></a></li>
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
             <li><a href="search!searchcourse.action?word=<s:property value="word" escape="false"/>&page=<%=i %>"><%=i %></a></li>
             <%}} %> 
        </ul>
    <%}else if(pageNow>5 && pageNow<pageNum-3){%>
       <ul>
        <%
        for(int i=pageNow-4;i<=pageNow+4;i++){
            if(i==pageNow){%>
             <li class="active"><a><%=i %></a></li>
             <%}else{%>
             <li><a href="search!searchcourse.action?word=<s:property value="word" escape="false"/>&page=<%=i %>"><%=i %></a></li>
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
             <li><a href="search!searchcourse.action?word=<s:property value="word" escape="false"/>&page=<%=i %>"><%=i %></a></li>
             <%}
             j++;
      }%></ul><%
      }
      } %>
    </div>

    <br/>
    <br/>
  </body>
</html>
