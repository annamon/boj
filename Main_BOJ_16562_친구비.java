import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_16562_친구비 {

	static int N, M, k, sum;
	static Friend[] friends;
	static int[] relationship;
	
	static class Friend implements Comparable<Friend> {
		int no, money;

		public Friend(int no, int money) {
			super();
			this.no = no;
			this.money = money;
		}
		
		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public int getMoney() {
			return money;
		}

		public void setMoney(int money) {
			this.money = money;
		}

		@Override
		public int compareTo(Friend o) {
			return this.money - o.money;
		}
	}
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		k = scann.nextInt();
		friends = new Friend[N+1];
		relationship = new int[N+1];
		friends[0] = new Friend(0,0);
		for (int i = 1; i < N+1; i++) {
			friends[i]= new Friend(i,scann.nextInt());
		}
		Arrays.sort(friends);
		Arrays.fill(relationship, 1);
		for (int i = 0; i < M; i++) {			
			union(scann.nextInt(), scann.nextInt());
		}
		for (int i = 1; i < N+1; i++) {
			if(relationship[i]!=1) {
				sum+=friends[i].money;
			}
		}
		if(sum<=k) System.out.println(sum);
		else System.out.println("Oh no");
	}
	private static int find(int x) {
		if(x==friends[x].getNo()) {
			return friends[x].getNo();
		}else {
			return friends[x].no = find(friends[x].getNo());
		}
	}
	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px==py) {
			return;
		}
		if(relationship[px]>=relationship[py]) {
			friends[py].no = px;
			relationship[px]+=relationship[py];
		}else {
			friends[px].no = py;
			relationship[py]+=relationship[px];
		}
	}
}
