<%@page import="my.code.implDao.FindRecordIsDo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="my.code.implDao.FindRecordImpl"%>
<%@page import="my.code.implDao.MysqlImpl"%>
<%@page import="my.code.implDao.GetUserInfoImpl"%>
<%@page import="my.code.object.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
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
int temp;
String a = request.getParameter("index");
if(a==null||a.length()<0){
temp=1;}else{
temp = Integer.parseInt(a);
}
MysqlImpl mysql = MysqlImpl.getInstance();
String searchName = (String)request.getParameter("searchName");
String searchDepartment = (String)request.getParameter("searchDepartment");
boolean isName = false;
boolean isDepartment = false;
if(searchName!=null&&searchName.length()>0){isName=true;}
if(searchDepartment!=null&&searchDepartment.length()>0){isDepartment=true;}
mysql.connect();
FindRecordIsDo find = new FindRecordIsDo();
ResultSet resultSet;
if(isName||isDepartment){
	if(isName&&isDepartment){
	resultSet=find.findRecordByNameAndDepartment(mysql, searchName, searchDepartment);
	}else if(isName){
	resultSet = find.findRecordByName(mysql, searchName);
	}else{
	resultSet = find.findRecordByDepartment(mysql, searchDepartment);
	}
}else{
	resultSet = find.findAll(mysql);
}
resultSet.last();
int pageNum = 6;

int recordCount = resultSet.getRow();
int pageCount = recordCount/pageNum;
if(recordCount%pageNum!=0) pageCount++;
if(pageCount==0)pageCount=1;
if(temp>pageCount) temp=pageCount;
if(isName||isDepartment){
	if(isName&&isDepartment){
	resultSet=find.findRecordByNameAndDepartmentStartX(mysql, searchName, searchDepartment,(temp-1)*pageNum,pageNum);
	}else if(isName){
	resultSet = find.findRecordByNameStartX(mysql, searchName,(temp-1)*pageNum,pageNum);
	}else{
	resultSet = find.findRecordByDepartmentStartX(mysql, searchDepartment,(temp-1)*pageNum,pageNum);
	}
}else{
	resultSet = find.findAllStartX(mysql,(temp-1)*pageNum,pageNum);
}
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	function showDialog(){
		if(confirm("确认退出么？")){window.location.href="http://localhost:8080/finalPro/logout"; };
	}
	 function jump(){
	 	var myselect=document.getElementById("select");
	 	
	 	jumpOnForm(myselect.selectedIndex+1);
	 }
	 function jumpOnForm(index){
	 	var sfForm = document.getElementById("hidenForm"); 
      	sfForm.method = "post"; 
	    sfForm.action = "admin/isDo.jsp?index="+index; 
	    sfForm.submit(); 
	 }
     function createInput(sfForm,type,name,value) 
     { 
      var tmpInput = document.createElement("input"); 
      tmpInput.type = type; 
      tmpInput.name = name; 
      tmpInput.value = value; 
      sfForm.appendChild(tmpInput); 
     }
</script>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="<%=path %>/style/public.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/style/isDo.css" />
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
	<div id = "menu" class="auto" >
		<ul>
			<li><a id="headA-1" href="admin/allRecord.jsp">全部记录</a></li>
			<li><a id="headA-2" href="admin/isDo.jsp">未审核</a></li>
			<li><a id="headA-3" href="admin/hasDo.jsp">已审核</a></li>
		</ul>
	</div>
	<%if(searchName==null)searchName="";
	if(searchDepartment==null)searchDepartment=""; %>
	<div id="search" class="auto">
		<form method="post" action="admin/allRecord.jsp">
			<label>用户名：<input type="text" name="searchName" value=<%=searchName %> ></label>
			<label>部门：<input type="text" name="searchDepartment" value=<%=searchDepartment %> ></label>
			<input type="submit" value="搜索" id="searchButton" onClick="" />
			
		</form>
	</div>
	<div id="allRecord" class="auto">
		<div id="pager">
			<a onclick="jumpOnForm(1)">首页</a>
			<%if(temp!=1){ %>
			<a onclick="jumpOnForm(<%=temp-1 %>)">上一页</a>
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
			<a onclick="jumpOnForm(<%=temp+1 %>)">下一页</a>
			<%} %>
			<a onclick="jumpOnForm(<%=pageCount %>)">末页</a>
		</div>
		<table border="0" style="table-layout:fixed" cellspacing="10">
			<thead>
				<tr height = "31px">
					<td width="50px">编号</td>
					<td width="50px">姓名</td>
					<td width="50px">部门</td>
					<td width="50px">职位</td>
					<td width="80px">请假时间</td>
					<td width="80px">请假天数</td>
					<td width="80px">请假类型</td>
					<td width="150px">请假原因</td>
					<td width="80px">审核状况</td>
					<td width="150px">驳回原因</td>
					<td width="80px" >操作</td>
				</tr>
			</thead>
			<tbody>
				
			<%
			int i=(temp-1)*pageNum;
			while(resultSet.next()){ %>
				<tr >
					<td><%=++i %></td>
					<td><%=resultSet.getString(2) %></td>
					<td><%=resultSet.getString(3) %></td>
					<td><%=resultSet.getString(4) %></td>
					<td><%=resultSet.getString(5) %></td>
					<td><%=resultSet.getString(6) %></td>
					<td><%=resultSet.getString(7) %></td>
					<td><%=resultSet.getString(8) %></td>
					<td><%=resultSet.getString(9) %></td>
					<td><%=resultSet.getString(10) %></td>
					<td>
						<input type="button"  value="通过"/>
						<input type="button" value="驳回"/>
					</td>			
				</tr>
			<%} %>
			</tbody>
		</table>
	</div>
	<form style="visibility:hidden" id="hidenForm">
		<input name="searchName" value=<%=searchName %>>
		<input name="searchDepartment" value=<%=searchDepartment %>>
	</form>
	<div id="footer" class="auto">
<div class="bottom">
<a>请假系统</a>
</div>
<div class="copyright">Powered by DengBiaoyi @2016</div>
</div>
</body>
</html>
