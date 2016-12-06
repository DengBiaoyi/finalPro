<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String target = (String)request.getAttribute("target");
String pic = (String)request.getAttribute("pic");
String info =(String)request.getAttribute("info");
%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta http-equiv="refresh" content="3;URL=<%=target %>" />
		<title>正在跳转...</title>
		<link rel="stylesheet" type="text/css" href="<%=path %>/style/remind.css" />
	</head>
	<body>
		<div class="notice"><span class="pic <%=pic %>"></span>  <%=info %>  <a href="{$url}">3秒后自动跳转。。。</a></div>
	</body>
</html>