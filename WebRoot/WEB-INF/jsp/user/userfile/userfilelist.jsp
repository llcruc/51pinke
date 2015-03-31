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
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<link rel="stylesheet" href="css/buttons.css">

<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
  </head>
  
  <body>
    <div class="userinfotable" style="height: 224px;">
						<table class="table table-hover">
							<thead>
								<tr style="color: #666;">
									<th style="text-align: left;">课件名称</th>
									<th>课件状态</th>
									<th>浏览次数</th>
									<th>下载次数</th>
									<th>上传时间</th>
								</tr>
							</thead>
							<tbody>
							  <s:iterator value="fileList">
								<tr>
									<td style="width: 370px; text-align: left;"><a href="<%=basePath%>file!preview.action?fileid=<s:property value="fileid"/>" target="_blank" title="<s:property value="title"/>">
									<s:if test="title.length()>20">
                                        <s:property value="title.substring(0,20)"/>......
                                    </s:if>
                                    <s:else>
                                    <s:property value="title"/>
                                    </s:else></a></td>
									<td><s:if test="ispublic==0">公开</s:if><s:else>私有</s:else></td>
									<td><s:property value="browsetimes"/></td>
									<td><s:property value="downloadtimes"/></td>
									<td><s:property value="uploadtime.substring(0,10)"/></td>
								</tr>
							  </s:iterator>
							</tbody>
						</table>
					</div>
					
                  <div class="pagination pagination-right">
  <%
  int pageNum=(Integer)request.getAttribute("pageNum1");
  int pageNow=(Integer)request.getAttribute("page");
  if(pageNum<10){%>
    <ul>
    <% for(int i=1;i<=pageNum;i++){
    if(i==pageNow){%>
      <li class="active"><a><%=i %></a></li>
    <%}else{%>
      <li><a href="main!userfilelist.action?userid=<s:property value="userid"/>&filepageNow=<%=i %>"><%=i %></a></li>
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
             <li><a href="main!userfilelist.action?userid=<s:property value="userid"/>&filepageNow=<%=i %>"><%=i %></a></li>
             <%}} %> 
        </ul>
    <%}else if(pageNow>5 && pageNow<pageNum-3){%>
       <ul>
        <%
        for(int i=pageNow-4;i<=pageNow+4;i++){
            if(i==pageNow){%>
             <li class="active"><a><%=i %></a></li>
             <%}else{%>
             <li><a href="main!userfilelist.action?userid=<s:property value="userid"/>&filepageNow=<%=i %>"><%=i %></a></li>
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
             <li><a href="main!userfilelist.action?userid=<s:property value="userid"/>&filepageNow=<%=i %>"><%=i %></a></li>
             <%}
             j++;
      }%></ul><%
      }
      } %>
    </div>
  </body>
</html>
