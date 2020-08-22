package baekjoon.if문.윤년;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		System.out.println( (year%100!=0 && year%4==0 || year%400==0 ? 1 : 0));
		sc.close();
	}

}
