package codeforces.ProgrammersandMathematicians;
import java.io.*;
import java.util.*;
public class Main {
	static class PAM {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int T;
		PAM() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				T = Integer.parseInt(br.readLine());
				for(int tc=0; tc<T; tc++) {
					st = new StringTokenizer(br.readLine().trim());
					int p = Integer.parseInt(st.nextToken());
					int m = Integer.parseInt(st.nextToken());
					sb.append(solution(p, m)).append('\n');
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int solution(int p, int m) {
			return Math.min(Math.min(p, m), (p+m)/4);
		}
	}
	public static void main(String[] args) {
		new PAM();
	}
}
