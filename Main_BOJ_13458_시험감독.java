import java.util.Scanner;

public class Main_BOJ_13458_시험감독 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		int[] test = new int[N];
		for (int i = 0; i < N; i++) {
			test[i] = scann.nextInt();
		}
		int B = scann.nextInt();
		int C = scann.nextInt();
		long count = 0;
		for (int i = 0; i < N; i++) {
			if(test[i]<=B) count++;
			else {
				count+= (test[i]-B)/C +1;				
				if((test[i]-B)%C!=0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
