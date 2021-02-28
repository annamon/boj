import java.util.Scanner;
import java.util.Stack;
// 실버4
public class Main_BOJ_9012_괄호 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			String word = scann.next();
			Stack<Character> vps = new Stack<>();
			for (int i = 0; i < word.length(); i++) {
				if(vps.isEmpty()) vps.push(word.charAt(i));
				else if(word.charAt(i)==')' && vps.peek()=='(') {
					vps.pop();
				}
				else vps.push(word.charAt(i));
			}
			if(vps.isEmpty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

}
