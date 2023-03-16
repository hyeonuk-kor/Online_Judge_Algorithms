package baekjoon.숨바꼭질4;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N==K) {
			System.out.println(0+"\n"+N);
			return;
		}
		boolean[] visit = new boolean[100001];
		int[] from = new int[100001];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		visit[N] = true;
		int time = 0;
		while(!q.isEmpty()) {
			if(visit[K]) {
				bw.append(time+"\n");
				break;
			}
			for(int i=0, j=q.size(); i<j; i++) {
				int now = q.poll();
				int np = now * 2;
				if(np>=0 && np<=100000 && !visit[np]) {
					visit[np] = true;
					from[np] = now;
					q.add(np);
				}
				np = now + 1;
				if(np>=0 && np<=100000 && !visit[np]) {
					visit[np] = true;
					from[np] = now;
					q.add(np);
				}
				np = now - 1;
				if(np>=0 && np<=100000 && !visit[np]) {
					visit[np] = true;
					from[np] = now;
					q.add(np);
				}
			}
			time++;
		}
		List<Integer> move = new ArrayList<>();
		move.add(K);
		while(from[K]!=N) {
			move.add(from[K]);
			K = from[K];
		}
		Collections.reverse(move);
		bw.append(N+" ");
		for(int m: move)
			bw.append(m+" ");
		bw.flush();
		bw.close();
	}
}