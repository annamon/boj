import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_7576_토마토 {

	static int M, N, unripe;
	static int[][] box;
	static Queue<int[]> tomato = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		M = scann.nextInt();
		N = scann.nextInt();
		box = new int[N][M];
		boolean ripe = true; // 토마토가 다 익었는지 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = scann.nextInt();
				if(box[i][j]==0) {
					ripe = false;
					unripe++; // 안 익은 토마토 개수 세기
				}
				else if(box[i][j]==1) {					
					tomato.offer(new int[] {i,j,0}); // 익은 토마토 위치, 날짜 넣기
				}
			}
		}
		if(ripe) System.out.println(0); // 토마토가 다 익어있으면 0 출력
		else {
			findtomato();
		}
	}
	
	private static void findtomato() {
		while(!tomato.isEmpty()) {
			int r = tomato.peek()[0];
			int c = tomato.peek()[1];
			int day = tomato.poll()[2];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr<0 || nr>=N || nc<0 || nc>=M || box[nr][nc]==-1) continue; // 범위, 토마토 유무 체크
				if(box[nr][nc]==0) { // 근처 토마토가 안 익어 있으면
					box[nr][nc] = 1; // 익히자
					unripe--; // 안 익은 놈 개수 줄이자
					tomato.offer(new int[] {nr, nc, day+1}); // 익은 토마토 목록에 넣어주기
				}
			}
			if(unripe == 0) {
				System.out.println(day+1);
				break;
			}
		}
		if(unripe>0) {
			System.out.println(-1);
		}
	}

}
