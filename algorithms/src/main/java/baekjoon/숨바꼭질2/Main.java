package baekjoon.숨바꼭질2;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[100001];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {N, 0});
		int answer = 0;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cn = info[0];
			int cc = info[1];
			visit[cn]=true;
			if(cn==K) {
				answer = cc;
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
				q.add(new int[] {np, cc+1});
			}
		}
		
		int count = 1;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int cn = info[0];
			int cc = info[1];
			if(answer==cc && cn==K)
				count++;
		}
		
		bw.append(answer+"\n");
		bw.append(count+"\n");
		bw.flush();
		bw.close();


	}
}
