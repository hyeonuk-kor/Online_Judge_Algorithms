package baekjoon.약수구하기;
import java.io.*;
import java.util.*;
public class Main {
	static class P2501 {
		BufferedReader br;
		StringTokenizer st;
		int N, K, answer;
		P2501() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			int count = 0;
			for(int i=1; i<=N; i++) {
				if(N%i==0) count++;
				if(count==K) {
					answer = i;
					return;
				}
			}
			answer = 0;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2501();
	}
}