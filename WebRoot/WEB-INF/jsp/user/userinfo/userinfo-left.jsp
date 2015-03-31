<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


	<div id="userinfo1">
		<a href="page!userinfo.action">
		<s:if test="#session.user.usericon==null">
		    <img src="<%=basePath%>data/user/default.png" class="img-circle" width="70%" id="usericon" />
		</s:if>
		<s:else>
		    <img src="data:image/png;base64,<s:property value="#session.user.usericon"/>" class="img-circle" width="70%" id="usericon" />
		</s:else>
		
		</a>
	</div>
	<div id="userinfo2">
		<p>
			用户名：
			<a href="<%=basePath%>page!userinfo.action"><s:property value="#session.user.nickname" /></a>
		<p>
			财富值：
			<a href="<%=basePath%>page!usercredit.action"><s:property value="#session.user.credit" /></a>
	</div>
