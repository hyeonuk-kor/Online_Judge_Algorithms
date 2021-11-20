package baekjoon.별찍기10;
import java.io.*;
public class Main {
	static class P2447 {
		BufferedReader br;
		StringBuilder sb;
		int N;
		P2447() {
			input();
			sb = new StringBuilder();
			solve();
			System.out.println(sb);
		}
		void solve() {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					draw(i, j, N);
				}
				sb.append('\n');
			}
		}
		void draw(int y, int x, int size) {
			if(size==0) {
				sb.append('*');
			} else {
				if((y/size)%3==1 && (x/size)%3==1) {	// y와 x가 [큰 영역과 작은 영역에서] (1, 1)에 해당될 때 빈칸
					sb.append(' ');
				} else {
					draw(y, x, size/3);	// size==0이 될 때 * 찍힌다.
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2447();
	}
}