import java.util.ArrayList;
import java.util.Scanner;

public class Main_BOJ_17135_캐슬디펜스 {

	static class enemy{
		int r, c;
		public enemy(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static class archer{
		int r, c;
		public archer(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, D;
	static int count;
	static int[] choose = new int[3];
	static ArrayList<enemy> whereE = new ArrayList<>();
	static ArrayList<archer> archerList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		D = scann.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < D; j++) {
				if(scann.nextInt()==1) {
					whereE.add(new enemy(i, j));
				}
			}
		}
		
		fight(0,0);
		System.out.println(count);
	}
	
	private static void fight(int cnt, int start) {
		if(cnt==3) {
			for (int i = whereE.get(0).r; i <= N; i++) {
				for (int j = 0; j < choose.length; j++) {
					for (int k = 0; k < whereE.size(); k++) {
						int distance = Math.abs(archerList.get(choose[j]).r - whereE.get(k).r)
								+ Math.abs(archerList.get(choose[j]).c - whereE.get(k).c);
						
					}
				}
			}
			return;
		}
		for (int i = start; i < M; i++) {
			choose[cnt] = i;
			fight(cnt+1, i+1);
		}
	}

}
