import java.util.Scanner;

public class Main_BOJ_2564_경비원 {

	static int R, C, a, b;
	static int T;
	static int run;
	static int[][] store;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		R = scann.nextInt(); // 가로
		C = scann.nextInt(); // 세로
		T = scann.nextInt();
		store = new int[T+1][2];
		for (int i = 0; i < T+1; i++) {
			for (int j = 0; j <2 ; j++) {
				store[i][j] = scann.nextInt(); // 이차원 배열에 상점 정보 동근정보 넣기
			}
		}
		for (int i = 0; i < T; i++) {
			if(store[i][0]==store[T][0]) { // 동근 상점 같은방향
				run += Math.abs(store[i][1]-store[T][1]);
			}
			else if(store[i][0]+store[T][0]==3||store[i][0]+store[T][0]==7) { // 동근 상점 건너편
				if(store[i][0]==1 ||store[i][0]==2 ) { // 남북
					a = store[i][1] + store[T][1] + C;
					b = 2*C + 2*R - a;
					run += (a>b) ? b : a;
				}else { // 동서
					a = store[i][1] + store[T][1] + R;
					b = 2*C + 2*R - a;
					run += (a>b) ? b : a;
				}
			}
			else if(store[i][0]+store[T][0]==4) { // 동근 상점 북서
				run += store[i][1] + store[T][1];
			}
			else if(store[i][0]+store[T][0]==6) { // 동근 상점 남동
				run += R+ C - store[i][1] - store[T][1];
			}
			else { // 동근 상점 서로 직각
				switch (store[T][0]) {
				case 1: // 동근이 북
					run += R - store[T][1] + store[i][1];
					break;
				case 4: // 동근이 서
					run += R - store[i][1] + store[T][1];
					break;
				case 3: // 동근이 동
					run += C - store[T][1] + store[i][1];
					break;
				case 2: // 동근이 남
					run += C - store[i][1] + store[T][1];
					break;
				default:
					break;
				}
			}
		}
		System.out.println(run);
	}

}
