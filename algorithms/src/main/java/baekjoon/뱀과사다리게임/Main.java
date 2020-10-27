package baekjoon.뱀과사다리게임;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] map = new int[101];
		boolean[] visit = new boolean[101];
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a] = b;
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,0});
		visit[1] = true;
		
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int point = info[0];
			int count = info[1];
			if(point==100) {
				bw.append(count+"\n");
				break;
			}
			for(int i=6; i>=1; i--) {
				int np = point + i;
				int nc = count + 1;
				if(np>100 || visit[np]) continue;
				if(map[np]==0) {
					q.add(new int[] {np, nc});
					visit[np]=true;
				} else {
					q.add(new int[] {map[np], nc});
					visit[map[np]]=true;
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
