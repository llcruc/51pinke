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
									<th>课件状态</th>
									<th>浏览次数</th>
									<th>下载次数</th>
									<th>上传时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							  <s:iterator value="fileList" status="st">
								<tr>
									<td style="width: 300px; text-align: left;"><a href="<%=basePath%>file!preview.action?fileid=<s:property value="fileid"/>" target="_blank" title="<s:property value="title"/>">
									<s:if test="title.length()>17">
                                        <s:property value="title.substring(0,17)"/>......
                                    </s:if>
                                    <s:else>
                                    <s:property value="title"/>
                                    </s:else></a></td>
									<td><s:if test="ispublic==0">公开</s:if><s:else>私有</s:else></td>
									<td><s:property value="browsetimes"/></td>
									<td><s:property value="downloadtimes"/></td>
									<td><s:property value="uploadtime.substring(0,10)"/></td>
									<td><a class="btn btn-warning" id='<s:property value="#st.count"/>' data="<s:property value="fileid"/>" style="margin-top: -5px;padding-top: 1px;" title="删除该课件"><i class="icon-trash icon-white"></i></a>&nbsp;<a class="btn btn-info edite-button" id='e<s:property value="#st.count"/>' data="<s:property value="fileid"/>" target="_blank" style="margin-top: -5px;padding-top: 1px;" title="编辑课件信息"><i class="icon-edit icon-white"></i></a></td>
								</tr>
							  </s:iterator>
							</tbody>
						</table>
					</div>
					
                  <div class="pagination pagination-right">
                  <form name="editefile" action="page!userfileedite.action" method="post" target="_blank">
                    <input type="hidden" id="fileid1" name="fileid" value="">
                  </form>

                  
                  <script type="text/javascript">
                     $(function(){
                       $("#1,#2,#3,#4,#5,#6,#7,#8,#9,#10").click(function(){
                          var fileid=$(this).attr('data');
                          $('#fileid', parent.document).val(fileid);
                          $('#msg', parent.document).modal('show');
                       });
                       $("#e1,#e2,#e3,#e4,#e5,#e6,#e7,#e8,#e9,#e10").click(function(){
                          var fileid1=$(this).attr('data');
                          $("#fileid1").val(fileid1);
                          $("form[name=editefile]").submit();
                       });
                       
                       
                     });
                  </script>
                  
   
  <%
  int pageNum=(Integer)request.getAttribute("pageNum1");
  int pageNow=(Integer)request.getAttribute("page");
  if(pageNum<10){%>
    <ul>
    <% for(int i=1;i<=pageNum;i++){
    if(i==pageNow){%>
      <li class="active"><a><%=i %></a></li>
    <%}else{%>
      <li><a href="main!userfilelist2.action?userid=<s:property value="userid"/>&filepageNow=<%=i %>"><%=i %></a></li>
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
             <li><a href="main!userfilelist2.action?userid=<s:property value="userid"/>&filepageNow=<%=i %>"><%=i %></a></li>
             <%}} %> 
        </ul>
    <%}else if(pageNow>5 && pageNow<pageNum-3){%>
       <ul>
        <%
        for(int i=pageNow-4;i<=pageNow+4;i++){
            if(i==pageNow){%>
             <li class="active"><a><%=i %></a></li>
             <%}else{%>
             <li><a href="main!userfilelist2.action?userid=<s:property value="userid"/>&filepageNow=<%=i %>"><%=i %></a></li>
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
             <li><a href="main!userfilelist2.action?userid=<s:property value="userid"/>&filepageNow=<%=i %>"><%=i %></a></li>
             <%}
             j++;
      }%></ul><%
      }
      } %>
    </div>
  </body>
</html>
