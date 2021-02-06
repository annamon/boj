import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2493_탑2 {

	static int N, count;
	static int[] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		height = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> top = new Stack<>();
		for (int i = 0; i < N; i++) {
			int count=0;
			for (int j = 0; j < i; j++) {
				top.push(height[j]);
				count++;
			}
			while(!top.isEmpty()) {
				if (top.peek() >= height[i]) {
					break;
				}else {
					top.pop();
					count--;
				}
			}
			while(!top.isEmpty()) {
				top.pop();
			}
			System.out.printf("%d ", count);
		}
	}
}
