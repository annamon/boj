

import java.util.Scanner;

public class Main_BOJ_2493_탑 {

	static int N, t;
	static int[] height, result;
	static int[][] top;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		height = new int[N];
		result = new int[N];
		for (int n = 0; n < N; n++) {
			height[n] = scann.nextInt();
			t = Math.max(t, height[n]);
		}
		top = new int[t][N];
		for (int i = 0; i < N; i++) {
			for (int j = t-1; j > t-1-height[i] ; j--) {
				top[j][i] =1;
			}
		}
		for (int i = N-1; i >=0; i--) {
			for (int j = i-1; j >=0; j--) {
				if(top[t-height[i]][j]==1) {
					result[i]=j+1;
					break;
				}
			}
		}
		for (int x:result) {
			System.out.print(x+" ");
		}
	}
}
