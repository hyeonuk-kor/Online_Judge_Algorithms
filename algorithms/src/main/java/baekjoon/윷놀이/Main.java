package baekjoon.윷놀이;
import java.io.*;
import java.util.*;
public class Main {
	static class P2490 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		P2490() {
			br = new BufferedReader(new InputStreamReader(System.in));
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			try {
				for(int i=0; i<3; i++) {
					int sum = 0;
					st = new StringTokenizer(br.readLine().trim());
					for(int j=0; j<4; j++) {
						sum += Integer.parseInt(st.nextToken());
					}
					switch (sum) {
						case 4: sb.append("E"); break;
						case 3: sb.append("A"); break;
						case 2: sb.append("B"); break;
						case 1: sb.append("C"); break;
						default: sb.append("D"); break;
					}
					sb.append('\n');
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2490();
	}
}
