package baekjoon.물통;
import java.io.*;
import java.util.*;
public class Main {
	static int size[]; // 0: A, 1: B, 2: C 물통의 크기
	static boolean possible[], visit[][][];
	static StringBuilder sb = new StringBuilder();
	static class State {
		int[] X; //A, B, C 물통의 상태
		State(int[] _X) {
			X = new int[3];
			for(int i=0; i<3; i++) {
				X[i] = _X[i];
			}
		}
		State move(int from, int to) { //from -> to
			int[] water = new int[] {X[0], X[1], X[2]}; // 현재 물통의 물의 양
			if(X[from]+X[to] <= size[to]) { //FROM을 전부 TO로 옮길 수 있어? 
				water[to] = water[from] + water[to];
				water[from] = 0;
			} else {
				water[from] =  water[from] - (size[to] - water[to]);
				water[to] = size[to];
			}
			return new State(water);
		}
	}
	static class P2251 {
		String Solve() {
			input();
			//bfs(0, 0, size[2]);
			dfs(0, 0, size[2]);
			for(int i=0; i<possible.length; i++) {
				if(possible[i])	
					sb.append(i).append(' ');
			}
			return sb.toString();
		}
		void dfs(int A, int B, int C) {
			if(visit[A][B][C])
				return;
			visit[A][B][C] = true;
			State now = new State(new int[] {A,B,C});
			if(A==0)
				possible[C] = true;
			for(int from=0; from<3; from++) {
				for(int to=0; to<3; to++) {
					if(from==to) continue;
					State next = now.move(from, to);
					dfs(next.X[0], next.X[1], next.X[2]);
				}
			}
		}
		void bfs(int A, int B, int C) { // A, B, C에 있는 현재 물의 양
			Queue<State> q = new ArrayDeque<>();
			q.add(new State(new int[] {A,B,C}));
			visit[A][B][C] = true; // 현재 물의 양은 더 이상 탐색할 필요가 없다.
			while (!q.isEmpty()) {
				State now = q.poll();
				if(now.X[0]==0) // A 물통이 비었다면
					possible[now.X[2]] = true; // C물통의 양을 기록해둔다.
				for(int from=0; from<3; from++) {
					for(int to=0; to<3; to++) {
						if(from==to) continue;
						State next = now.move(from, to);
						if(!visit[next.X[0]][next.X[1]][next.X[2]]) { //처음 탐색?
							visit[next.X[0]][next.X[1]][next.X[2]] = true;
							q.add(next);
						}
					}
				}
			}
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				size = new int[3];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i=0; i<3; i++) {
					size[i] = Integer.parseInt(st.nextToken());
				}
				visit = new boolean[201][201][201];
				possible = new boolean[201];
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P2251().Solve());
	}
}