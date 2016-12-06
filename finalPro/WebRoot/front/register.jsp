<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
 function check(form){
 	 if(form.name.value=="") {
	     alert("请输入用户帐号!");
	     form.name.focus();
	     return false;
     }
     if(form.department.value=="") {
	     alert("请输入部门!");
	     form.department.focus();
	     return false;
     }
     if(form.job.value=="") {
	     alert("请输入职位!");
	     form.job.focus();
	     return false;
     }     
     if(form.password.value==""){
	     alert("请输入登录密码!");
	     form.password.focus();
	     return false;
     }
     if(form.password.value.length<6){
	     alert("密码长度不得少于6位!");
	     form.password.focus();
	     return false;
     }
     if(form.password.value.length>15){
	     alert("密码长度不得超过15位!");
	     form.password.focus();
	     return false;
     }
     if(form.check_pwd.value==""){
	     alert("请确认密码!");
	     form.check_pwd.focus();
	     return false;
     }
     if(form.check_pwd.value.length<6){
	     alert("确认密码不得少于6位!");
	     form.check_pwd.focus();
	     return false;
     } 
     if(form.check_pwd.value.length<6){
	     alert("确认密码不得超过15位!");
	     form.check_pwd.focus();
	     return false;
     } 
     if(form.check_pwd.value!=form.password.value){
	     alert("两次密码需保持一致!");
	     form.check_pwd.focus();
	     return false;
     }     
     return true;
 }
</script>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<link rel="stylesheet" type="text/css" href="<%=path %>/style/public.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/style/register.css" />
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
				<a href="http://localhost:8080/finalPro/front/login.html">登录</a>&nbsp;
				<a href="http://localhost:8080/finalPro/front/register.jsp">注册</a>
			</div>
		</div>
	</div>
	<div style="margin-top:55px;"></div>
	<div id="register" class="auto">
		<h2>欢迎注册成为用户</h2>
		<form method="post" action="../register">
			<label>用户名：<input type="text" name="name"  /><span>用户名可以是汉字，但不能超过15个字符</span></label>
			<label>部 门：<input type="text" name="department"  /><span>用户所属部门</span></label>
			<label>职 位：<input type="text" name="job"  /><span>用户名担任职位</span></label>
			<label>密 码：<input type="password" name="password" /><span>密码不能少于6位或大于15位</span></label>
			<label>确认密码：<input type="password" name="check_pwd"  /><span>两次密码输入必须一致</span></label>
			<div style="clear:both;"></div>
			<input class="btn" name="submit" type="submit" value="确定注册" onclick="return check(this.form)"/>
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
