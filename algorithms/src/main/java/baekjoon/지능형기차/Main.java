package baekjoon.지능형기차;
import java.io.*;
import java.util.*;
public class Main {
	static class P2455 {
		BufferedReader br;
		StringTokenizer st;
		int train[][];
		P2455() {
			train = new int[4][2];
			input();
			solve();
		}
		void solve() {
			int sum = 0, max = 0;
			for(int i=0; i<4; i++) {
				sum = sum - train[i][0] + train[i][1];
				max = Math.max(max, sum);
			}
			System.out.println(max);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				for(int i=0; i<4; i++) {
					st = new StringTokenizer(br.readLine());
					train[i][0] = Integer.parseInt(st.nextToken());
					train[i][1] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2455();
	}
}
