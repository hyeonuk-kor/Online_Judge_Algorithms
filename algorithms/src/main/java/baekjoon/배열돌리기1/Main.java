package baekjoon.배열돌리기1;
import java.util.*;
import java.io.*;
public class Main {
	static int N, M, R, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int rc = Math.min(N, M);
		for(int i=0;i<rc/2 ;i++) {
			rotate(i, N-i-1, i, M-i-1, R);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				bw.append(map[i][j]+" ");
			}
			bw.append("\n");
		}
		bw.flush();
	}
	static void rotate(int rs, int re, int cs, int ce, int rotate) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayDeque<Integer> result = new ArrayDeque<>();
		
		for(int i=cs; i<ce; i++) list.add(map[rs][i]);
		for(int i=rs; i<re; i++) list.add(map[i][ce]);
		for(int i=ce; i>=cs+1; i--)	list.add(map[re][i]);
		for(int i=re; i>=rs+1; i--)	list.add(map[i][cs]);
		
		int size = list.size();
		for(int i: list.subList(rotate%size, size)) result.add(i);
		for(int i: list.subList(0, rotate%size)) result.add(i);
		
		for(int i=cs; i<ce; i++) map[rs][i] = result.poll();
		for(int i=rs; i<re; i++) map[i][ce] = result.poll();
		for(int i=ce; i>=cs+1; i--)	map[re][i] = result.poll();
		for(int i=re; i>=rs+1; i--)	map[i][cs] = result.poll();
	}
}