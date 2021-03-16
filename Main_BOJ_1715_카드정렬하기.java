import java.util.Scanner;

// 시간초과 
public class Main_BOJ_1715_카드정렬하기 {

	static int N, answer=Integer.MAX_VALUE;
	static int[] card;
	static int[] ordered;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		card = new int[N];
		ordered = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			card[i] = scann.nextInt();
		}
		nPn(0);
		System.out.println(answer);
	}
	
	private static void nPn(int count) {
		if(count==N) {
			int a=ordered[0];
			int total=0;
			for (int i = 1; i < N; i++) {
				a += ordered[i];
				total += a;
			}
			answer=Math.min(answer, total);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			ordered[count] = card[i];
			nPn(count+1);
			visited[i] = false;
		}
	}

}
