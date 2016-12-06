package my.code.utils;


public class DateTool {
	public static int day(int year,int month){
		
		switch (month) {
		
			case 1:return 31;
			case 2:
				if(isLeap(year))
					return 29;
				else {
					return 28;
				}
			case 3:return 31;
			case 4:return 30;
			case 5:return 31;
			case 6:return 30;
			case 7:return 31;
			case 8:return 31;
			case 9:return 30;
			case 10:return 31;
			case 11:return 30;
			case 12:return 31;
			
			default:
				break;
		}
		return 0;
	}
	public static boolean isLeap(int year){
		if(year%4==0){
			if(year%100==0){
				if(year%400==0)return true;
				else return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
		
	}
}
