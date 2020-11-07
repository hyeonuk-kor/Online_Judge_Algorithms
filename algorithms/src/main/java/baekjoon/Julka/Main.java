package baekjoon.Julka;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger sum = new BigInteger(sc.next());
		BigInteger m = new BigInteger(sc.next());
		System.out.println(sum.subtract(sum.subtract(m).divide(new BigInteger("2"))));
		System.out.println(sum.subtract(m).divide(new BigInteger("2")));
		//System.out.println(sum-((sum-m)/2));
		//System.out.println((sum-m)/2);
	}
}
