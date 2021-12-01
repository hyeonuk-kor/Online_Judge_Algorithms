package baekjoon.P23794;
import java.io.*;
import java.util.*;
public class Main {
	static class P23794 {
		BufferedReader br;
		StringBuilder sb;
		int N;
		P23794() {
			input();
			sb = new StringBuilder();
			pro();
			System.out.println(sb);
		}
		void pro() {
			for(int i=0; i<=N+1; i++) {
				if(i==0 || i==N+1) {
					for(int j=0; j<=N+1; j++)
						sb.append("@");
				} else {
					sb.append('@');
					for(int j=1; j<=N; j++)
						sb.append(' ');
					sb.append('@');
				}
				sb.append('\n');
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P23794();
	}
}