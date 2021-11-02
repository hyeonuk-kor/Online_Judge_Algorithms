package baekjoon.세로읽기;
import java.io.*;
public class Main {
	static class P10798 {
		BufferedReader br;
		StringBuilder sb;
		char[][] str = new char[15][15];
		P10798() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			for(int i=0; i<15; i++) {
				for(int j=0; j<5; j++) {
					if(str[j][i]!='\u0000') {
						sb.append(str[j][i]);
					}
				}
			}
		}
		void input() {
			try {
				for(int i=0; i<5; i++) {
					String input = br.readLine();
					for(int j=0; j<input.length(); j++) {
						str[i][j] = input.charAt(j);
					}
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10798();
	}
}