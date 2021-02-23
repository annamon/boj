import java.util.Scanner;

public class Main_BOJ_13300_방배정 {

	static int N, K, room;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		K = scann.nextInt();
		arr = new int[7][2];	// [학년][성별], 학년은 인덱스 1~6 씀
		for (int n = 0; n < N; n++) {
			int s = scann.nextInt();	 // 성별
			int grade = scann.nextInt(); // 학년
			arr[grade][s]++;
		}
		for (int i = 1; i <=6 ; i++) {
			for (int j = 0; j <= 1; j++) {
				if(arr[i][j]==0) continue;	// 학생 없으면 패스
				else{	// 학생 있으면 K로 나누어 올림 계산
					room += Math.ceil((double)arr[i][j] / (double)K);
				}
			}
		}
		System.out.println(room);
	}

}
