package genericUtility;


import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int toGetRandomNumber() {

		Random r = new Random();
		int value = r.nextInt(1000);
		return value;
	}

	/**
	 * This method is used to get system date and time in format
	 */
	public String toGetSystemDateAndTime() {

		Date d = new Date();
		String[] date = d.toString().split(" ");
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		String fDate = day + "-" + month + "-" + date1 + "-" + time + "-" + year;
		return fDate;

	}

}
