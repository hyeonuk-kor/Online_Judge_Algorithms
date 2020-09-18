package baekjoon.곱셈;

import java.util.Scanner;

public class 곱셈 {

	
	static int A, B, C;
	static int result = 1;
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		System.out.println(calc(A, B));

	}
	private static long calc(int A, int pon) {
		if(pon==0) {
			return 1;
		}
		
		long temp = calc(A, pon/2);
		if(pon%2==0) return (temp%C*temp%C)%C;
		return (temp%C*temp%C*A%C)%C;
		
	}


}
