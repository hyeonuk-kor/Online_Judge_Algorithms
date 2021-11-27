package baekjoon.가장긴바이토닉부분수열;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P11054 {
		BufferedReader br;
		StringTokenizer st;
		int n, arr[];
		P11054() {
			input();
			solve();
		}
		void solve() {
			int L[] = new int[n+1];
			int R[] = new int[n+1];
			L[1] = 0;
			for(int i=2; i<=n; i++) {
				if(arr[i]>arr[i-1])
					L[i] = L[i-1] + 1;
			}
			R[n] = 0;
			for(int i=n-1; i>=1; i--) {
				if(arr[i]>arr[i+1])
					R[i] = R[i+1] + 1;
			}
			System.out.println(Arrays.toString(L));
			System.out.println(Arrays.toString(R));
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				n = Integer.parseInt(br.readLine());
				arr = new int[n+1];
				st = new StringTokenizer(br.readLine().trim());
				for(int i=1; i<=n; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P11054();
	}
}
