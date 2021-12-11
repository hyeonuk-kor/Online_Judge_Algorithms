package baekjoon.이상한곱셈;
import java.io.*;
import java.util.*;
import java.math.*;
class P1225 {
	char[] A, B;
	P1225() {
		input();
		pro();
	}
	void pro() {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ZERO;
		for(char c: A)
			a = a.add(new BigInteger(Character.toString(c)));
		for(char c: B)
			b = b.add(new BigInteger(Character.toString(c)));
		System.out.println(a.multiply(b));
	}
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			A = st.nextToken().toCharArray();
			B = st.nextToken().toCharArray();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Main {
	public static void main(String[] args) {
		new P1225();
	}
}