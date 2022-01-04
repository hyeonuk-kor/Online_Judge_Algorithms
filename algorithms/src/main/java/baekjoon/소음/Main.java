package baekjoon.소음;
import java.io.*;
import java.math.*;
public class Main {
	static class P2935 {
		BufferedReader br;
		String A, B, EXP;
		P2935() {
			input();
			pro();
		}
		void pro() {
			BigInteger a = new BigInteger(A);
			BigInteger b = new BigInteger(B);
			BigInteger result;
			if(EXP.equals("*")) {
				result = a.multiply(b);
			} else {
				result = a.add(b);
			}
			System.out.println(result);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				A = br.readLine();
				EXP = br.readLine();
				B = br.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2935();
	}
}