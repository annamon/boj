import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_1759_암호만들기 {

	static int L, C;
	static boolean condition;
	static String[] alphabet, password;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		L = scann.nextInt();
		C = scann.nextInt();
		alphabet = new String[C];
		password = new String[L];
		for (int i = 0; i < C; i++) {
			alphabet[i] = scann.next();
		}
		Arrays.sort(alphabet); // 알파벳순으로 정렬
		make(0, 0);
	}
	
	private static void make(int count, int start) {
		if(count==L) {
			if(!isV()) return; // 조건 만족 안 하면 빠꾸
			for (int i = 0; i < L; i++) {
				System.out.print(password[i]);
			}
			System.out.println();
			return;
		}
		for (int i = start; i < C; i++) { // 조합 ㄱㄱ
			password[count] = alphabet[i];
			make(count+1, i+1);
		}
	}

	private static boolean isV() {
		// 조건 만족하는지 체크
		// 모음 1개 이상, 자음 2개 이상이면 true
		int count = 0; // 모음
		int notv = 0;  // 자음
		for (int i = 0; i < L; i++) {
			if(password[i].equals("a") || password[i].equals("e") || password[i].equals("i")
					|| password[i].equals("o") || password[i].equals("u")) count++;
			else notv++;
		}
		if(count>=1 && notv >=2) return true;
		else return false;
	}
	

}
