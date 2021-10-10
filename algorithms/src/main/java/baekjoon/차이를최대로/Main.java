package baekjoon.차이를최대로;
import java.io.*;
import java.util.*;
public class Main {
	static class P10819 {
		int N, A[], select[], answer;
		boolean check[];
		int solve() {
			input();
			rec_func(1);
			return answer;
		}
		void rec_func(int depth) {
			if(depth==N+1) {
				int sum = 0;
				for(int i=1; i<N; i++) {
					sum += Math.abs(select[i]-select[i+1]);
				}
				answer = Math.max(answer, sum);
				return;
			} else {
				for(int i=1; i<=N; i++) {
					if(!check[i]) {
						check[i] = true;
						select[depth] = A[i];
						rec_func(depth+1);
						select[depth] = 0;
						check[i] = false;
					}
				}
			}
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			try {
				N = Integer.parseInt(br.readLine());
				A = new int[N+1];
				select = new int[N+1];
				check = new boolean[N+1];
				st = new StringTokenizer(br.readLine());
				for (int i=1; i<=N; i++) {
					A[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}				
		}
	}
	public static void main(String[] args) {
		System.out.println(new P10819().solve());
	}
}