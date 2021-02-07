package baekjoon.스타트링크;
import java.io.*;
import java.util.*;
public class Main {
	static int F, S, G, U, D;
	static String answer = "use the stairs";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		simulate();
		System.out.println(answer);
	}
	static void simulate() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean visit[] = new boolean[F+1];
		visit[S] = true;
		q.add(new int[] {S, 0});
		while(!q.isEmpty()) {
			int info[] = q.poll();
			if(info[0]==G) {
				answer = String.valueOf(info[1]);
				break;
			}
			int d = info[0]-D;
			int u = info[0]+U;
			if(d>=1 && D!=0 && !visit[d]) {
				visit[d] = true;
				q.add(new int[]{d, info[1]+1});
			}
			if(u<=F && U!=0 && !visit[u]) {
				visit[u] = true;
				q.add(new int[]{u, info[1]+1});
			}
		}
	}
}