package baekjoon.부분합;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P1806 {
		BufferedReader br;
		StringTokenizer st;
		int N, S, arr[];
		P1806() {
			input();
			solve();
		}
		void solve() {
			int right = 0;
			int sum = 0;
			int min = N+1;
			for(int left=1; left<=N; left++) {
				sum -= arr[left-1];
				while(right+1<=N && sum<S) {
					right++;
					sum += arr[right];
				}
				if(sum>=S)
					min = Math.min(min, right-left+1);
			}
			if(min==N+1)
				min = 0;
			System.out.println(min);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				S = Integer.parseInt(st.nextToken());
				arr = new int[N+1];
				st = new StringTokenizer(br.readLine().trim());
				for(int i=1; i<=N; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1806();
	}
}
