package baekjoon.좋다;
import java.io.*;
import java.util.*;
public class Main {
	static int N, A[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		Arrays.sort(A, 1, N+1);
		int ans = 0;
		for(int i=1; i<=N; i++) {
			if(func(i)) // i번째 원소가 두 수의 합으로 표현이 되나?
				ans++;
		}
		System.out.println(ans);
	}
	static boolean func(int i) {
		int L = 1, R = N;
		int target = A[i];
		while(L<R) {
			if(L==i) L++;
			else if(R==i) R--;
			else {
				int sum = A[L] + A[R];
				if(sum==target) {
					return true;
				} else if(sum > target) {
					R--;
				} else {
					L--;
				}
			}
		}
		return false;
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			A = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
