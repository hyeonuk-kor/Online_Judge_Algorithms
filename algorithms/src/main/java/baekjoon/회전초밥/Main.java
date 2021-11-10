package baekjoon.회전초밥;
import java.io.*;
import java.util.*;
public class Main {
	static class P2531 {
		BufferedReader br;
		StringTokenizer st;
		int N, d, k, c, belt[], sushi[];
		P2531() {
			input();
			solve();
		}
		void solve() {
			sushi = new int[d+1];
			int right = 0, answer = 0, eat = 0;
			for(int left=0; left<N; left++) {
				while(right<left+k) {
					if(sushi[belt[right]]==0) {
						eat++;
					}
					sushi[belt[right]]++;
					right++;
				}
				answer = Math.max(answer, sushi[c]==0?eat+1:eat);
				sushi[belt[left]]--;
				if(sushi[belt[left]]==0)
					eat--;
			}
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				k = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				belt = new int[N+k];
				for(int i=0; i<N; i++)
					belt[i] = Integer.parseInt(br.readLine());
				for(int i=N; i<N+k; i++)
					belt[i] = belt[i-N];
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2531();
	}
}