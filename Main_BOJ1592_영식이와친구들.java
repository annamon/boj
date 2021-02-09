package annabaekjoon;

import java.util.Scanner;

public class Main_BOJ1592_영식이와친구들 {

	static int N, M, L, start, count;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		L = scann.nextInt();
		int[] catchball = new int[N+1];
		start = 0; // 공 잡은 놈
		count = 0; // 몇 번 던졌나
		while(catchball[start]!=M) { // M번 던지면 끝
			if(catchball[start]%2==0) {
				if(L>start) start = N - L + start;
				else start -= L;
				catchball[start]++;
				count++;
			}else {
				start += L;
				if(start >N)
					start -= N;
				catchball[start]++;
				count++;
			}
		}
		System.out.println(count-1);
		

	}

}
