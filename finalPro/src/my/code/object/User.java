package my.code.object;

public class User {

	private int id = -1;
	private UserInfo info = null;
	private String type = null;
	private int dayLeft = 0;
	private String password = null;
	private User(){}
	public User(UserInfo userIndo, String password){
		this.info = userIndo;
		this.password =password;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	
	public UserInfo getUserInfo(){
		return info;
	}
	public void setTyp(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	public int getDayLeft(){
		return dayLeft;
	}
	public void setDayLeft(int dayLeft){
		this.dayLeft = dayLeft;
	}
	public String getPassword(){
		return this.password;
	}
}
