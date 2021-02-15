import java.util.Scanner;

public class Main_BOJ_2961_도영이가만든맛있는음식 {

	// 도영이 나와 ㅡㅡ
	
	static int N, food = Integer.MAX_VALUE;
	static int[] sour;
	static int[] bitter;
	static boolean[] isSelected;
	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		sour = new int[N];
		bitter = new int[N];
		isSelected = new boolean[N];
		for (int n = 0; n < N; n++) {
			sour[n] = scann.nextInt();
			bitter[n] = scann.nextInt();
		}
		cook(0);
		System.out.print(food);
	}
	private static void cook(int cnt) {
		if(cnt == N) {
			int stotal =1;
			int btotal = 0;
			int select = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {			// 고른 재료
					stotal *= sour[i];		// 신맛
					btotal += bitter[i];	// 쓴맛
					select++;
				}
			}
			if(select>0) {
				food = Math.min(food, Math.abs(stotal-btotal));
			}
			return;
		}
		isSelected[cnt] = true;
		cook(cnt+1);		
		isSelected[cnt] = false;
		cook(cnt+1);
	}
}
