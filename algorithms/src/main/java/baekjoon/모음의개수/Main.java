package baekjoon.모음의개수;
import java.io.*;
public class Main {
	static class P10987 {
		BufferedReader br;
		String str;
		P10987() {
			input();
			pro();
		}
		void pro() {
			int answer = 0;
			for(int i=0; i<str.length(); i++) {
				if(check(str.charAt(i))) {
					answer++;
				}
			}
			System.out.println(answer);
		}
		boolean check(char c) {
			return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
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
		new P10987();
	}
}