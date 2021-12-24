package baekjoon.진법변환;
import java.io.*;
import java.util.*;
public class Main {
	static class P2745 {
		BufferedReader br;
		StringTokenizer st;
		String N;
		int B;
		P2745() {
			input();
			pro();
		}
		void pro() {
			int answer = 0;
			for(int i=0; i<N.length(); i++) {
				char c = N.charAt(i);
				if(c>='A' && c<='Z') {
					answer += (c-'A'+10) * Math.pow(B, N.length()-i-1);
				} else {
					answer += (c-'0') * Math.pow(B, N.length()-i-1);
				}
				/*
				if('A'<=c && c<='Z') {
					answer = answer * B +((c-'A')+10);
				} else {
					answer = answer * B + (c-'0');
				}
				System.out.println(answer);
				 */
			}
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = st.nextToken();
				B = Integer.parseInt(st.nextToken());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2745();
	}
}
