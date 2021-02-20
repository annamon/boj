import java.util.Scanner;

public class Main_BOJ_5904_Moo게임 {

	static int N;
	static char answer;
	static int moo = 3;
	static int K = 0;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		while(moo < N) {	// S(K)의  K값 구하기
			K++;
			moo = moo*2 + K + 3;	// moo는 수열 글자 총 개수
		}
		find(moo, K, N);
		System.out.println(answer);
	}
	
	private static void find(int nm, int k, int n) {
		
		// nm : 수열 글자 총개수, k : S(k)의 k, n : 몇번째 글자 찾을지
		// S(k) = S(k-1) + m + o..o + S(k-1)
		//						ㄴ> k+2 개
		// S(k-1) 글자 개수 : (전체-중간부분)/2 = (nm-(k+3))/2 개
		
		
		if(n <= (nm-k-3)/2) {			// 앞쪽 s(k-1)
			find((nm-k-3)/2, k-1, n);
		}
		else if(n > nm - (nm-k-3)/2) {	// 뒤쪽 s(k-1)
			n = n - (nm-k-3)/2 - (k+3); // 뒤쪽에서 몇 번째 찾을건지 해야되니 앞부분 개수 날려주기
			find((nm-k-3)/2, k-1, n);
		}
		else {							// 중간이라면
			if(n==(nm-k-3)/2+1) {		// 중간에서 첫 번째면 m 아니면 o
				answer='m';
				return;
			}
			else {
				answer = 'o';
				return;
			}
		}
	
	}
	

	
}
