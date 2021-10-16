package baekjoon.나무조각;
import java.io.*;
import java.util.*;
public class Main {
	static class P2947 {
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		StringTokenizer st;
		int tree[];
		String solve() {
			input();
			for(int j=0; j<5; j++) {
				for(int i=0; i<4; i++) {
					if(tree[i] > tree[i+1]) {
						int temp = tree[i];
						tree[i] = tree[i+1];
						tree[i+1] = temp;
						print();
					}
				}
			}
			return sb.toString();
		}
		private void print() {
			for(int i=0; i<5; i++)
				sb.append(tree[i]).append(' ');
			sb.append('\n');
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				tree = new int[5];
				for(int i=0; i<5; i++) {
					tree[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P2947().solve());
	}
}