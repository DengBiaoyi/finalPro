<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="style/public.css" />
<link rel="stylesheet" type="text/css" href="style/login.css" />
</head>
<body>
	<div class="header_wrap">
		<div id="header" class="auto">
			<div class="logo">请假系统</div>
			<div class="serarch">
				<form>
					<input class="keyword" type="text" name="keyword" placeholder="搜索其实很简单" />
					<input class="submit" type="submit" name="submit" value="" />
				</form>
			</div>
			<div class="login">
				<a>登录</a>&nbsp;
				<a>注册</a>
			</div>
		</div>
	</div>
	<div style="margin-top:55px;"></div>
	<div id="login" class="auto">
		<h2>欢迎进入请假系统</h2>
		<form method="post" action = "http://localhost:8080/finalPro/login">
			<div>
				<label>用户名: <input type="text" name ="name"  /></label>
				<label>密码: <input type="password" name="password" /></label>
				<input class="btn" type="submit" name="submit" value=" 登录  " />
			</div>
		</form>
	</div>
	<div id="footer" class="auto">
		<div class="bottom">
			<a>请假系统</a>
		</div>
		<div class="copyright">Powered by DengBiaoyi @2016</div>
	</div>
</body>
</html>
