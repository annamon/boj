import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_1260_DFS와BFS {

	static int N, M, start;
	static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		start = scann.nextInt();
		for (int n = 0; n <= N; n++) {
			map.add(new ArrayList<Integer>()); // 맵에 정점 개수만큼 자리 만들어주기
		}
		for (int m = 0; m < M; m++) {
			int a = scann.nextInt();
			int b = scann.nextInt();
			map.get(a).add(b);
			map.get(b).add(a);
		} // 맵에 관계 넣기
		for (int n = 0; n <= N; n++) {
			Collections.sort(map.get(n)); // 맵 내 리스트 안에 애들 오름차순 정렬
		}
		dfs();
		bfs();
	}

	private static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		que.offer(start);
		visited[start] = true;
		System.out.print(start+" ");
		while(!que.isEmpty()) {
			int now = que.peek();
			for (int i = 0; i < map.get(now).size(); i++) {
				int next = map.get(now).get(i);
				if(visited[next]) continue;
				visited[next] = true;
				que.offer(next);
				System.out.print(next+" ");
			}
			que.poll();
		}
	}

	private static void dfs() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[N+1];
		stack.push(start);
		visited[start] = true;
		System.out.print(start+" ");
		while(!stack.isEmpty()) {
			boolean no = true;
			for (int i = 0; i < map.get(stack.peek()).size(); i++) {
				int next = map.get(stack.peek()).get(i);
				if(visited[next]) continue;
				visited[next] = true;
				stack.push(next);
				no = false;
				System.out.print(next+" ");
				break;
			}
			if(no) stack.pop();
		}
		System.out.println();
	}

}
