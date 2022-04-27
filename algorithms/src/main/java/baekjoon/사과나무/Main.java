package baekjoon.사과나무;
import java.io.*;
import java.util.*;
public class Main {
	static class P2233 {
		BufferedReader br;
		StringTokenizer st;
		int N, X, Y;
		int parent[][], depth[], node[];
		char[] binary_tree;
		P2233() {
			input();
			makeTree();
		}
		void makeTree() {
			int tree_height = (int)Math.ceil(baseLog(N, 2));
			parent = new int[N+1][tree_height+1];
			depth = new int[N+1];
			node = new int[2*N*1];
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				binary_tree = br.readLine().toCharArray();
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		double baseLog(double x, double base) {
			return Math.log(x) / Math.log(base);
		}
	}
	public static void main(String[] args) {

	}
}
