package baekjoon.공;
import java.io.*;
import java.util.*;
public class Main {
	static class P1547 {
		BufferedReader br;
		StringTokenizer st;
		List<Boolean> ball;
		int answer;
		P1547() {
			ball = new ArrayList<>();
			ball.add(true);
			ball.add(false);
			ball.add(false);
			input();
			solve();
			System.out.println(answer);
		}
		void solve() {
			for(int i=0; i<ball.size(); i++) {
				if(ball.get(i)) {
					answer = i+1;
					return;
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int M = Integer.parseInt(br.readLine());
				for(int m=0; m<M; m++) {
					st = new StringTokenizer(br.readLine().trim());
					int X = Integer.parseInt(st.nextToken())-1;
					int Y = Integer.parseInt(st.nextToken())-1;
					Collections.swap(ball, X, Y);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1547();
	}
}