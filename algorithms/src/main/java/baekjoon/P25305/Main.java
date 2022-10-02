package baekjoon.P25305;
import java.io.*;
import java.util.*;
public class Main {
	static class P25305 {
		BufferedReader br;
		StringTokenizer st;
		int N, K, score[];
		P25305() {
			input();
			solve();
		}
		void solve() {
			Arrays.sort(score);
			System.out.println(score[N-K]);
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				score = new int[N];
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++)
					score[i] = Integer.parseInt(st.nextToken());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P25305();
	}
}