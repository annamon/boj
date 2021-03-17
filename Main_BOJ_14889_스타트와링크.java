import java.util.Scanner;

public class Main_BOJ_14889_스타트와링크 {

	static int N, answer = Integer.MAX_VALUE;
	static int[][] team;
	static boolean[] isStartTeam;
	static int[] start, link;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		team = new int[N][N];
		isStartTeam = new boolean[N];
		start = new int[N/2];
		link = new int[N/2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				team[i][j] = scann.nextInt();
			}
		}
		maketeam(0,0);
		System.out.println(answer);
	}
	
	private static void maketeam(int count, int starts) {
		if(count==N/2) { // 팀가르기 끝나면
			int a = 0;
			int b = 0;
			for (int i = 0; i < N; i++) { // 스타트팀, 링크팀 배정하기
				if(isStartTeam[i]) {
					start[a++] = i;
				}
				else {
					link[b++] = i;
				}
			}
			int startSum = 0;
			int linkSum = 0;
			for (int i = 0; i < N/2; i++) { // 스타트팀합
				for (int j = 0; j < N/2; j++) {					
					startSum += team[start[i]][start[j]];
				}
			}
			for (int i = 0; i < N/2; i++) { // 링크팀합
				for (int j = 0; j < N/2; j++) {					
					linkSum += team[link[i]][link[j]];
				}
			}
			answer = Math.min(answer, Math.abs(startSum-linkSum));
			return;
		}
		for (int i = starts; i < N; i++) {
			if(isStartTeam[i]) continue;
			isStartTeam[i] = true;  // 스타트팀 골라내기
			maketeam(count+1, i+1);
			isStartTeam[i] = false;
		}
	}

}
