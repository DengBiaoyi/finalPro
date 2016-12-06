package my.code.object;

import javax.print.DocFlavor.STRING;

public class UserInfo {
	private String name;
	private String job;
	private String department;
	private UserInfo(){
		name="";
		job="";
		department="";
	}
	public UserInfo(String name,String job,String department){
		this.name = name;
		this.job = job;
		this.department = department;
	}
	public void setJob(String job){
		this.job = job;
	}
	public void setDepartment(String department){
		this.department = department;
	}
	public String getName(){
		return this.name;
	}
	public String getJob(){
		return this.job;
	}
	public String getDepartment(){
		return this.department;
	}
	public void print(){
		System.out.println("姓 名："+name);
		System.out.println("部 门："+department);
		System.out.println("职 位："+job);
	}
}
