package baekjoon.시간관리하기;
import java.io.*;
import java.util.*;
public class Main {
	static class Work implements Comparable<Work>{
		int t, s;
		public Work(int t, int s) {
			this.t = t;
			this.s = s;
		}
		@Override
		public int compareTo(Work o) {
			return Integer.compare(o.s, this.s);
		}
		@Override
		public String toString() {
			return "Work [t=" + t + ", s=" + s + "]\n";
		}
	}
	static class P6068 {
		int N, answer;
		Work work[];
		P6068() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			Arrays.sort(work);
//			System.out.println(Arrays.toString(work));
			for(int i=0; i<N-1; i++) {
				int calc = work[i].s - work[i].t;
				work[i+1].s = Math.min(calc, work[i+1].s);
			}
//			System.out.println(Arrays.toString(work));
			answer = work[N-1].s - work[N-1].t;
			if(answer<0)
				answer = -1;
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				work = new Work[N];
				StringTokenizer st = null;
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine());
					int t = Integer.parseInt(st.nextToken());
					int s = Integer.parseInt(st.nextToken());
					work[i] = new Work(t, s);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P6068();
	}
}
