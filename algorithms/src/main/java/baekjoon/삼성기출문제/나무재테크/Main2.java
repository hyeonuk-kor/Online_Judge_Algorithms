package baekjoon.삼성기출문제.나무재테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

	static int N,M,K;
	static ArrayList<Integer>[][] mapTree;
	static int[][] a; //로봇이 채울 양분정보
	static int[][] map;
	static int dx[] = {-1,-1,-1,0,0,1,1,1};
	static int dy[] = {-1,0,1,-1,1,-1,0,1};
	
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
				mapTree[i][j] = new ArrayList<Integer>();
			}
		}
		
		int x, y, age;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			age = Integer.parseInt(st.nextToken());
			mapTree[x][y].add(age);
		}
		
		for(int k=0; k<K; ++k) {
			springAndsummer();
			fall();
			winter();
		}
		System.out.println(getCount());
		
	}

	private static void springAndsummer() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				ArrayList<Integer> list = mapTree[x][y];
				int amount = map[x][y];
				int nAmount = 0; //새로 더해질 양분
				for (int i = list.size()-1; i >=0; --i) {
					int age = list.get(i);
					if(amount>=age) {
						amount -= age;
						list.set(i, age+1);
					} else {
						nAmount += age/2;
						list.remove(i);
					}
				}
				map[x][y] = amount+nAmount;
			}
		}
	}

	private static void fall() {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				ArrayList<Integer> list = mapTree[x][y];
				for (int i = 0; i < list.size(); i++) {
					int age = list.get(i);
					if(age%5!=0) continue;
					int nx, ny;
					for (int d = 0; d < 8; d++) {
						nx = x + dx[d];
						ny = y + dy[d];
						if(nx>=0 && nx <N && ny>=0 && ny<N) {
							mapTree[nx][ny].add(1);
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
