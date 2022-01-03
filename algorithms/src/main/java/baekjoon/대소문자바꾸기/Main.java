package baekjoon.대소문자바꾸기;
import java.io.*;
public class Main {
	static class P2744 {
		BufferedReader br;
		StringBuilder sb;
		char[] str;
		P2744() {
			input();
			pro();
		}
		void pro() {
			sb = new StringBuilder();
			for(int i=0; i<str.length; i++) {
				if(str[i]>='a' && str[i]<='z') {
					sb.append(Character.toUpperCase(str[i]));
				} else {
					sb.append(Character.toLowerCase(str[i]));
				}
			}
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				str = br.readLine().toCharArray();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2744();
	}
}
