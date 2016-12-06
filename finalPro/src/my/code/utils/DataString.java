package my.code.utils;

public class DataString {
	private String string;
	public DataString(){
		string="";
	}
	public DataString(String year,String month,String day){
		string=year+"-"+month+"-"+day;
	}
	public String getString(){
		return this.string;
	}
}
