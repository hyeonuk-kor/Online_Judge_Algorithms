package baekjoon.P10610;
import java.io.*;
import java.util.*;
public class Main {
	static class P10610 {
		BufferedReader br;
		String N;
		P10610() {
			input();
			solve(N.toCharArray());
		}
		void solve(char[] cstr) {
			StringBuilder sb = new StringBuilder();
			Arrays.sort(cstr);
			if(cstr[0]!='0') {
				System.out.println(-1);
			} else {
				long sum = 0;
				for(int i=0; i<cstr.length; i++) {
					sum += cstr[i]-'0';
					sb.append(cstr[i]);
				}
				if(sum%3==0)
					System.out.println(sb.reverse());
				else
					System.out.println(-1);
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = br.readLine();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10610();
	}
}
