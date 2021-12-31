package baekjoon.단어뒤집기2;
import java.io.*;
public class Main {
	static class P17413 {
		BufferedReader br;
		String str;
		P17413() {
			input();
			pro();
		}
		void pro() {
			StringBuilder answer = new StringBuilder();
			StringBuilder sb = new StringBuilder();
			boolean tag = false;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='<') {
					answer.append(sb.reverse());
					sb.delete(0, sb.length());
					tag = true;
				} else if(str.charAt(i)=='>') {
					answer.append('<').append(sb).append('>');
					sb.delete(0, sb.length());
					tag = false;
				} else if(!tag && str.charAt(i)==' '){
					answer.append(sb.reverse()).append(' ');
					sb.delete(0, sb.length());
				} else {
					sb.append(str.charAt(i));
				}
 			}
			if(sb.length()!=0) {
				answer.append(sb.reverse());
			}
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				str = br.readLine();
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		new P17413();
	}
}
