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
    <div class="userinfotable" style="height: 435px;">
						<table class="table table-hover" id="table">
							<thead>
								<tr style="color: #666;">
									<th style="text-align: left;">课件名称</th>
									<th>上传者</th>
									<th>下载时间</th>
									<th>扣除积分</th>
								</tr>
							</thead>
							<tbody>
							  <s:iterator value="filedownlist" status="st">
							    <s:set name="file" value="fileService.getfileById(fileid)"></s:set>
								<tr>
									<td style="width: 300px; text-align: left;"><a href="<%=basePath%>file!preview.action?fileid=<s:property value="fileid"/>" target="_blank" title="<s:property value="#file.title"/>">
									<s:if test="#file.title.length()>17">
                                        <s:property value="#file.title.substring(0,17)"/>......
                                    </s:if>
                                    <s:else>
                                    <s:property value="#file.title"/>
                                    </s:else></a></td>
									<td><s:property value="userService.findUserById(#file.userid).getNickname()"/></td>
									<td><s:property value="downloadtime"/></td>
									<td><s:property value="#file.fileprice"/></td>
									
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
      <li><a href="main!userdownfilelist.action?downlogpage=<%=i %>"><%=i %></a></li>
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
             <li><a href="main!userdownfilelist.action?downlogpage=<%=i %>"><%=i %></a></li>
             <%}} %> 
        </ul>
    <%}else if(pageNow>5 && pageNow<pageNum-3){%>
       <ul>
        <%
        for(int i=pageNow-4;i<=pageNow+4;i++){
            if(i==pageNow){%>
             <li class="active"><a><%=i %></a></li>
             <%}else{%>
             <li><a href="main!userdownfilelist.action?downlogpage=<%=i %>"><%=i %></a></li>
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
             <li><a href="main!userdownfilelist.action?downlogpage=<%=i %>"><%=i %></a></li>
             <%}
             j++;
      }%></ul><%
      }
      } %>
    </div>
  </body>
</html>
