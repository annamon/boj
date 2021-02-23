import java.util.Scanner;

public class Main_BOJ_10163_색종이 {

	static int N;
	static int[][] arr = new int[101][101];
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		for (int n = 1; n <= N; n++) {
			int c = scann.nextInt();
			int r = scann.nextInt();
			int cc = scann.nextInt();
			int rr = scann.nextInt();
			for (int i = r; i < r+rr; i++) {
				for (int j = c; j < c+cc; j++) {
					arr[i][j] = n;
				}
			}
		}
		for (int n = 1; n <= N; n++) {
			int cnt = 0;
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if(arr[i][j]==n) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
