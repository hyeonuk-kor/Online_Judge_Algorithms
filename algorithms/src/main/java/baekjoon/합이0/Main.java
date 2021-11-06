package baekjoon.합이0;
import java.io.*;
import java.util.*;
public class Main {
	static class P3151 {
		BufferedReader br;
		StringTokenizer st;
		int N, A[];
		P3151() {
			input();
			solve();
		}
		void solve() {
			long answer = 0;
			Arrays.sort(A, 1, N+1);
			for(int i=1; i<=N-2; i++) {
				int target = -A[i]; // A[i] 선택
				int left = i+1, right = N;
				while(left<right) { // A[left]+A[right]가 -A[i](target)을 찾으면 0에 가까울 것이다.
					if(A[left]+A[right] > target) {
						right--;
					} else {
						int sum = A[left] + A[right] - target;
						if(sum==0) {
							if(A[left]==A[right]) {
								answer += right - left;
							} else {
								int find = A[right];
								int l = left;
								int r = right;
								int res = right + 1;
								while(l<=r) {
									int mid = (l+r)/2;
									if(A[mid]>=find) {
										res = mid;
										r = mid - 1;
									} else {
										l = mid + 1;
									}
								}
								answer += right - res + 1;
							}
						}
						left++;
					}
				}
			}
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine().trim());
				A = new int[N+1];
				for(int i=1; i<=N; i++) {
					A[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P3151();
	}
}
