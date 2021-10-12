package baekjoon.소수경로;
import java.io.*;
import java.util.*;
public class Main {
	static class P1963 {
		StringBuilder sb = new StringBuilder();
		int N;
		int tc[][];
		boolean visit[];
		String solve() {
			input();
			for(int t=1; t<=N; t++) {
				visit = new boolean[100001];
				int from = tc[t][0];
				int to = tc[t][1];
				int answer= bfs(from, to);
				if(answer==-1)
					System.out.println("Impossible\n");
				else
					sb.append(answer+"\n");
			}
			return sb.toString();
		}
		int conv(int[] array) {
			int res = 0;
			for(int i=0; i<4; i++) {
				res = res*10+array[i];
			}
			return res;
		}
		int[] inv_conv(int x) {
			int array[] = new int[4];
			for(int i=3; i>=0; i--) {
				array[i] = x%10;
				x/=10;
			}
			return array;
		}
		int bfs(int from, int to) {
			Queue<Integer> q = new ArrayDeque<>();
			q.add(from);
			q.add(0);
			visit[from] = true;
			while(!q.isEmpty()) {
				int number = q.poll();
				int step = q.poll();
				if(number==to) {
					return step;
				}
				for(int i=0; i<4; i++) {
					int[] digit = inv_conv(number);
					for(int j=0; j<=9; j++) {
						digit[i] = j;
						int next = conv(digit);
						if(isPossible(next)) {
							q.add(next);
							q.add(step+1);
							visit[next] = true;
						}
					}
				}
			}
			return -1;
		}
		boolean isPossible(int number) {
			if(number<1000)
				return false;
			if(visit[number])
				return false;
			if(!isPrime(number))
				return false;
			return true;
		}
		boolean isPrime(int number) {
			for(int i=2; i*i<number; i++) {
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
				tc = new int[N+1][2];
				for(int i=1; i<=N; i++) {
					st = new StringTokenizer(br.readLine());
					tc[i][0] = Integer.parseInt(st.nextToken());
					tc[i][1] = Integer.parseInt(st.nextToken());
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