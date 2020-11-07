package baekjoon.R2;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R1, R2, S;
		R1 = sc.nextInt();
		S = sc.nextInt();
		R2 = 2*S-R1;
		System.out.println(R2);
	}
}
