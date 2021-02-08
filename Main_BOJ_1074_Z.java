import java.util.Scanner;

public class Main_BOJ_1074_Z {

	static int N, r, c;
	static int[][] array;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		r = scann.nextInt();
		c = scann.nextInt();
		array = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
		find(N, 0, 0, 0);
		
		/*
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		*/
		 
		System.out.print(array[r][c]);
		scann.close();
	}
	// 영역 4등분하기
	private static void find(int num, int nr, int nc, int cnt) {
		if(num==0) {
			return;
		}
		
		int a = (int) Math.pow(2, num-1);
		int b = (int) Math.pow(2, num);
		int o = (int) Math.pow(2, 2*(num-1));
		
		array[nr][nc] = cnt;			// A
		array[nr][nc+a] = cnt + 1*o;	// B
		array[nr+a][nc] = cnt + 2*o;	// C
		array[nr+a][nc+a] = cnt + 3*o;  // D
		
		if(nr<=r && r< nr+a && nc<=c && c< nc+a) {} // 목표가 A 내라면
		else if(nr<=r && r< nr+a && nc+a<=c && c<nc+b) { // 목표가 B 내라면
			cnt += 1*o;
			nc +=a;
		}
		else if(nr+a<=r && r< nr+b && nc<=c && c<nc+a) { // 목표가 C 내라면
			cnt += 2*o;
			nr +=a;
		}
		else{ // 목표가 D 내라면
			cnt += 3*o;
			nr +=a;
			nc +=a;
		}
		find(num-1, nr, nc, cnt);
	}
}