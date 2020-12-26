package baekjoon.최대공약수와최소공배수;
import java.io.*;
import java.math.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		System.out.println(a.gcd(b));
		System.out.println(a.multiply(b).divide(a.gcd(b)));
	}
}
