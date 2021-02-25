import java.util.Scanner;

public class Main_BOJ_1592_영식이와친구들 {

	static int N, M, L, now, count;
	static int[] ball;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		L = scann.nextInt();
		ball = new int[N+1];
		ball[now]++;
		while(ball[now]!=M) {
			if(ball[now]%2==0) { // 받은 횟수가 짝수
				now = (now-L+N)%N;
				ball[now]++;
				count++;
			}else { // 홀수
				now = (now+L)%N;
				ball[now]++;
				count++;
			}
		}
		System.out.println(count);
	}

}
