import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 실패
public class Main_BOJ_16236_아기상어 {

	static class fish implements Comparable<fish>{
		int r;
		int c;
		int size;
		public fish(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
		@Override
		public int compareTo(fish o) {
			if(this.r - o.r == 0) {
				return this.c - o.c;
			}
			else return this.r-o.r;
		}
	}
	
	static class shark{
		int r;
		int c;
		int size;
		int eat;
		public shark(int r, int c, int size, int eat) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.eat = eat;
		}
	}
	
	static int N, time;
	static shark shark;
	static int[][] sea;
	static fish[] food;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		sea = new int[N][N];
		int count=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sea[i][j] = scann.nextInt();
				if(sea[i][j]!=0 && sea[i][j]!=9) count++;
			}
		}
		if(count==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		food = new fish[count];
		visited = new boolean[count];
		int c=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(sea[i][j]==0) continue;
				else if(sea[i][j]==9) {
					shark = new shark(i, j, 2, 0);
				}
				else {
					food[c] = new fish(i, j, sea[i][j]);
					c++;
				}
			}
		}
		Arrays.sort(food);
		go();
		System.out.println(time);
	}
	
	private static void go() {
		// shark : r, c, size, eat
		//  fish : r, c, size
		Queue<shark> q = new LinkedList<>();
		q.offer(shark);
		int move = 0;
		int index = 0;
		boolean cango = false;
		while(!q.isEmpty()) {
			shark now = q.poll();
			move = Integer.MAX_VALUE;
			for (int i = 0; i < food.length; i++) {
				if(food[i].size >= now.size) continue;
				if(food[i].size < now.size && !visited[i]) {
					int distance = Math.abs(food[i].r - now.r) + Math.abs(food[i].c - now.c);
					if(distance<move) {						
						move = distance;
						index = i;
						cango = true;
					}
				}
			}
			if(cango) {				
				visited[index] = true;
				cango = false;
				time += move;
				if(now.eat+1 == now.size) {
					q.offer(new shark(food[index].r, food[index].c, now.size+1, 0));
				}else {
					q.offer(new shark(food[index].r, food[index].c, now.size, now.eat+1));
				}
			}
		}
	}

}
