import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17406_배열돌리기4 {

	static int N, M, K, result;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			for (int i = 0; i < (2*s+1)/2; i++) {
				rotate(r-1,c-1,s,i);
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += arr[i][j];
				}
				if(result == 0) {
					result = sum;
				}else {
					result = Math.min(result, sum);
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void rotate(int r, int c, int s, int count) {
		Queue <Integer> oneway = new LinkedList<>();
		for (int i = c-s+count; i <= c+s-count; i++) {
			oneway.offer(arr[r-s+count][i]); // 북 줄
		}
		for (int i = r-s+count+1; i <= r+s-count; i++) { // 동 줄
			oneway.offer(arr[i][c+s-count]);
		}
		for (int i = c+s-1-count; i >= c-s+count; i--) { // 남 줄
			oneway.offer(arr[r+s-count][i]);
		}
		for (int i = r+s-1-count; i >= r-s+1+count; i--) { // 서 줄
			oneway.offer(arr[i][c-s+count]);
		}
		
		for (int i = c-s+count+1; i <= c+s-count; i++) {
			arr[r-s+count][i] = oneway.poll(); // 북 줄
		}
		for (int i = r-s+count+1; i <= r+s-count; i++) { // 동 줄
			arr[i][c+s-count] = oneway.poll();
		}
		for (int i = c+s-1-count; i >= c-s+count; i--) { // 남 줄
			arr[r+s-count][i] = oneway.poll();
		}
		for (int i = r+s-1-count; i >= r-s+1+count; i--) { // 서 줄
			arr[i][c-s+count] = oneway.poll();
		}
		arr[r-s+count][c-s+count] = oneway.poll();
	}

}
