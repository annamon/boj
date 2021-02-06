import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2493_탑4 {

	static int N;
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
		Stack<int[]> top = new Stack<>();
		System.out.print("0 ");
		top.push(new int[] {height[0],1});
		for (int i = 1; i < N; i++) {
			if(height[i]>height[i-1]) { // 
				if(top.peek()[0]<height[i]) {
					top.pop();
				}
				System.out.print(top.peek()[1]+" ");
				top.push(new int[] {height[i], i+1});
			}
			else {
				System.out.print(top.peek()[1]+" ");
				top.push(new int[] {height[i], i+1});
			}
		}
		
	}
}