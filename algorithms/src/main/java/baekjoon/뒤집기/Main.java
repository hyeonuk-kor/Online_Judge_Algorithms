package baekjoon.뒤집기;
import java.io.*;
public class Main {
	static class P1439 {
		BufferedReader br;
		String str;
		P1439() {
			input();
			pro();
		}
		void pro() {
			char[] cstr = compStr(str);
			int one = 0, zero = 0;
			for(int i=0; i<cstr.length; i++) {
				if(cstr[i]=='0') {
					zero++;
				} else {
					one++;
				}
			}
			System.out.println(Math.min(zero, one));
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
		char[] compStr(String str) {
			StringBuilder sb = new StringBuilder();
			char c = str.charAt(0);
			sb.append(c);
			for(int i=1; i<str.length(); i++) {
				if(c!=str.charAt(i)) {
					c = str.charAt(i);
					sb.append(c);
				}
			}
			return sb.toString().toCharArray();
		}
	}
	public static void main(String[] args) {
		new P1439();
	}
}