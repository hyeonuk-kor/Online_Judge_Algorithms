package baekjoon.컬러볼;
import java.io.*;
import java.util.*;
public class Main {
	static class P10800 {
		BufferedReader br;
		PrintWriter pw;
		StringTokenizer st;
		class Ball implements Comparable<Ball>{
			int number, color, size;
			Ball(int number, int color, int size) {
				this.number = number;
				this.color = color;
				this.size = size;
			}
			@Override
			public int compareTo(Ball o) {
				if(this.size==o.size)
					return Integer.compare(this.color, o.color);
				return Integer.compare(this.size, o.size);
			}
			@Override
			public String toString() {
				return " Ball [ number=" + number + ", color=" + color + ", size=" + size + "] \n";
			}
			
		}
		int n, colors[], users[];
		Ball balls[];
		P10800() {
			input();
			solve();
			output();
		}
		void output() {
			pw = new PrintWriter(new OutputStreamWriter(System.out));
			for(int i=0; i<n; i++)
				pw.println(users[i]);
			pw.flush();
		}
		void solve() {
			Arrays.sort(balls);
			colors = new int[n+1];
			users = new int[n+1];
			int sum = 0, r = 0;
			for(int l=0; l<n; l++) {
				Ball a = balls[l];
				Ball b = balls[r];
				while(b.size < a.size) {
					sum += b.size;
					colors[b.color] += b.size;
					b = balls[++r];
				}
				users[a.number-1] = sum - colors[a.color];
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				n = Integer.parseInt(br.readLine());
				balls = new Ball[n];
				for(int i=0; i<n; i++) {
					st = new StringTokenizer(br.readLine());
					int color = Integer.parseInt(st.nextToken());
					int size = Integer.parseInt(st.nextToken());
					balls[i] = new Ball(i+1, color, size);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P10800();
	}
}
