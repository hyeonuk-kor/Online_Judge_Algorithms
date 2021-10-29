package baekjoon.비숍;
import java.io.*;
import java.math.*;
public class Main {
	static class P1560 {
		BufferedReader br;
		BigInteger N;
		BigInteger one = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		void solve() {
			input();
			if(N.equals(BigInteger.ZERO))
				System.out.println(one);
			else
				System.out.println(two.multiply(N)); 
			// 그림 그려서 점화식 세움
			/*
			 *  1 -> 1
			 *  2 -> 2
			 *  3 -> 4
			 *  4 -> 6
			 *  5 -> 8
			 *   ...
			 *  k -> 2(k-1)
			 */
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				N = new BigInteger(br.readLine());
				N = N.subtract(one);
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1560().solve();
	}
}