import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_1158_요세푸스문제 {

	static int N, K;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		K = scann.nextInt();
		Queue<Integer> josephus = new LinkedList<>();
		for (int i = 0; i <N ; i++) {
			josephus.offer(i+1);	// 요세푸스 큐에 사람 1부터 N번까지 넣기
		}
		System.out.print("<");
		while(josephus.size()!=1) {		// 1명 남을때까지 돌려돌려 큐림판
			for (int i = 1; i < K; i++) {			// K번째 이전까지
				josephus.offer(josephus.poll());	// 뺀 놈 뒤로 보내기
			}
			System.out.print(josephus.poll()+", ");	// K번째놈 나와
		}
		System.out.println(josephus.poll()+">");	// 마지막놈 나와
	}

}
