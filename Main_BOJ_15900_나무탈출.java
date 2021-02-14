import java.util.Scanner;

public class Main_BOJ_15900_나무탈출 {

	static int N, total;
	static int[] tree;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		tree = new int[N+1];
		for (int n = 0; n < N-1; n++) {
			int a = scann.nextInt();
			tree[a]++;
			int b = scann.nextInt();
			tree[b]++;
		}
		for (int i = 0; i < N+1; i++) {
			System.out.print(tree[i]+" ");
		}
		for (int i = 2; i <= N; i++) {
			if(tree[i]!=1) {
				total+= tree[i]-1;
			}else {
				total += tree[i];
			}
		}
		if (total%2==0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

}
