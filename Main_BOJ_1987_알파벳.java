import java.util.Scanner;

public class Main_BOJ_1987_알파벳 {

	static int R, C, answer;
	static char[][] board;
	static boolean[] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		R = scann.nextInt();
		C = scann.nextInt();
		board = new char[R][C];
		visited = new boolean[26];
		for (int i = 0; i < R; i++) {
			String st = scann.next();
			for (int j = 0; j < C; j++) {
				board[i][j] = st.charAt(j);
			}
		}
		visited[board[0][0]-'A'] = true;
		letsgo(0,0,1);
		System.out.println(answer);
	}
	
	private static void letsgo(int r, int c, int count) {
		int cango = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
			if(!visited[board[nr][nc]-'A']) {
				cango = 1;
				visited[board[nr][nc]-'A'] = true;
				letsgo(nr, nc, count+1);
				visited[board[nr][nc]-'A'] = false;
			}
		}
		if(cango==0) {
			answer = Math.max(answer, count);
		}
	}

}
