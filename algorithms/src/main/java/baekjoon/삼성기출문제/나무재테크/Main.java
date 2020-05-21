package baekjoon.삼성기출문제.나무재테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N,M,K;
	static ArrayList[][] mapTree;
	static int[][] a; //로봇이 채울 양분정보
	static int[][] map;
	static int dx[] = {-1,-1,-1,0,0,1,1,1};
	static int dy[] = {-1,0,1,-1,1,-1,0,1};
	
	static class Tree {
		int age;
		boolean isAlive;
		public Tree(int age, boolean isAlive) {
			this.age = age;
			this.isAlive = isAlive;
		}
		public Tree(int age) {
			this.age = age;
			this.isAlive = true;
		}
		@Override
		public String toString() {
			return "Tree [age=" + age + ", isAlive=" + isAlive + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		a = new int[N][N];
		mapTree = new ArrayList[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				mapTree[i][j] = new ArrayList<Tree>();
			}
		}
		
		int x, y, age;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			age = Integer.parseInt(st.nextToken());
			mapTree[x][y].add(new Tree(age, true));
		}
		
		for(int k=0; k<K; ++k) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(getCount());
		
	}

	private static void spring() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				ArrayList<Tree> list = mapTree[x][y];
				int amount = map[x][y];
				for (int i = list.size()-1; i >=0; --i) {
					Tree tree = list.get(i);
					if(amount>=tree.age) {
						amount -= tree.age;
						tree.age++;
					} else {
						tree.isAlive = false;
					}
				}
				map[x][y] = amount;
			}
		}
	}

	private static void summer() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				ArrayList<Tree> list = mapTree[x][y];
				int amount = 0; // 더해질 양분
				for (int i = 0; i < list.size(); ++i) {
					Tree tree = list.get(i);
					if(tree.isAlive) break;
					amount += tree.age/2;
					list.remove(i--);
				}
				map[x][y] += amount;
			}
		}	
	}

	private static void fall() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				ArrayList<Tree> list = mapTree[x][y];
				for (int i = 0; i < list.size(); i++) {
					Tree tree = list.get(i);
					if(tree.age%5!=0) continue;
					int nx, ny;
					for (int d = 0; d < 8; d++) {
						nx = x + dx[d];
						ny = y + dy[d];
						if(nx>=0 && nx <N && ny>=0 && ny<N) {
							mapTree[nx][ny].add(new Tree(1,true));
						}
					}
				}
			}
		}			
	}

	private static void winter() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				map[x][y] += a[x][y];
			}
		}
	}
	
	private static int getCount() {
		int count = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				count += mapTree[x][y].size();
			}
		}
		return count;
	}

}
