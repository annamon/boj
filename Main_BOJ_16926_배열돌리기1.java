import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16926_배열돌리기1 {

	static int N, M, R;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < Math.min(N,M)/2; i++) {
			rotate(i);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void rotate(int start) {
		Queue <Integer> oneway = new LinkedList<>();
		for (int i = start; i < M-start; i++) {
			oneway.offer(arr[start][i]); // 북 줄
		}
		for (int i = start+1; i < N-start ; i++) { // 동 줄
			oneway.offer(arr[i][M-start-1]);
		}
		for (int i = M-start-2; i >=start; i--) { // 남 줄
			oneway.offer(arr[N-start-1][i]);
		}
		for (int i = N-start-2; i >=start+1; i--) { // 서 줄
			oneway.offer(arr[i][start]);
		}
		for (int i = 0; i < R; i++) {
			int a = oneway.poll();
			oneway.offer(a);
		}
		for (int i = start; i < M-start; i++) { // 북줄
			arr[start][i] = oneway.poll();
		}
		for (int i = start+1; i < N-start ; i++) { // 동 줄
			arr[i][M-start-1] = oneway.poll();
		}
		for (int i = M-start-2; i >=start; i--) { // 남 줄
			arr[N-start-1][i] = oneway.poll();
		}
		for (int i = N-start-2; i >=start+1; i--) { // 서 줄
			arr[i][start] = oneway.poll();
		}
	}

}
