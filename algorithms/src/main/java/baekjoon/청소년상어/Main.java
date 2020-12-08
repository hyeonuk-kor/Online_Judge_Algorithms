package baekjoon.청소년상어;
import java.io.*;
import java.util.*;
class Fish {
	int number, d;
	public Fish(int number, int d) {
		this.number = number; 
		this.d = d;
	}
}
public class Main {
	static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Fish map[][] = new Fish[4][4];
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<4; j++) {
				int number = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				map[i][j] = new Fish(number, dir);
			}
		}
		simulation(map, 0, 0, 0);
		System.out.println(answer);
	}

	static void simulation(Fish map[][], int y, int x, int sum) {
		sum += map[y][x].number;
		map[y][x].number=-1;
		moveFish(map, y, x);
		ArrayDeque<int[]> q = moveShark(map, y, x);
		if(q.size()==0) {
			answer = Math.max(sum, answer);
			return;
		} else {
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int ny = info[0];
				int nx = info[1];
				simulation(mapClone(map), ny, nx, sum);
			}
		}
	}

	static Fish[][] mapClone(Fish[][] map) {
		Fish[][] temp = new Fish[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				temp[i][j] = new Fish(map[i][j].number, map[i][j].d);
			}
		}
		return temp;
	}

	static ArrayDeque<int[]> moveShark(Fish map[][], int y, int x) {
		int d = map[y][x].d;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i=0; i<4; i++) {
			y += dir[d][0];
			x += dir[d][1];
			if(y<0 || x<0 || y>=4 || x>=4 || map[y][x].number==-1) continue;
			q.add(new int[] {y, x});
		}
		return q;
	}

	static void moveFish(Fish map[][], int sy, int sx) {
		for(int i=1; i<=16; i++) {
			int[] fishInfo = findFish(map, i);
			if(fishInfo!=null) {
				int y = fishInfo[0];
				int x = fishInfo[1];
				int d = map[y][x].d;
				for(int j=0; j<8; j++) {
					int ny = y + dir[d][0];
					int nx = x + dir[d][1];
					if(ny<0 || nx<0 || ny>=4 || nx>=4 || (ny==sy && nx==sx)) {
						d=(d==7)?0:d+1;
						continue;
					}
					int tn = map[y][x].number;
					int td = map[y][x].d;
					map[y][x].number = map[ny][nx].number;
					map[y][x].d = map[ny][nx].d;
					map[ny][nx].number = tn;
					map[ny][nx].d = td;
					break;
				}
			}
		}
	}

	static int[] findFish(Fish map[][], int number) {
		for(int i=0; i<4; i++) 
			for(int j=0; j<4; j++)
				if(map[i][j].number==number)
					return new int[] {i, j};
		return null;
	}

}
