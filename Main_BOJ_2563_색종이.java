import java.util.Scanner;

public class Main_BOJ_2563_색종이 {

	static int[][] field = new int[100][100];
	static int T,r,c, result;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			c = scann.nextInt();
			r = scann.nextInt();
			for (int i = 90-r; i < 100-r; i++) {
				for (int j = c; j < c+10; j++) {
					if(field[i][j]==0) {
						field[i][j]=1;
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}

}