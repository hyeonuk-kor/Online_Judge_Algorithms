package baekjoon.드래곤커브;
import java.util.*;
import java.io.*;
public class Main {
	static boolean map[][];
	static int dir[][] = {{0,1},{-1,0},{0,-1},{1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new boolean[101][101];
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int direct[] = new int[(int)Math.pow(2, g)];
			direct[0] = d;
			map[y][x] = true;
			x = x+dir[d][1];
			y = y+dir[d][0];
			map[y][x] = true;
			simulate(y, x, g, 1, direct);
		}
		System.out.println(getRectangle());
	}
	static int getRectangle() {
		int answer = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
					answer++;
			}
		}
		return answer;
	}
	static void simulate(int y, int x, int g, int index, int[] direct) {
		if(g==0) return;
		for(int i=index-1, j=index; i>=0; i--, j++) {
			map[y][x]=true;
			direct[j] = (direct[i]+1)%4;
			y = y+dir[direct[j]][0];
			x = x+dir[direct[j]][1];
			map[y][x]=true;
		}
		simulate(y, x, g-1, index<<1, direct);
	}
}
