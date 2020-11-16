package baekjoon.꽃길;
import java.io.*;
import java.util.*;
public class Main {
	static int N, map[][], answer=(int)1e9;
	static boolean[][] check;
	static int flower[][] = {
				   {-1,+0},
		   {+0,-1},{+0,+0},{+0,+1},
				   {+1,+0}
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
	
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		getAnswer(0, 0);
		bw.append(answer+"\n");
		bw.flush();
		
	}

	static void getAnswer(int step, int sum) {
		if(sum>answer)
			return;
		if(step==3) {
			answer = Math.min(answer, sum);
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isGrowing(i, j)) {
					int calc = cover(i, j, true);
					getAnswer(step+1, sum+calc);
					uncover(i, j, false);
				}
			}
		}
	}

	static void uncover(int y, int x, boolean b) {
		for(int d=0; d<flower.length; d++) {
			int ny = y + flower[d][0];
			int nx = x + flower[d][1];
			check[ny][nx] = b;
		}
	}

	static int cover(int y, int x, boolean b) {
		int sum = 0;
		for(int d=0; d<flower.length; d++) {
			int ny = y + flower[d][0];
			int nx = x + flower[d][1];
			sum+=map[ny][nx];
			check[ny][nx] = b;
		}
		return sum;
	}

	static boolean isGrowing(int y, int x) {
		for(int d=0; d<flower.length; d++) {
			int ny = y + flower[d][0];
			int nx = x + flower[d][1];
			if(ny<0 || nx<0 || ny>=N || nx>=N || check[ny][nx])
				return false;
		}
		return true;
	}
}
