import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2493_탑3 {

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
		for (int i = N-1; i >0 ; i--) {
			count=0;
			for (int j = i-1; j >= 0; j--) {
				if(height[i]<height[j]) {
					top.push(j+1);
					count=1;
					break;
				}
			}
			if(count!=1) {
				top.push(0);
			}
		}
		top.push(0);
		for (int i = 0; i < N; i++) {
			System.out.print(top.pop()+" ");
		}
		
	}
}