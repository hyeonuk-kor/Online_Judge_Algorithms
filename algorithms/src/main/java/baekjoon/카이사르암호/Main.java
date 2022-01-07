package baekjoon.카이사르암호;
import java.io.*;
public class Main {
	static class P5598 {
		BufferedReader br;
		String str;
		P5598() {
			input();
			pro();
		}
		void pro() {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<str.length(); i++) {
				/*
				char c = (char)(str.charAt(i) - 3);
				if(c<'A') {
					c = (char)('Z' - ('A'-c) +1);
				} */
				char c = (char) ((str.charAt(i) - 'A' - 3 + 26) % 26 + 'A');
				sb.append(c);
			}
			System.out.println(sb);
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
		new P5598();
	}
}