import java.util.Scanner;

public class Main_BOJ_2941_크로아티아알파벳 {

	static int tot;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String word = scann.nextLine();
		tot = word.length();
		for (int i = 0; i < word.length(); i++) {
			switch (word.charAt(i)) {
			case '=':
				if(i>=2 && word.charAt(i-1)=='z' && word.charAt(i-2)=='d') tot-=2;
				else tot--;
				break;
			case '-':
				tot--;
				break;
			case 'j':
				if(i>=1 && (word.charAt(i-1)=='l'||word.charAt(i-1)=='n')) tot--;
			default:
				break;
			}
			
		}
		System.out.println(tot);
	}

}
