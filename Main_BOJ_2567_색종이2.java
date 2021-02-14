import java.util.Scanner;

public class Main_BOJ_2567_색종이2 {

	static int T, count;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr = new int[100][100];
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			int r = scann.nextInt();
			int c = scann.nextInt();
			for (int i = 90-c; i < 100-c; i++) {
				for (int j = r; j < r+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j]==1) {
					check(i,j);
				}
			}
		}
		System.out.println(count);
	}

	private static void check(int rr, int cc) {
		int num = 0;	// 1 주변에 0이 몇개인지 카운트 (4방)
		for (int i = 0; i < 4; i++) {
			int nr = rr+dr[i];
			int nc = cc+dc[i];
			if(nr>=0 && nr<100 && nc>=0 && nc<100 && arr[nr][nc]==0) num++; // 0이면 넘 +1
			else if(nr<0 || nr>=100 || nc<0|| nc>=100) num++;	// 도화지 테두리면 +1
		}
		if(num==2) count+=2;	// 0이 두 개이면 테두리 모서리니까 2 더하기
		else if(num==1) count++;	// 0 하나이면 변이니까 1 더하기
		// 그 외는 테두리 아니니까 카운트 ㄴㄴ
	}

}
