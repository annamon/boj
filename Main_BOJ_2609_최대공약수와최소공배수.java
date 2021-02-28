import java.util.Scanner;

public class Main_BOJ_2609_최대공약수와최소공배수 {

	static int A, B;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		A = scann.nextInt();
		B = scann.nextInt();
		int n = 2;	  // 약수 시작은 2부터
		int gcd = 1;  // 최대공약수
		int lcm = 1;  // 최소공배수
		while(true) {
			if(n>A || n>B) break;	// 약수가 현재 숫자보다 커지면 종료
			if(A%n==0 && B%n==0) {
				A = A/n;
				B = B/n;
				gcd *= n;
			}else {
				n++;	// 공약수 아니면 +1
			}
		}
		lcm = gcd * A * B;
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
}
