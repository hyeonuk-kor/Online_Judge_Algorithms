package baekjoon.애너그램만들기;
import java.io.*;
public class Main {
	static class P1919 {
		BufferedReader br;
		String A, B;
		P1919() {
			input();
			pro();
		}
		void pro() {
			int answer = 0;
			int[][] alpha = new int[2][26];
			for(int a=0; a<A.length(); a++)
				alpha[0][A.charAt(a)-'a']++;
			for(int b=0; b<B.length(); b++)
				alpha[1][B.charAt(b)-'a']++;
			
			for(int i=0; i<26; i++) {
				answer += Math.abs(alpha[0][i]-alpha[1][i]);
			}
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				A = br.readLine();
				B = br.readLine();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1919();
	}
}