import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16935_배열돌리기3 {

	static int R, num, nr, nc, t;
	static int[][] arr;
	static int[][] temp;
	static Queue<Integer> box = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		nr = Integer.parseInt(st.nextToken());
		nc = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[nr][nc];
		temp = new int[nr][nc];
		for (int i = 0; i < nr; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < nc; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				temp[i][j] = a;
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int r = 1; r <= R; r++) {
			num = Integer.parseInt(st.nextToken());
			switch (num) {
			case 1:
				updown();
				break;
			case 2:
				leftright();
				break;
			case 3:
				rigth90();
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
				
			default:
				break;
			}
		}
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void rigth90() {
		for (int j = 0; j < nc; j++) {
			for (int i = nr-1; i >=0; i++) {
				box.offer(temp[i][j]);
			}
		}
		t = nr;
		nc = t;
		nr = nc;
		arr = new int[nr][nc];
		for (int i = 0; i <nr; i++) {
			for (int j = 0; j < nc; j++) {
				arr[i][j] = box.poll();
			}
		}
		temp = arr.clone();
	}


	private static void leftright() {
		for (int j = nc-1; j>=0; j--) {
			int a = 0;
			for (int i = 0; i<nr; i++) {
				arr[i][a] = temp[i][j];
			}
			a++;
		}
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				temp[i][j] = arr[i][j];
			}
		}
	}

	private static void updown() {
		int a = 0;
		for (int i = nr-1; i >= 0; i--) {
			for (int j = 0; j <nc; j++) {
				arr[a][j] = temp[i][j];
			}
			a++;
		}
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				temp[i][j] = arr[i][j];
			}
		}
	}

}
