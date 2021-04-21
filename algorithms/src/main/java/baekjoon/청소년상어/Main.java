package baekjoon.청소년상어;
import java.io.*;
import java.util.*;
class Fish implements Cloneable{
	int y, x, number, dir;
	boolean alive;
	public Fish(int y, int x, int number, int dir, boolean alive) {
		this.y = y;
		this.x = x;
		this.number = number; 
		this.dir = dir;
		this.alive = alive;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
public class Main {
	static int[][] map = new int[4][4];
	static ArrayList<Fish> fish = initFish();
	static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<4; j++) {
				int number = Integer.valueOf(st.nextToken());
				int dir = Integer.valueOf(st.nextToken())-1;
				fish.set(number-1, new Fish(i, j, number, dir, true));
				map[i][j] = number;
			}
		}
		int eat = map[0][0];
		map[0][0] = -1;
		fish.get(eat-1).alive = false;
		simulate(0, 0, fish.get(eat-1).dir, eat);
		System.out.println(answer);
	}
	static void simulate(int y, int x, int sharkDir, int sum) throws Exception {
		answer = Math.max(answer, sum);
		int copyMap[][] = new int[4][4];
		ArrayList<Fish> copyFish = initFish();
		copy(copyMap, copyFish, map, fish);
		moveFish();
		moveShark(y, x, sharkDir, sum);
		copy(map, fish, copyMap, copyFish);
	}
	static void moveShark(int y, int x, int sharkDir, int sum) throws Exception {
		for(int i=1; i<4; i++) {
			int ny = y + dir[sharkDir][0]*i;
			int nx = x + dir[sharkDir][1]*i;
			if(ny<0 || nx<0 || ny>=4 || nx>=4 || map[ny][nx]==0)
				continue;
			int eat = map[ny][nx];
			map[y][x] = 0;
			map[ny][nx] = -1;
			fish.get(eat-1).alive = false;
			simulate(ny, nx, fish.get(eat-1).dir, sum+eat);
			fish.get(eat-1).alive = true;
			map[ny][nx] = eat;
			map[y][x] = -1;
		}
	}
	static void moveFish() {
		for(int i=1; i<=16; i++) {
			if(fish.get(i-1).alive) {
				for(int j=0; j<8; j++) {
					fish.get(i-1).dir %= 8;
					int ny = fish.get(i-1).y + dir[fish.get(i-1).dir][0];
					int nx = fish.get(i-1).x + dir[fish.get(i-1).dir][1];
					if(ny<0 || nx<0 || ny>=4 || nx>=4 || map[ny][nx]==-1) {
						fish.get(i-1).dir++;
					} else {
						if(map[ny][nx]==0) {
							map[fish.get(i-1).y][fish.get(i-1).x] = 0;
							fish.get(i-1).y = ny;
							fish.get(i-1).x = nx;
							map[ny][nx] = i;
						} else {
							int number = fish.get(map[ny][nx]-1).number;
							fish.get(number-1).y = fish.get(i-1).y;
							fish.get(number-1).x = fish.get(i-1).x;
							map[fish.get(i-1).y][fish.get(i-1).x] =  number;
							fish.get(i-1).y = ny;
							fish.get(i-1).x = nx;
							map[ny][nx] = i;
						}
						break;
					}
				}
			}
		}
	}
	static void copy(int[][] to1, ArrayList<Fish> to2, int[][] from1, ArrayList<Fish> from2) throws Exception {
		for(int i=0; i<4; i++) 
			to1[i] = from1[i].clone();
		for(int i=0; i<from2.size(); i++)
			to2.set(i, (Fish) from2.get(i).clone());
	}
	static ArrayList<Fish> initFish() {
		ArrayList<Fish> temp = new ArrayList<Fish>();
		for(int i=1; i<=16; i++)
			temp.add(new Fish(0, 0, i, 0, true));
		return temp;
	}
}