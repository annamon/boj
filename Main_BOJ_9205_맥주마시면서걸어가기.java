import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_9205_맥주마시면서걸어가기 {

	static int T, N;
	static int[][] road;
	static boolean[] visited;
	static boolean canGO;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {			
			N = scann.nextInt();
			road = new int[N+2][2];
			visited = new boolean[N+2];
			canGO = false;
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < 2; j++) {
					road[i][j] = scann.nextInt();
				}
			}
			bfs();
			System.out.println(canGO? "happy" : "sad");
		}
	}
	
	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {road[0][0], road[0][1]});
		while(!que.isEmpty()) {
			int[] now = que.poll();
			if(check(now[0], now[1], road[N+1][0], road[N+1][1])<=1000) {
				canGO = true;
				break;
			}
			for (int i = 1; i < N+1; i++) {
				if(!visited[i] && check(now[0], now[1], road[i][0], road[i][1])<=1000) {
					visited[i] = true;
					que.offer(new int[] {road[i][0], road[i][1]});
				}
			}
		}
	}

	private static int check(int r1, int c1, int r2, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}

	

}
