import java.util.Scanner;

public class Main_BOJ_11399_ATM {

	static int N, time, answer=Integer.MAX_VALUE;
	static int[] people;
	static int[] atm;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		people = new int[N];
		atm = new int[N];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			people[i]=scann.nextInt();
		}
		nPn(0);
		System.out.println(answer);
	}
	
	private static void nPn(int cnt) {
		if(cnt==N) {
			time = 0;
			for (int i = 0; i < N; i++) {
				time += (N-i)*people[atm[i]];
			}
			answer = Math.min(answer, time);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			atm[cnt] = i;
			nPn(cnt+1);
			isSelected[i] = false;
		}
	}

}
