package baekjoon.쉽게푸는문제;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt()-1;
		int b = sc.nextInt();
		System.out.println((int)(((6*b+1)*Math.round(Math.sqrt(2*b))-Math.pow(Math.round(Math.sqrt(2*b)), 3))/6-((6*a+1)*Math.round(Math.sqrt(2*a))-Math.pow(Math.round(Math.sqrt(2*a)), 3))/6));
	}
}
