package baekjoon.파일합치기3;
import java.io.*;
import java.util.*;
public class Main {
	static class P13975 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int T, K;
		PriorityQueue<Integer> file, cost;
		P13975() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void solve() {
			cost = new PriorityQueue<>();
			for(int k=0; k<K-1; k++) {
				int min = file.poll();
				min += file.poll();
				file.add(min);
				cost.add(min);
			}
			int sum = 0;
			while(!cost.isEmpty())
				sum += cost.poll();
			sb.append(sum).append('\n');
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				T = Integer.parseInt(br.readLine());
				for(int tc=1; tc<=T; tc++) {
					K = Integer.parseInt(br.readLine());
					st = new StringTokenizer(br.readLine().trim());
					file = new PriorityQueue<>();
					for(int k=0; k<K; k++)
						file.add(Integer.parseInt(st.nextToken()));
					solve();
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P13975();
	}
}