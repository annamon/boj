import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 시간초과
public class Main_BOJ_1377_버블소트 {

	static int N;
	static boolean change;
	static int[] a;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		a = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			a[i] = scann.nextInt();
		}
		for (int i = N; i > 1; i--) {
			for (int j = 1; j <= N-i ; j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			if (!change) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
