import java.util.Scanner;

public class Main_BOJ_2477_참외밭 {

	static int K, big, small;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		K = scann.nextInt();
		int[] kmelon = new int[6];
		for (int i = 0; i < 6; i++) {
			scann.nextInt();
			kmelon[i] = scann.nextInt();
		}
		int br=0, bc=0;	// 큰밭
		for (int i = 0; i < 6; i++) {
			if(i%2==0) br = Math.max(kmelon[i], br);
			else bc = Math.max(kmelon[i], bc);
		}
		int sr=0, sc=0; // 잘린 밭
		for (int i = 0; i < 6; i++) {
			if(i%2==0) {
				if(bc==(kmelon[(i-1 +6)%6]+ kmelon[(i+1)%6])) { // 내 이전놈이랑 다음놈이 전체가 되면 
					sr = kmelon[i];
				}
			}
			else {
				if(br==(kmelon[(i-1 +6)%6]+ kmelon[(i+1)%6])) { // 내 이전놈이랑 다음놈이 전체가 되면 
					sc = kmelon[i];
				}
			}
		}
		big = br*bc;
		small = sr*sc;
		System.out.println((big-small)*K);
	}

}
