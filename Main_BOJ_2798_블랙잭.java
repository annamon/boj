import java.util.Scanner;

public class Main_BOJ_2798_블랙잭 {
	
	static int N, max, result;
	static int[] card;
	static int[] blackjack = new int[3];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		max = scann.nextInt();
		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = scann.nextInt();
		}
		nCr(0,0);
		System.out.println(result);
	}
	
	private static void nCr(int cnt, int start) {
		if(cnt==3) {
			int sum= blackjack[0]+blackjack[1]+blackjack[2];
			if(sum<=max) {
				result=Math.max(result, sum);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			blackjack[cnt] = card[i];
			nCr(cnt+1, i+1);
		}
	}

}
