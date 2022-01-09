package baekjoon.유학금지;
import java.io.*;
import java.util.Arrays;
public class Main {
	static class P2789 {
		BufferedReader br;
		StringBuilder sb;
		String str;
		P2789() {
			input();
			sb = new StringBuilder();
			pro();
			System.out.println(sb);
		}
		void pro() {
			char[] removeStr = "CAMBRIDGE".toCharArray();
			char[] cstr = str.toCharArray();
			for(char c: cstr) {
				boolean check = true;
				for(char r: removeStr) {
					if(c==r) {
						check = false;
						break;
					}
				}
				if(check) {
					sb.append(c);
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				str = br.readLine();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2789();
	}
}