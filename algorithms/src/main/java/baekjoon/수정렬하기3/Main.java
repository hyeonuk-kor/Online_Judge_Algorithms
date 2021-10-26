package baekjoon.수정렬하기3;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static class P10989 {
		StringBuilder sb;
		int N, arr[] = new int[10001];
		void solve() {
			input();
			sb = new StringBuilder();
			try {
				for(int i=1; i<=10000; i++)
					for(int j=0; j<arr[i]; j++)
						bw.append(i+"\n");
				bw.flush();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		void input() {
			try {
				N = Integer.parseInt(br.readLine());
				for(int i=1; i<=N; i++) {
					int n = Integer.parseInt(br.readLine());
					arr[n]++;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		new P10989().solve();
	}
}