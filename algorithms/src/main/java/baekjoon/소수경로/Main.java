package baekjoon.소수경로;
import java.io.*;
import java.util.*;
public class Main {
	static class P1963 {
		StringBuilder sb = new StringBuilder();
		int N;
		String tc[][];
		boolean visit[];
		String solve() {
			input();
			for(int t=1; t<=N; t++) {
				visit = new boolean[10000];
				String from = tc[t][0];
				String to = tc[t][1];
				bfs(from, to);
				sb.append('\n');
			}
			return sb.toString();
		}
		void bfs(String from, String to) {
			Queue<String> q = new ArrayDeque<>();
			int answer = 0;
			if(from.equals(to)) {
				sb.append(answer);
				return;
			} else {
				q.add(from);
				q.add("0");
				visit[Integer.parseInt(from)] = true;
				while(!q.isEmpty()) {
					String str = q.poll();
					int step = Integer.parseInt(q.poll());
					if(str.equals(to)) {
						sb.append(step);
						return;
					}
					for(int i=0; i<4; i++) {
						StringBuilder number = new StringBuilder(str);
						for(char j='0'; j<='9'; j++) {
							number.setCharAt(i, j);
							String next = number.toString();
							if(isPossible(next)) {
								q.add(next);
								q.add((step+1)+"");
								visit[Integer.parseInt(next)] = true;
							}
						}
					}
				}
			}
		}
		boolean isPossible(String next) {
			int number = Integer.parseInt(next);
			if(number<1000)
				return false;
			if(visit[number])
				return false;
			if(!isPrime(number))
				return false;
			return true;
		}
		boolean isPrime(int number) {
			for(int i=2; i<number; i++) {
				if(number%i==0)
					return false;
			}
			return true;
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = null;
			try {
				N = Integer.parseInt(br.readLine());
				tc = new String[N+1][2];
				for(int i=1; i<=N; i++) {
					st = new StringTokenizer(br.readLine());
					tc[i][0] = st.nextToken();
					tc[i][1] = st.nextToken();
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P1963().solve());
	}
}