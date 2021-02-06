import java.util.Scanner;

public class Main_BOI_1244_스위치켜고끄기 {

	static int T, N;
	static int[] state;

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		state = new int[T];
		for (int i = 0; i < T; i++) {
			state[i] = scann.nextInt();
		}
		N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			int gender = scann.nextInt();
			int number = scann.nextInt();
			if (gender == 1) {
				for (int j = 1; number * j - 1 < T; j++) {
					change(number * j);
				}
//				for (int x : state) {
//					System.out.print(x + " ");
//				}
			} else {
				change(number);
				for (int j = 1; (number - j - 1 >= 0) && (number + j - 1 < T); j++) {
					if (state[number - j - 1] == state[number + j - 1]) {
						change(number - j);
						change(number + j);
					} else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < T; i++) {
			if((i+1)%20==0) System.out.println(state[i]);
			else System.out.print(state[i]+" ");
		}
	}

	private static void change(int i) {
		if (state[i - 1] == 1) {
			state[i - 1] = 0;
		} else
			state[i - 1] = 1;
	}
}
