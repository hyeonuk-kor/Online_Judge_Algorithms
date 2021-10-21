package swexperts.홈방범서비스;
import java.io.*;
import java.util.*;
public class Solution {
	static int N, M, board[][], answer;
	static boolean visit[][] = new boolean[20][20];
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			answer = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int k=1; k<=N+1; k++) {
						answer = Math.max(answer, rhombus(i, j, k));
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	static int rhombus(int i, int j, int k) { // bfs로 마름모 구현
		q.add(new int[] {i, j, 1});
		visit[i][j] = true;
		int home = 0;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int y = info[0];
			int x = info[1];
			int distance = info[2];
			if(board[y][x]==1)
				home++;
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(ny<0 || nx<0 || ny>=N || nx>=N)
					continue;
				if(visit[ny][nx])
					continue;
				if(distance==k)
					continue;
				q.add(new int[] {ny, nx, distance+1});
				visit[ny][nx] = true;
			}
		}
		for(int p=0; p<N; p++) {
			Arrays.fill(visit[p], 0, N, false);
		}
		if(M*home>=k*k+(k-1)*(k-1))
			return home;
		return 0;
	}
}
