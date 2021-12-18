package baekjoon.수이어쓰기1;
import java.io.*;
public class Main {
	static class P1748 {
		BufferedReader br;
		String N;
		P1748() {
			input();
			solve();
		}
		void solve() {
			/*
			 * 1~9     1*10^0*9
			 * 10~99   2*10^1*9
			 * 100~999 3*10^2*9
			 * ...   3
			 * 1e8   9
			 * 233 -> 1~9 (9개*1자리) + 10~99 (90개*2자리) + 100~233 (134개*3자리)
			 */
			int answer = 0;
			for(int i=1; i<N.length(); i++)
				answer += (i*Math.pow(10, i-1)*9);
			int count = Integer.parseInt(N) - (int)Math.pow(10, N.length()-1) + 1;
			answer += (count*N.length());
			System.out.println(answer);
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
		new P1748();
	}
}