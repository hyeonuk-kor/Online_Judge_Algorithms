package baekjoon.소수and팰린드롬;
import java.io.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		while(true) {
			BigInteger number = BigInteger.valueOf(N);
			if(number.isProbablePrime(1) && checkPalindrom(String.valueOf(N))) {
				System.out.println(N);
				break;
			}
			N++;
		}
	}
	static boolean checkPalindrom(String str) {
		String rev = new StringBuilder(str).reverse().toString();
		return str.equals(rev);
	}
}