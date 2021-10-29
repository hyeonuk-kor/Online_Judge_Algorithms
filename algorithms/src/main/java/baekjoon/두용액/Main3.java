package baekjoon.두용액;
import java.io.*;
import java.util.*;
public class Main3 {
	static class P2470 {
		BufferedReader br;
		StringTokenizer st;
		static int N, A[];
		void solve() {
			input();
			int sum = Integer.MAX_VALUE;
			int a=0, b=0;
			int left = 0, right = N-1;
			while(left<right) {
				int calc = A[left]+A[right];
				if(Math.abs(calc)<=sum) {
					sum = Math.abs(calc);
					a = A[left];
					b = A[right];
				}
				if(calc<0) {
					left++;
				} else {
					right--;
				}
			}
			System.out.println(a+" "+b);
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				N = Integer.parseInt(br.readLine());
				A = new int[N];
				st = new StringTokenizer(br.readLine().trim());
				for(int i=0; i<N; i++) {
					A[i] = Integer.parseInt(st.nextToken());
				}
				Arrays.sort(A);
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		new P2470().solve();
	}
}