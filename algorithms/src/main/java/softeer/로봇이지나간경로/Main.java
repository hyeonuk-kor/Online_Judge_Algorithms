package softeer.로봇이지나간경로;
import java.util.*;
import java.io.*;
public class Main {
	static int H, W, SHARP;
	static int dy[] = {0, 1, 0, -1};
	static int dx[] = {1, 0, -1, 0};
	static char map[][];
	static String answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		for(int i=0; i<H; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<W; j++) {
				if(map[i][j]=='#')
					SHARP++;
			}
		}
		simulation();
		System.out.println(answer);
	}
	static void simulation() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]=='#') {
					for(int d=0; d<4; d++) {
						if(dfs(i, j, new boolean[H][W], 0, 0, d, ""+getDir(d)))
							return;
					}
				}
			}
		}
	}
	private static boolean dfs(int i, int j, boolean[][] bs, int k, int l, int d, String string) {
		// TODO Auto-generated method stub
		return false;
	}
	static boolean isRange(int y, int x) {
		return (y<0 || x<0 || y>=H || x>=W);
	}
	static char getDir(int d) {
		if(d==0)
			return '>';
		else if(d==1)
			return '<';
		else if(d==2)
			return 'v';
		else
			return '^';
	}

}
