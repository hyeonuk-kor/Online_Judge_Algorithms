package baekjoon.날짜계산;
import java.io.*;
import java.util.*;
class Main {
	static class P1476 {
		BufferedReader br;
		StringTokenizer st;
		int E, S, M;
		P1476() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			solve();
		}
		void solve() {
			int count = 1;
			int e = 1, s = 1, m = 1;
			while(!check(e, s, m)) {
				e=e%15+1; s=s%28+1; m=m%19+1;
				count++;
			}
			System.out.println(count);
		}
		boolean check(int e, int s, int m) {
			return e==E && s==S && m==M;
		}
		void input() {
			try {
				st = new StringTokenizer(br.readLine().trim());
				E = Integer.parseInt(st.nextToken());
				S = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1476();
	}
}
