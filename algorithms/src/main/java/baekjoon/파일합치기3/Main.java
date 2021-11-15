package baekjoon.파일합치기3;
import java.io.*;
import java.util.*;
public class Main {
	static class P13975 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int T, K;
		PriorityQueue<Long> file, cost;
		P13975() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void solve() {
			cost = new PriorityQueue<>();
			for(int k=0; k<K-1; k++) {
				long min = file.poll();
				min += file.poll();
				file.add(min);
				cost.add(min);
			}
			long sum = 0;
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
						file.add(Long.parseLong(st.nextToken()));
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