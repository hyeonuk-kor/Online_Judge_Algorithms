package baekjoon.수정렬하기2;
import java.io.*;
public class Main {
	static class P2751 {
		BufferedReader br;
		StringBuilder sb;
		int N;
		int arr[];
		void solve() {
			input();
			sb = new StringBuilder();
			for(int i=0; i<=2000000; i++)
				if(arr[i]==1)
					sb.append(i-1000000).append('\n');
			System.out.println(sb);
		}
		
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				N = Integer.parseInt(br.readLine());
				arr = new int[2000001];
				for(int i=1; i<=N; i++) {
					int n = Integer.parseInt(br.readLine())+1000000;
					arr[n] = 1;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		new P2751().solve();
	}
}
