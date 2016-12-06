<%@page import="my.code.utils.DateTool"%>
<%@page import="my.code.implDao.GetUserInfoImpl"%>
<%@page import="my.code.object.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String name ="";
name = (String)session.getAttribute("name");
if(name==null)name="";
if(name.equals("")){
	response.sendRedirect(request.getContextPath()+"/front/login.html");
}
GetUserInfoImpl info = new GetUserInfoImpl();
UserInfo user = info.getUserInfo(name);
if(user==null){
	user=new UserInfo("","","");
}
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="<%=path %>/style/public.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/style/changePwd.css" />
<script type="text/javascript">
	function showDialog(){
	if(confirm("确认退出么？")){window.location.href="http://localhost:8080/finalPro/logout"; };
	}
</script>
</head>
<body>
	<div class="header_wrap">
		<div id="header" class="auto">
			<div class="logo">请假系统 </div>
			<div class="serarch">
				<form>
					<input class="keyword" type="text" name="keyword" placeholder="搜索其实很简单" />
					<input class="submit" type="submit" name="submit" value="" />
				</form>
			</div>
			<div class="login">
				<a><%=name %></a>&nbsp;
				<a onclick="showDialog()" >注销</a>
			</div>
		</div>
	</div>
	<div style="margin-top:55px;"></div>
	<div id = "menu" class="auto" >
		<ul>
			<li><a id="headA-1" href="front/record.jsp">请假记录</a></li>
			<li><a id="headA-2" href="front/leave.jsp">我要请假</a></li>
			<li><a id="headA-3" href="front/changePwd.jsp">密码修改</a></li>
		</ul>
	</div>
	<div id = "changePwd" class="auto">
		<h2>请填写相关信息：</h2>
		<div style="margin-top:30px;"></div>
		<form method="post" action="http://localhost:8080/finalPro/changePwd">
			<label name="label1"> 姓 名：<input readonly="readonly" value="<%=user.getName() %>" class="type1" type="text" name="name"/></label><br/>
			<label name="label2"> 部 门：<input readonly="readonly" value="<%=user.getDepartment() %>" class="type1" type="text" name="department"/></label><br/>
			<label name="label3"> 职 位：<input readonly="readonly" value="<%=user.getJob() %>" class="type1" type="text" name="job"/></label><br/>
			<label name="label3">请输入旧密码：<input class="type1" type="text" name="job" readonly="readonly" /></label><br/>
			<label name="label3">请输入新密码：<input class="type1" type="text" name="job" readonly="readonly" /></label><br/>
			<label name="label3">&nbsp&nbsp&nbsp请确认密码：<input class="type1" type="text" name="job" readonly="readonly" /></label><br/>
			<input id="btn" type="submit" value="提交申请" name="submit"/>
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