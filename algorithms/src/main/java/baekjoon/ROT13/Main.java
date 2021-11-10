package baekjoon.ROT13;
import java.io.*;
public class Main {
	static class P11655 {
		BufferedReader br;
		StringBuilder sb;
		char[] str;
		P11655() {
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			for(int i=0; i<str.length; i++) {
				if(str[i]>='a' && str[i]<='z') {
					str[i] = (char) ('a'+(str[i]-'a'+13)%('z'-'a'+1));
				} else if(str[i] >= 'A' && str[i] <='Z') {
					str[i] = (char) ('A'+(str[i]-'A'+13)%('Z'-'A'+1));
				}
			}
			sb.append(str).append(' ');
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				str = br.readLine().toCharArray();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P11655();
	}
}