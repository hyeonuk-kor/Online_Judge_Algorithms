package baekjoon.P11365;
import java.io.*;
public class Main {
	static class P11365 {
		BufferedReader br;
		StringBuilder sb;
		P11365() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String str = br.readLine();
				while(!str.equals("END")) {
					solve(new StringBuilder(str));
					str = br.readLine();
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void solve(StringBuilder str) {
			sb.append(str.reverse()).append('\n');
		}
	}
	public static void main(String[] args) {
		new P11365();
	}
}