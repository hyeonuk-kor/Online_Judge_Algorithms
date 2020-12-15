package baekjoon.미친로봇;
import java.io.*;
import java.util.*;
public class Main {
	static int N, dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static double p[] = new double[4];
	static boolean map[][] = new boolean[30][30];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i<4; i++) 
			p[i] = Double.parseDouble(st.nextToken())/100;
		System.out.println(simulation(15,15,N));
	}
	static double simulation(int y, int x, int depth) {
		if(map[y][x]) return 0;
		if(depth==0) return 1;
		map[y][x] = true;
		double sum = 0;
		for(int d=0; d<4; d++)
			sum += p[d]*simulation(y+dir[d][0], x+dir[d][1], depth-1);
		map[y][x] = false;
		return sum;
	}
}
