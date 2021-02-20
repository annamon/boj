import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_1931_회의실배정 {

	static class Room implements Comparable<Room>{
		int start, end;

		public Room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Room o) {
			int gap = this.end - o.end;	// 끝나는 시간 기준으로 잡고
			return gap==0? this.start - o.start : gap; 	// 끝나는 시간이 같으면 시작시간 기준으로 잡기
		}
		
	}
	
	static int N;
	static int count = 1, end;
	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		Room[] time = new Room[N];	// 룸 배열 만들기
		for (int i = 0; i < N; i++) {
			time[i] = new Room(scann.nextInt(), scann.nextInt());
		}
		assign(time);
		System.out.println(count);
	}
	
	private static void assign(Room[] time) {
		Arrays.sort(time);	// 배열 정렬하기
		end = time[0].end;	// 첫 번째 놈 무조건 ㄱ
		for (int i = 1; i < time.length; i++) {
			if(end <= time[i].start) {	// 현재 끝 시간이 다음 시작시간보다 이르면
				end = time[i].end;		// 추가 ㄱㄱ
				count++;
			}
		}
	}

}
