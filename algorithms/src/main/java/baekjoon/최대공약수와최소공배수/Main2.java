package baekjoon.최대공약수와최소공배수;
import java.io.*;
import java.util.*;
public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = getGCD(a, b);
		int lcm = a*b/gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}
	static int getGCD(int a, int b) {
		if(b==0) return a;
		return getGCD(b, a%b);
	}
}
