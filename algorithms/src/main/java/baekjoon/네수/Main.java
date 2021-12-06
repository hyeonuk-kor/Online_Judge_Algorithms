package baekjoon.네수;
import java.io.*;
import java.util.*;
public class Main {
	static class P10824 {
		BufferedReader br;
		StringTokenizer st;
		String A, B, C, D;
		P10824() {
			input();
			long sum = Long.parseLong(A+B) + Long.parseLong(C+D);
			System.out.println(sum);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				A = st.nextToken();
				B = st.nextToken();
				C = st.nextToken();
				D = st.nextToken();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10824();
	}
}