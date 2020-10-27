package baekjoon.숨바꼭질3;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[200001];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {N, 0});
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cn = info[0];
			int cc = info[1];
			visit[cn] = true;
			if(cn==K) {
				bw.append(cc+"\n");
				break;
			}
			for(int i=0; i<3; i++) {
				int np = 0;
				switch (i) {
				case 0:
					np = cn * 2;
					break;
				case 1:
					np = cn + 1;
					break;
				case 2:
					np = cn - 1;
					break;
				}
				if(np<0 || np>100000 || visit[np]) continue;
				if(i==0)
					q.addFirst(new int[] {np, cc});
				else
					q.addLast(new int[] {np, cc+1});
			}
			
		}
		bw.flush();
		bw.close();
	}
}
