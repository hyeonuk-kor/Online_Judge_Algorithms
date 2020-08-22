package baekjoon.if문.알람시계;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		if(H==0)
			H = 24;
		
		int alarm = H*60 + M-45;
		H = alarm / 60;
		M = alarm % 60;
		
		if(H==24)
			H = 0;
		
		System.out.println(H+" "+M);
		sc.close();
	}

}
