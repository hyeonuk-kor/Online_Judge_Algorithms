package baekjoon.좌표압축;
import java.io.*;
import java.util.*;
public class Main {
	static class P18870 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N, X_prime[];
		TreeSet<Integer> set = new TreeSet<>();
		void solve() {
			input();
			int X[] = new int[set.size()+1];
			int index = 1;
			for(int n: set) {
				X[index++] = n;
			}
			for(int i=1; i<=N; i++) {
				X_prime[i] = lower_bound(X, 1, set.size(), X_prime[i]);
				sb.append(X_prime[i]).append(' ');
			}
			System.out.println(sb.toString());
		}
		private int lower_bound(int[] X, int L, int R, int K) {
			int res = L-1;
			while(L<=R) {
				int mid = (L+R)/2;
				if(X[mid]<K) {
					L = mid + 1;
					res = mid;
				} else {
					R = mid - 1;
				}
			}
			return res;
		}
		private void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				N = Integer.parseInt(br.readLine());
				X_prime = new int[N+1];
				st = new StringTokenizer(br.readLine());
				for(int i=1; i<=N; i++) {
					X_prime[i] = Integer.parseInt(st.nextToken());
					set.add(X_prime[i]);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		new P18870().solve();
	}
}