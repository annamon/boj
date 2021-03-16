import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BOJ_1715_카드정렬하기2 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		PriorityQueue<Integer> card = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			card.add(scann.nextInt());
		}
		int answer = 0;
		for (int i = 0; i < N-1; i++) {
			int a = card.poll();
			int b = card.poll();
			answer += a+b;
			card.offer(a+b);
		}
		System.out.println(answer);
		
	}

}
