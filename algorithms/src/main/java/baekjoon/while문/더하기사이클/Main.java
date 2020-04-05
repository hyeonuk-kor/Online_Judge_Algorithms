package baekjoon.while문.더하기사이클;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int N2=N;
		int count = 0;
		int newN = -1;
		

		while(N!=newN) {
			int A = N2/10;
			int B = N2%10;
			int sum = A+B;
			newN = (B%10)*10+(sum%10);
			N2 = newN;
			count++;
		}
		System.out.println(count);
	}

}
