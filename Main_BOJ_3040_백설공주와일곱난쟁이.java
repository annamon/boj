import java.util.Scanner;

public class Main_BOJ_3040_백설공주와일곱난쟁이 {

	static int[] dwarf = new int[9];
	static int[] realDwarf = new int[7];
	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			dwarf[i] = scann.nextInt();
		}
		find(0,0);
	}
	
	private static void find(int cnt, int start) {
		if(cnt == 7) {
			int total = 0;
			for (int i = 0; i < 7; i++) {
				total += realDwarf[i];
			}
			if(total==100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(realDwarf[i]);
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			realDwarf[cnt] = dwarf[i];
			find(cnt+1, i+1);
		}
	}

}
