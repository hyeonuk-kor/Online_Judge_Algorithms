package baekjoon.대회or인턴;
import java.io.*;
import java.util.*;
public class Main {
	static class P2875 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, K;
		P2875() {
			input();
			solve();
		}
		void solve() {
			int answer = 0;
			for(int k=0; k<=K; k++) {
				int boy = N-k;
				int girl = M-(K-k);
				int team = Math.min(boy/2, girl);
				answer = Math.max(team, answer);
			}
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2875();
	}
}
