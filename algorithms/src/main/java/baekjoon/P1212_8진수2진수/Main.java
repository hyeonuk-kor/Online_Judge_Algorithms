package baekjoon.P1212_8진수2진수;
import java.util.*;
import java.math.BigInteger;
class Main {
	public static void main(String[] v) {
		Scanner sc = new Scanner(System.in);
		BigInteger a = new BigInteger(sc.next(), 8);
		System.out.println(a.toString(2));
	}
}