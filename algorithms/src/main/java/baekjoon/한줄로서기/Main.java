package baekjoon.한줄로서기;
import java.io.*;
import java.util.*;
public class Main {
	static class P1138 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, people[];
		P1138() {
			input();
			sb = new StringBuilder();
			solve();
		}
		void solve() {
			List<Integer> list = new ArrayList<>();
			for(int i=N; i>=1; i--) {
				list.add(people[i], i);
			}
			for(int n: list) {
				sb.append(n).append(' ');
			}
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				people = new int[N+1];
				st = new StringTokenizer(br.readLine().trim());
				for(int i=1; i<=N; i++) {
					people[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1138();
	}
}