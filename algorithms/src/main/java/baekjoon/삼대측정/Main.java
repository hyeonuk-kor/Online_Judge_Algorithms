package baekjoon.삼대측정;
import java.io.*;
import java.util.*;
public class Main {
	static class P20299 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, K, L;
		List<List<Integer>> team;
		void solve() {
			input();
			int count = 0;
			sb = new StringBuilder();
			for(List<Integer> list: team) {
				int x1 = list.get(0);
				int x2 = list.get(1);
				int x3 = list.get(2);
				if(x1<L || x2<L || x3<L) // 팀원 중 한명이라도 L보다 작다면 안됨
					continue;
				if(x1+x2+x3 < K)            // 팀원 모두의 합이 K보다 작다면 안됨.
					continue;
				count++;        // 이외의 경우 출력해주면 됨.
				sb.append(x1).append(' ').append(x2).append(' ').append(x3).append(' ');
			}
			System.out.println(count+"\n"+sb);
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				team = new ArrayList<>();
				for(int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine().trim());
					team.add(new ArrayList<>());
					team.get(i).add(Integer.parseInt(st.nextToken()));
					team.get(i).add(Integer.parseInt(st.nextToken()));
					team.get(i).add(Integer.parseInt(st.nextToken()));
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P20299().solve();
	}
}