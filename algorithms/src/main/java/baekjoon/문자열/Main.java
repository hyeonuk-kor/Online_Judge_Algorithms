package baekjoon.문자열;
import java.io.*;
import java.util.*;
public class Main {
	static class P1120 {
		BufferedReader br;
		StringTokenizer st;
		String A, B;
		int answer = 50;
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				A = st.nextToken();
				B = st.nextToken();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		P1120() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			for(int i=0; i<=B.length()-A.length(); i++) {
				int count = 0;
				for(int j=0; j<A.length(); j++) {
					if(A.charAt(j)!=B.charAt(j+i))
						count++;
				}
				answer = Math.min(answer, count);
			}
		}
	}
	public static void main(String[] args) {
		new P1120();
	}
}