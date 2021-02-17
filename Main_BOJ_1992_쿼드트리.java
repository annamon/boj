import java.util.Scanner;

public class Main_BOJ_1992_쿼드트리 {

	static int N, count;
	static char[][] avi;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = Integer.parseInt(scann.nextLine());
		avi = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = scann.nextLine();
			for (int j = 0; j < N; j++) {
				avi[i][j] = s.charAt(j);
			}
		}
		int nn = 1;		// 비디오 크기가 2의 몇 승인지 구하셈  ㅠ
		while(nn != N) {// 로그 어케하는 건데
			nn *= 2;	// 어케 하는 거냐고~!
			count++;
		}
		check(0,0,N,0);
		
	}
	
	private static void check(int r, int c, int w, int cnt) {
		if(cnt==count-1) {
			// 마지막 4개 비교 ㄱ
			if(avi[r][c] == avi[r][c+1] && avi[r][c+1] == avi[r+1][c]
					&& avi[r+1][c] == avi[r+1][c+1] )
				System.out.print(avi[r][c]);	// 4개 같으면 하나만 출력
			else System.out.print("("+avi[r][c]+ avi[r][c+w/2] 
					+ avi[r+w/2][c] + avi[r+w/2][c+w/2] +")");	// 다르면 각각 출력
			return;
		}
		
		int sum = 0;
		for (int i = r; i < r+w; i++) {
			for (int j = c; j < c+w; j++) {
				sum += avi[i][j]-'0';
			}
		}
		// 총합 구해~! 다 같으면 굳이 재귀 안 돌아도 됨
		if(sum==0) {
			System.out.print(0);
		}
		else if(sum==w*w) {
			System.out.print(1);
		}
		else {	// 근데 다르면 돌아 ㅎ
			System.out.print("(");
			check(r, c, w/2, cnt+1);
			check(r, c+w/2, w/2, cnt+1);
			check(r+w/2, c, w/2, cnt+1);
			check(r+w/2, c+w/2, w/2, cnt+1);
			System.out.print(")");
		}
	}

}
