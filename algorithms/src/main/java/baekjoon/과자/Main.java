package baekjoon.과자;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int calc = a*b;
		if(calc<=c)
			System.out.println(0);
		else
			System.out.println(calc-c);
	}
}