import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_11399_ATM2 {

	static int N, answer;
	static int[] people;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		people = new int[N];
		for (int i = 0; i < N; i++) {
			people[i]=scann.nextInt();
		}
		Arrays.sort(people);
		for (int i = 0; i < N; i++) {
			answer+=people[i]*(N-i);
		}
		System.out.println(answer);
	}
	

}
