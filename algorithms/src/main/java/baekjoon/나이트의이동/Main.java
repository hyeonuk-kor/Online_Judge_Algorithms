package baekjoon.나이트의이동;
import java.io.*;
import java.util.*;
public class Main {
	static int knight_dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int knight_dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int size = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine()," ");
			int gy = Integer.parseInt(st.nextToken());
			int gx = Integer.parseInt(st.nextToken());
			boolean visit[][] = new boolean[size][size];
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {sy, sx, 0});
			visit[sy][sx]=true;
			while(!q.isEmpty()) {
				int[] point = q.poll();
				int y = point[0];
				int x = point[1];
				int cnt = point[2];
				if(gy==y && gx==x) {
					bw.append(cnt+"\n");
					break;
				} else {
					for(int d=0; d<8; d++) {
						int ny = y + knight_dy[d];
						int nx = x + knight_dx[d];
						if(ny<0 || nx<0 || ny>=size || nx>=size || visit[ny][nx])
							continue;
						visit[ny][nx] = true;
						q.add(new int[] {ny, nx, cnt+1});
					}
				}
			}
		}
		bw.flush();
	}
}
