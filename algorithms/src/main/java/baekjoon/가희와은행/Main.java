package baekjoon.가희와은행;
import java.io.*;
import java.util.*;
public class Main {
	static class P22234 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, T, W, M;
		Deque<int[]> wait_q;
		PriorityQueue<int[]> after_q;
		P22234() {
			wait_q = new ArrayDeque<>();
			after_q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
			});
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			int id = wait_q.peek()[0];
			int time = wait_q.peek()[1];
			int tp=Math.min(T, time);
			for(int t=0; t<W; t++) {
				if(!after_q.isEmpty() && after_q.peek()[0]-1==t) {
					wait_q.addLast(new int[] {after_q.peek()[1], after_q.peek()[2]});
					after_q.poll();
				}
				sb.append(id).append('\n');
				tp--;
				time--;
				if(tp==0) {
					wait_q.poll();
					if(time>0) {
						wait_q.addLast(new int[] {id, time});
					}
					if(!wait_q.isEmpty()) {
						id = wait_q.peek()[0];
						time = wait_q.peek()[1];
						tp = Math.min(T, time);
					}
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				W = Integer.parseInt(st.nextToken());
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int px = Integer.parseInt(st.nextToken());
					int tx = Integer.parseInt(st.nextToken());
					wait_q.add(new int[] {px, tx});
				}
				M = Integer.parseInt(br.readLine());
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine().trim());
					int px = Integer.parseInt(st.nextToken());
					int tx = Integer.parseInt(st.nextToken());
					int cx = Integer.parseInt(st.nextToken());
					after_q.add(new int[] {cx, px, tx});
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P22234();
	}
}