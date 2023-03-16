package baekjoon.다오와디지니의데이트;
import java.io.*;
import java.util.*;
public class Main {
	static class P20553 {
		int N, T;
		long answer, h[], d[], p[];
		P20553() {
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			for(int i=1; i<N; i++) {
				if(i<=T/2) {
					answer = Math.max(answer, p[i-1]+d[i]*(T/2+1-i));
				}
			}
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				h = new long[N+1];
				d = new long[N+1];
				p = new long[N+1];
				st = new StringTokenizer(br.readLine());
				for(int i=1; i<=N; i++) {
					h[i] = Integer.parseInt(st.nextToken());
				}
				for(int i=1; i<N; i++) {
					d[i] = h[i] + h[i+1];
					p[i] = p[i-1] + d[i];
				}
//				System.out.println("d : " + Arrays.toString(d));
//				System.out.println("p : " + Arrays.toString(p));
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P20553();
	}
}
