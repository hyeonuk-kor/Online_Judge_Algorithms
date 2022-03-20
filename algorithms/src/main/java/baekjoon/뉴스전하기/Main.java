package baekjoon.뉴스전하기;
import java.io.*;
import java.util.*;
public class Main {
	static class P1135 {
		BufferedReader br;
		StringTokenizer st;
		int N;
		List<List<Integer>> tree;
		P1135() {
			input();
			System.out.println(dfs(0));
		}
		int dfs(int x) {
			int ret = 0;
			List<Integer> subTree = new ArrayList<>();
			for(int y: tree.get(x))
				subTree.add(dfs(y));
			Collections.sort(subTree, Comparator.reverseOrder());
			for(int i=0;i<subTree.size(); i++)
				ret = Math.max(ret, subTree.get(i)+i+1);
			return ret;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				tree = new ArrayList<>();
				for(int n=0; n<N; n++) {
					tree.add(new ArrayList<>());
				}
				st = new StringTokenizer(br.readLine().trim()); // 공백처리 1 2 4 5
				int x = Integer.parseInt(st.nextToken()); // -1 처리
				for(int n=1; n<N; n++) {
					x = Integer.parseInt(st.nextToken());
					tree.get(x).add(n);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1135();
	}
}
