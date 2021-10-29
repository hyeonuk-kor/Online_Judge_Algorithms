package baekjoon.용액;
import java.io.*;
import java.util.*;
class Main {
	static class P2467 {
		BufferedReader br;
		StringTokenizer st;
		int N, A[];
		P2467() {
			br = new BufferedReader(new InputStreamReader(System.in));
			input();
			solve();
		}
		void solve() {
			Arrays.sort(A, 1, N+1);
			int best_sum = Integer.MAX_VALUE;
			int v1 = 0, v2 = 0;
			for(int left = 1; left<=N-1; left++) {
				int candidate = lower_bound(A, left+1, N, -A[left]);
				// 후보 1. A[left] + A[candidate-1]
				if(left<candidate-1 && Math.abs(A[left]+A[candidate-1]) <= best_sum) {
					best_sum = Math.abs(A[left]+A[candidate-1]);
					v1 = A[left];
					v2 = A[candidate - 1];
				}
				// 후보 2. A[left] + A[candidate]
				if(candidate <= N && Math.abs(A[left]+A[candidate]) <= best_sum) {
					best_sum = Math.abs(A[left]+A[candidate]);
					v1 = A[left];
					v2 = A[candidate];
				}
			}
			System.out.println(v1+" "+v2);
		}
		int lower_bound(int[] A, int L, int R, int target) {
			int res = R+1;
			while(L<=R) {
				int mid = (L+R) >> 1;
				if(A[mid]>=target) {
					res = mid;
					R = mid - 1;
				} else {
					L = mid + 1;
				}
			}
			return res;
		}
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				A = new int[N+1];
				st = new StringTokenizer(br.readLine().trim());
				for(int i=1; i<=N; i++) {
					A[i] = Integer.parseInt(st.nextToken());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2467();
	}
}
