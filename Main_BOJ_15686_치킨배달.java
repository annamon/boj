import java.util.ArrayList;
import java.util.Scanner;

public class Main_BOJ_15686_치킨배달 {

	static int N, M;
	static int street; // 집의 치킨거리
	static int total;  // 도시의 치킨거리 (집 치킨거리 총합)
	static int answer = Integer.MAX_VALUE; // 도시의 치킨거리 최소값 찾기
	static int[] choose;	// 조합
	static ArrayList<chicken> chickenList = new ArrayList<>(); // 치킨집목록
	static ArrayList<house> houseList = new ArrayList<>();	   // 집 목록
	
	static class chicken{
		int r, c;
		public chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static class house{
		int r, c;
		public house(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		choose = new int[M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				int num = scann.nextInt();
				if(num==1) {		// 입력값이 1이면 집 목록에 추가
					houseList.add(new house(i+1, j+1));
				}
				else if(num==2) {	// 입력값이 2이면 치킨집 목록에 추가
					chickenList.add(new chicken(i+1, j+1));
				}
				else continue;
			}
		}
		find(0,0);
		System.out.println(answer);
	}

	private static void find(int cnt, int start) {
		if(cnt == M) {
			total = 0;
			for (int i = 0; i < houseList.size(); i++) {	
				street = Integer.MAX_VALUE;
				for (int j = 0; j < choose.length; j++) {	// 각 집마다 치킨거리 최소값 찾기
					int nowStreet = Math.abs(houseList.get(i).r - chickenList.get(choose[j]).r) + 
							Math.abs(houseList.get(i).c - chickenList.get(choose[j]).c);
					street = Math.min(street, nowStreet);
				}
				total += street;	// 도시의 치킨거리 = 집 치킨거리 합
			}
			answer = Math.min(answer, total);	// 도시의 치킨거리 최소값 찾기
			return;
		}
		for (int i = start; i < chickenList.size(); i++) {
			choose[cnt] = i;
			find(cnt+1, i+1);
		}
		
	}

}
