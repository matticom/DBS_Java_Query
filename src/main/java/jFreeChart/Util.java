package jFreeChart;

public class Util {
	
	public static String conventMonth(String MM_DD) {
		String month = null;
		switch (MM_DD.substring(1, 2)) {
		case "3":
			month = "März";
			break;
		case "4":
			month = "April";
			break;
		case "5":
			month = "Mai";
			break;
		}
		String day = MM_DD.substring(3, 5);
		return day + ". " + month;
	}
	
	public static String conventHour(String MM_DD) {
		String month = null;
		switch (MM_DD.substring(1, 2)) {
		case "3":
			month = "März";
			break;
		case "4":
			month = "April";
			break;
		case "5":
			month = "Mai";
			break;
		}
		String day = MM_DD.substring(3, 5);
		return day + ". " + month;
	}
}
