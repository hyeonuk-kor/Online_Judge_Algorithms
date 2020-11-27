package baekjoon.치킨배달;
import java.io.*;
import java.util.*;
class Restaurant {
	private int y, x;
	public Restaurant(int y, int x) {this.y = y;this.x = x;}
	public int getY() {return y;}
	public int getX() {return x;}
}
class Home {
	private int y, x;
	public Home(int y, int x) {this.y = y;this.x = x;}
	public int getY() {return y;}
	public int getX() {return x;}
}
public class Main {
	static int N, M, number[], map[][], rc, hc, answer=Integer.MAX_VALUE;
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean check[];
	static Restaurant[] chicken;
	static Home[] home;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new Home[2*N];
		chicken = new Restaurant[13];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					home[hc++] = new Home(i,j);
				} else if(map[i][j]==2) {
					chicken[rc++] = new Restaurant(i, j); 
				}
			}
		}
		check = new boolean[rc];
		number = new int[rc];
		simulate(0, 0);
		System.out.println(answer);
	}
	static void simulate(int index, int count) {
		if(count==M) {
			int distance = getDistance();
			answer = Math.min(answer, distance);
			return;
		}
		for(int i=index; i<rc; i++) {
			if(check[i]) continue;
			check[i] = true;
			number[count] = i;
			simulate(i+1, count+1);
			check[i] = false;
		}
	}
	static int getDistance() {
		int[] distance = new int[hc];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i=0; i<hc; i++) {
			for(int j=0; j<M; j++) {
				int n = number[j];
				int d = Math.abs(home[i].getY()-chicken[n].getY())+Math.abs(home[i].getX()-chicken[n].getX());
				distance[i] = Math.min(distance[i], d);
			}
		}
		int sum = 0;
		for(int i=0; i<hc; i++) 
			sum += distance[i];
		return sum;
	}
}
