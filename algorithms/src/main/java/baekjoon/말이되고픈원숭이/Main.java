package baekjoon.말이되고픈원숭이;
import java.io.*;
import java.util.*;
class Monkey {
	int y, x, horseCount, moveCount;
	public Monkey(int y, int x, int horseCount, int moveCount) {
		this.y = y;
		this.x = x;
		this.horseCount = horseCount;
		this.moveCount = moveCount;
	}
}
public class Main {
	static final int MONKEY = 0, HORSE = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.valueOf(st.nextToken());
		int H = Integer.valueOf(st.nextToken());
		int board[][] = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		int dy[] = { 0, 0, 1,-1,-1,-2,-2,-1, 1, 2, 2, 1};
		int dx[] = { 1,-1, 0, 0,-2,-1, 1, 2, 2, 1,-1,-2};
		boolean visit[][][] = new boolean[K+1][H][W];
		Queue<Monkey> q = new ArrayDeque<Monkey>();
		visit[0][0][0] = true;
		q.add(new Monkey(0, 0, 0, 0));
		int answer = -1;
		while(!q.isEmpty()) {
			Monkey c = q.poll();
			if(c.x==W-1 && c.y==H-1) {
				answer = c.moveCount;
				break;
			}
			for(int i=0; i<12; i++) {
				int ny = c.y + dy[i], nx = c.x + dx[i];
				if(ny<0 || nx<0 || ny>=H || nx>=W) continue;
				if(visit[c.horseCount][ny][nx]) continue;
				if(board[ny][nx]==1) continue;
				switch ((i<4)?MONKEY:HORSE) {
				case MONKEY:
					if(!visit[c.horseCount][ny][nx]) {
						visit[c.horseCount][ny][nx] = true;
						q.add(new Monkey(ny, nx, c.horseCount, c.moveCount+1));
					}
					break;
				case HORSE:
					if(c.horseCount<K && !visit[c.horseCount+1][ny][nx]) {
						visit[c.horseCount+1][ny][nx] = true;
						q.add(new Monkey(ny, nx, c.horseCount+1, c.moveCount+1));
					}
					break;
				}
			}
		}
		System.out.println(answer);
	}
}