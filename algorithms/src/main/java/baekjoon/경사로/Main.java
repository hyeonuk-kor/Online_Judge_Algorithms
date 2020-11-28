package baekjoon.경사로;
import java.io.*;
import java.util.*;
public class Main {
	static int N, L, answer;
	static int[][] map1, map2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map1 = new int[N][N];
		map2 = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map1[i][j] = Integer.parseInt(st.nextToken());
				map2[j][i] = map1[i][j];
			}
		}
		for(int i=0; i<N; i++) {
			simulate(map1[i]);
			simulate(map2[i]);
		}
		System.out.println(answer);
	}
	
	static void simulate(int map[]) {
		int length = 1, idx=0;
		while(idx<N-1) {
			int height = map[idx]-map[idx+1];
			if(height==0) 
				length++;
			else if(height==-1 && length>=L) 
				length = 1;
			else if(height== 1 && length>=0) 
				length = 1-L;
			else 
				return;
			idx++;
		}
		if(idx==N-1 && length>=0)
			answer++;
	}

}
