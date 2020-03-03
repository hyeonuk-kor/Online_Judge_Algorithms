package swexperts.수지의수지맞는여행;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int result;
	static int R, C;
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int v;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			result = 0;
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];
			
			for (int i = 0; i < R; i++) {
				String s = sc.next();
				for(int j=0; j<C;j++) {
					map[i][j] = (char) (s.charAt(j)-'A');
				}
			}
			
			v=1<<map[0][0]-'A';
			dfs(1-1,1-1,1);
			
			System.out.println("#"+t+" "+result);
		}
		
	}

	private static void dfs(int x, int y, int cnt) {
		
		result = Math.max(result, cnt);
		if(cnt==26)
			return;
			
		v |= 1 << map[y][x]-'A';
		
		int nx, ny;
		
		for(int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx < 0 || nx >=C || ny <0 || ny >=R) {
				continue;
			}

			if((v & 1 << map[ny][nx]-'A')!=0) {
				continue;
			}
			
			dfs(nx, ny, cnt+1);
			v &= ~(1<<map[ny][nx]-'A');
		}
		
	}

}