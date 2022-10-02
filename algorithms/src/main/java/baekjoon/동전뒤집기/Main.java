package baekjoon.동전뒤집기;
import java.io.*;
public class Main {
	static class P1285 {
		BufferedReader br;
		boolean[][] coin;
		int N, answer;
		P1285() {
			input();
			solve(0);
			System.out.println(answer);
		}
		void solve(int row) {
			if(row==N) {
				int count = 0;
				for(int i=0; i<N; i++) {
					int t = 0;
					for(int j=0; j<N; j++)
						if(coin[i][j])
							t++;
					count += Math.min(t, N-t);
				}
				answer = Math.min(answer, count);
				return;
			}
			solve(row+1);
			for(int i=0; i<N; i++)
				coin[i][row] = !coin[i][row];
			solve(row+1);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				answer = N*N;
				coin = new boolean[N][N];
				for(int i=0; i<N; i++) {
					String input = br.readLine();
					for(int j=0; j<input.length(); j++) {
						if(input.charAt(j)=='T')
							coin[i][j] = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1285();
	}
}
