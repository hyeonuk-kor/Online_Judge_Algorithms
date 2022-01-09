package baekjoon.학점계산;
import java.io.*;
public class Main {
	static class P2754 {
		BufferedReader br;
		String str;
		P2754() {
			input();
			pro();
		}
		void pro() {
			StringBuilder sb = new StringBuilder();
			if(str.equals("F")) {
				sb.append(0.0);
			} else {
				int calc = 4-(str.charAt(0)-'A');
				if(str.charAt(1)=='+') {
					sb.append(calc).append(".3");
				} else if(str.charAt(1)=='-') {
					sb.append(calc-1).append(".7");
				} else {
					sb.append(calc).append(".0");
				}
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
		new P2754();
	}
}