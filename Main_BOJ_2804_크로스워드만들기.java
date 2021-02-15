import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_2804_크로스워드만들기 {

	static int r, c;
	static char[] first, second;
	static char[][] cross;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String word = scann.next();
		first = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			first[i] = word.charAt(i);
		}
		word = scann.next();
		second = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			second[i] = word.charAt(i);
		}
		cross = new char[second.length][first.length];
		Arrays.fill(cross, '.');
	
		
	}

}
