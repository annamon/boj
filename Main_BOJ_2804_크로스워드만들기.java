import java.util.Scanner;

public class Main_BOJ_2804_크로스워드만들기 {

	static int r, c;
	static char[] first, second;
	static char[][] cross;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String word = scann.next();
		int N = word.length();
		first = new char[N];
		for (int i = 0; i < N; i++) {
			first[i] = word.charAt(i);
		}
		word = scann.next();
		int M = word.length();
		second = new char[M];
		for (int i = 0; i < M; i++) {
			second[i] = word.charAt(i);
		}
		cross = new char[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				cross[i][j]='.';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(first[i]==second[j]) {
					r = j;
					c = i;
					break;
				}
			}
			if(r!=0) break;
		}
		for (int i = 0; i < N; i++) {
			cross[r][i] = first[i];
		}
		for (int i = 0; i < M; i++) {
			cross[i][c] = second[i];
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(cross[i][j]);
			}
			System.out.println();
		}
	}

}
