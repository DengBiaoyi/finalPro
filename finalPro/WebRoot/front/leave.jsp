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
<link rel="stylesheet" type="text/css" href="<%=path %>/style/leave.css" />
<script type="text/javascript">
	function showDialog(){
	if(confirm("确认退出么？")){window.location.href="http://localhost:8080/finalPro/logout"; };
	}
	function check(form){
		if(form.leaveDays.value==""){
			alert("请输入请假天数!");
		    form.leaveDays.focus();
	     	return false;
		}
	}
	function selectDay(){
		var myselect=document.getElementById("year");
		var index=myselect.selectedIndex ;
		var year = myselect.options[index].text;
		
		myselect=document.getElementById("month");
		index=myselect.selectedIndex;
		month = myselect.options[index].text;
		
		switch(month){
			case "1":hide0();
				break;		
			case "2":
				if(isLeap(year))
					hide2();
				else {
					hide1();
				}
				break;
			case "3":hide0();
				break;
			case "4": 
				hide3();
				break;
			case "5":hide0();
				break;	
			case "6": hide3();
				break;
			case "7":hide0();
				break;
			case "8":hide0();
				break;
			case "9": hide3();
				break;
			case "10":hide0();
				break;
			case "11": hide3();
				break;
			case "12":hide0();
				break;
		}
		
	}
	function hide0(){
		var option1=document.getElementById("day29");
		var option2=document.getElementById("day30");
		var option3=document.getElementById("day31");
		option1.style.visibility="visible";
		option2.style.visibility="visible";
		option3.style.visibility="visible";
	}
	function hide1(){
		hide0();
		var option1=document.getElementById("day29");
		var option2=document.getElementById("day30");
		var option3=document.getElementById("day31");
		option1.style.visibility="hidden";
		option2.style.visibility="hidden";
		option3.style.visibility="hidden";
	}
	function hide2(){
		hide0();
		var option2=document.getElementById("day30");
		var option3=document.getElementById("day31");
		option2.style.visibility="hidden";
		option3.style.visibility="hidden";
	}
	function hide3(){
		hide0();
		var option3=document.getElementById("day31");
		option3.style.visibility="hidden";
	}
	function isLeap(year){
		if(year%4==0){
			if(year%100==0){
				if(year%400==0){
					return true;
				}else return false;
			}else{
			return true;}
		}else{
		return false;}
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
	<div id = "subLeave" class="auto">
		<h2>请填写相关信息：</h2>
		<div style="margin-top:30px;"></div>
		<form method="post" action="http://localhost:8080/finalPro/leave">
			<label name="label1"> 姓 名：<input readonly="readonly" value="<%=user.getName() %>" class="type1" type="text" name="name"/></label><br/>
			<label name="label2"> 部 门：<input readonly="readonly" value="<%=user.getDepartment() %>" class="type1" type="text" name="department"/></label><br/>
			<label name="label3"> 职 位：<input readonly="readonly" value="<%=user.getJob() %>" class="type1" type="text" name="job"/></label><br/>
			<label>请假起始时间：
				<select id="year" name="year">
					<option value="2016" selected="selected">2016</option>
				<%for(int i=2017;i<2030;i++){ 
					%>
					<option value="<%=i %>"><%=i %></option>
					<%} %>
				</select> 年
				<select id="month" name="month">
					<option value="1" selected="selected">1</option>
				<%for(int i=2;i<13;i++){ %>
					<option value="<%=i %>"><%=i %></option>
					<%} %>
				</select> 月
				<select id="day" name="day" onClick = "selectDay()">
					<option value="1" selected="selected">1</option>
				<%
				for(int i=2;i<=28;i++){
				 %>
					<option value="<%=i %>"><%=i %></option>
					<%
					} %>
					<option value="29" id="day29">29</option>
					<option value="30" id="day30">30</option>
					<option  value="31" id="day31">31</option>
				</select> 日
			</label><br/>
			<label>请假天数(天)：<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="type1" type="text" name="leaveDays"/></label><br/>
			<label>请假类型：<br/>
				<label><input type="radio" name="type" value="年休假"/> 年休假</label>
				<label><input type="radio" name="type" value="病 假"/> 病 假</label>
				<label><input type="radio" name="type" value="婚 假"/> 婚 假</label>
				<label><input type="radio" name="type" value="产 假"/> 产 假</label><br/>
				<label><input type="radio" name="type" value="陪产假"/> 陪产假</label>
				<label><input type="radio" name="type" value="事 假"/> 事 假</label>
				<label><input type="radio" name="type" value="调 休"/> 调 休</label>
				<label><input type="radio" name="type" value="丧 假"/> 丧 假</label><br/>
				<label><input type="radio" name="type" value="探亲家"/> 探亲家</label>
				<label><input type="radio" name="type" value="其他" checked="checked"/> 其他</label>
			</label><br/>
			<label>请假原因：<br/>
				<textarea id="label4" name="reason" cols="50" rows="4"></textarea>
			</label>
			<input id="btn" type="submit" value="提交申请" name="submit" onclick="return check(this.form)"/>
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