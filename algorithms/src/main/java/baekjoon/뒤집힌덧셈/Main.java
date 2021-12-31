package baekjoon.뒤집힌덧셈;
import java.io.*;
import java.util.*;
public class Main {
	static class P1357 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder X, Y;
		P1357() {
			input();
			pro();
		}
		void pro() {
			int convX = Integer.parseInt(X.reverse().toString());
			int convY = Integer.parseInt(Y.reverse().toString());
			int sum = convX+convY;
			StringBuilder sb = new StringBuilder();
			sb.append(sum);
			System.out.println(Integer.parseInt(sb.reverse().toString()));
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				X = new StringBuilder(st.nextToken());
				Y = new StringBuilder(st.nextToken());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1357();
	}
}