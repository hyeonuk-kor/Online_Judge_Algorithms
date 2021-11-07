package baekjoon.골드바흐의추측;
import java.io.*;
import java.util.*;
public class Main {
	static class P9020 {
		BufferedReader br;
		StringTokenizer st;
		ArrayList<Integer> tc;
		StringBuilder sb;
		boolean prime[];
		P9020() {
			prime = new boolean[10001];
			initialize();
			tc = new ArrayList<>();
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			for(int n: tc) {
				int left = n/2, right = n/2;
				String answer = null;
				while(left>=2 && right<n) {
					if(prime[left] && prime[right]) {
						answer = left + " " + right;
						break;
					} else {
						left--;
						right++;
					}
				}
				sb.append(answer).append('\n');
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int T = Integer.parseInt(br.readLine());
				for(int t=1; t<=T; t++)
					tc.add(Integer.parseInt(br.readLine()));
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void initialize() {
			for(int i=2; i<prime.length; i++) {
				prime[i] = true;
			}
			for(int i=2; i*i<prime.length; i++) {
				if(prime[i]) {
					for(int j=i*i; j<prime.length; j+=i) {
						prime[j] = false;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new P9020();
	}
}