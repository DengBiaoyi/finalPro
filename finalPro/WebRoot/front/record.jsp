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
	response.sendRedirect(request.getContextPath()+"/front/login.html");
}
int temp;
String a = request.getParameter("index");
if(a==null||a.length()<0){
temp=1;}else{
temp = Integer.parseInt(a);
}
int pageCount = 10;
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	function showDialog(){
		if(confirm("确认退出么？")){window.location.href="http://localhost:8080/finalPro/logout"; };
	}
	 function jump(){
	 	var myselect=document.getElementById("select");
	 	
	 	window.location.href="http://localhost:8080/finalPro/front/record.jsp?index="+(myselect.selectedIndex+1);
	 }
</script>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<link rel="stylesheet" type="text/css" href="<%=path %>/style/public.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/style/record.css" />
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
				<div class="login">
				<a><%=name %></a>&nbsp;
				<a onclick="showDialog()" >注销</a>
			</div>
			</div>
		</div>
	</div>
	<div style="margin-top:55px;"></div>
	<div id="record" class="auto">
		<div id="pager">
			<a href="http://localhost:8080/finalPro/front/record.jsp?index=1">首页</a>
			<%if(temp!=1){ %>
			<a href="http://localhost:8080/finalPro/front/record.jsp?index=<%=temp-1 %>">上一页</a>
			<%} %>
			当  前  第  <select id="select" onchange="jump()"><% 
			for(int i=1;i<=pageCount;i++){
				if(i==temp){
				%><option  value="<%=i %>" selected="selected"><%=i %></option><%}
				else{%>
				<option value="<%=i %>" ><%=i %></option>	
				<%}
			}
			%></select> 页  共  <%=pageCount %>   页
			<%if(temp!=pageCount){ %>
			<a href="http://localhost:8080/finalPro/front/record.jsp?index=<%=temp+1 %>">下一页</a>
			<%} %>
			<a href="http://localhost:8080/finalPro/front/record.jsp?index=<%=pageCount %>">末页</a>
		</div>
		<table border="0" style="table-layout:fixed" cellspacing="20">
			<thead>
				<tr>
					<td width="50px">编号</td>
					<td width="50px">姓名</td>
					<td width="50px">部门</td>
					<td width="50px">职位</td>
					<td width="50px">请假时间</td>
					<td width="80px">请假天数</td>
					<td width="80px">请假类型</td>
					<td width="150px">请假原因</td>
					<td width="80px">审核状况</td>
					<td width="150px">驳回原因</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>小小</td>
					<td>开发部</td>
					<td>程序员</td>
					<td>2016-12-1</td>
					<td>10</td>
					<td>病假</td>
					<td>撒的发货粗晚饭后怒我欺负湖时代科技覅我</td>
					<td>未审核</td>
					<td>啊说的就是早点回家的价值发生</td>
				</tr>
				<tr>
					<td>1</td>
					<td>小小</td>
					<td>开发部</td>
					<td>程序员</td>
					<td>2016-12-1</td>
					<td>10</td>
					<td>病假</td>
					<td>撒的发货粗晚饭后怒我欺负湖时代科技覅我</td>
					<td>未审核</td>
					<td>无</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="footer" class="auto">
<div class="bottom">
<a>请假系统</a>
</div>
<div class="copyright">Powered by DengBiaoyi @2016</div>
</div>
</body>
</html>
