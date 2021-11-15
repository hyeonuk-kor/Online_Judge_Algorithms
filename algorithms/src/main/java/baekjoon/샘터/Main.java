package baekjoon.샘터;
import java.io.*;
import java.util.*;
public class Main {
	static class P18513 {
		BufferedReader br;
		StringTokenizer st;
		int N, K, dir[] = {-1, 1};
		Set<Integer> visit;
		Queue<int[]> q;
		long answer;
		P18513() {
			visit = new HashSet<>();
			q = new ArrayDeque<>();
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			int house = 0;
			while(!q.isEmpty()) {
				int x = q.peek()[0];
				int dist = q.poll()[1];
				for(int d=0; d<2; d++) {
					int nx = x + dir[d];
					int move = dist + 1;
					if(nx<0 || nx>=(int)4e8 || visit.contains(nx))
						continue;
					answer+=move;
					house++;
					if(house==K) {
						return;
					} else {
						q.add(new int[] {nx, move});
						visit.add(nx);
					}
				}
			}
			answer = -1;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(br.readLine().trim());
				for(int n=0; n<N; n++) {
					int x = Integer.parseInt(st.nextToken()) + (int)2e8;
					q.add(new int[] {x, 0});
					visit.add(x);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P18513();
	}
}