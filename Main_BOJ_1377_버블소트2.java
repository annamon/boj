import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_1377_버블소트2 {

	static int N, times=Integer.MIN_VALUE;
	static List<Bubble> bubbles = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			bubbles.add(new Bubble(i, scann.nextInt()));
		}
		// bubbles
		// index :  0 1 2 3 4
		// vlaue : 10 1 5 2 3
		
		Collections.sort(bubbles);
		// index : 1 3 4 2 0
		// value : 1 2 3 5 10
		
		
		for (int i = 0; i < N; i++) {
			System.out.print(bubbles.get(i).index-i);
			times = Math.max(times, bubbles.get(i).index-i);
		}
		// 자동으로 뒤로 밀리는 건 생각ㄴㄴ
		// 현재 인덱스 - 과거 인덱스
		// 차이 : 1 2 2 -1 -4
		
		System.out.println(times+1);
		// +1 한 이유는 c++ 코드에서 i가 1부터 시작해서
	}
	
	static class Bubble implements Comparable<Bubble>{
		int index;
		int value;
		
		public Bubble(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Bubble o) {
			return this.value-o.value;
		}
		
	}

}
