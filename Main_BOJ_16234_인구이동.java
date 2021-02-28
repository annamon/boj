import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_16234_인구이동 {

	static int N, L, R;
	static int[][] world;
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	static boolean[][] open;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		L = scann.nextInt();
		R = scann.nextInt();
		world = new int[N][N];
		open = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				world[i][j] = scann.nextInt();
			}
		}
		population();
		
	}

	private static void population() {	
		ArrayList<Integer> changeList = new ArrayList<>();
		int count = 0;
		int totalP = 0;
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				for (int d = 0; d < d; d++) {
					int a = world[i*2][j*2];
					int b = world[i*2+dr[d]][j*2+dc[d]];
					if(Math.abs(a-b)>=L && Math.abs(a-b)<=R) {
						changeList.add(i*2, j*2);
						changeList.add(i*2+dr[d], j*2+dc[d]);
						totalP+=a;
						totalP+=b;
						count+=2;
					}
				}
			}
		}
		if(N%2==1) {
			for (int i = 0; i < N/2; i++) {
				int a = world[i*2][N-1];
				int b = world[i*2+1][N-1];
				if(Math.abs(a-b)>=L && Math.abs(a-b)<=R) {
					changeList.add(i*2, N-1);
					changeList.add(i*2+1, N-1);
					totalP+=a;
					totalP+=b;
					count+=2;
				}
			}
		}
		int move = totalP/count;
		
	}

}
