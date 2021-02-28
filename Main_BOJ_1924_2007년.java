import java.util.Scanner;
// 브론즈1
public class Main_BOJ_1924_2007년 {

	static int Month, Day;
	static int totalDay;
	static int[] MonthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static String[] WeekDay = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		Month = scann.nextInt();
		Day = scann.nextInt();
		for (int i = 0; i < Month-1; i++) {
			totalDay += MonthDay[i];
		}
		totalDay+=Day;
		System.out.println(WeekDay[totalDay%7]);
	}

}
