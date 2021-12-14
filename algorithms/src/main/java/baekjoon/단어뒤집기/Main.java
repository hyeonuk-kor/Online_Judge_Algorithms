package baekjoon.단어뒤집기;
import java.io.*;
import java.util.*;
public class Main {
	static class P9093 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		P9093() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int T = Integer.parseInt(br.readLine());
				for(int t=0; t<T; t++) {
					StringBuilder sb2 = new StringBuilder();
					st = new StringTokenizer(br.readLine().trim());
					while(st.hasMoreTokens()) {
						sb2.append(st.nextToken());
						sb.append(sb2.reverse()).append(' ');
						sb2.delete(0, sb2.length());
					}
					sb.append('\n');
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P9093();
	}
}