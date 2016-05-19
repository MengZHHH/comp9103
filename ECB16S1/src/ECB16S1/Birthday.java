package ECB16S1;

import java.util.Date;

public class Birthday {
	
private String birthday;
	
	public Birthday(String birthday){
		this.birthday = birthday;

	}
	
	public boolean checkBirthday(){
		//do some regex
		if (!birthday.matches("\\d{1,2}-\\d{1,2}-\\d{4}")){
		return false;}
		return true;
	}
	public Date date(){
		int day,month,year;
		String[] datearr = birthday.split("-");
		day = Integer.parseInt(datearr[0]);
		month=Integer.parseInt(datearr[1]);
		year=Integer.parseInt(datearr[2]);
		Date date = new Date(year,month,day);
		return date;
	}
	
	public String toString(){
		String birthdaycat = "birthday "+this.birthday;
		return birthdaycat;
	}
	


}
