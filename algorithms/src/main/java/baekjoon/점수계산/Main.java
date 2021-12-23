package baekjoon.점수계산;
import java.io.*;
import java.util.*;
public class Main {
	static class P2506 {
		BufferedReader br;
		StringTokenizer st;
		int N, arr[];
		P2506() {
			input();
			solve();
		}
		void solve() {
			int sum = 0;
			int temp = 0;
			for(int i=0; i<N; i++) {
				if(arr[i]==0) {
					temp = 0;
				} else {
					temp++;
				}
				sum += temp;
			}
			System.out.println(sum);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine().trim());
				arr = new int[N];
				for(int n=0; n<N; n++) {
					arr[n] = Integer.parseInt(st.nextToken());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P2506();
	}
}