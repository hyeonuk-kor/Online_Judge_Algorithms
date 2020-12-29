package baekjoon.쿼드트리;
import java.io.*;
public class Main {
	static int N;
	static char image[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		image = new char[N][N];
		for(int i=0; i<N; i++) 
			image[i] = br.readLine().toCharArray();
		System.out.println(compress(0,0,N));
	}
	static String compress(int y, int x, int size) {
		boolean check = true;
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(image[y][x]!=image[i][j]) {
					check = false;
					break;
				}
			}
		}
		if(check) {
			return String.valueOf(image[y][x]);
		} else {
			int half = size/2;
			String upperLeft = compress(y, x, half);
			String upperRight = compress(y, x+half, half);
			String lowerLeft = compress(y+half, x, half);
			String lowerRight = compress(y+half, x+half, half);
			return "(" + upperLeft + upperRight + lowerLeft + lowerRight + ")";
		}
	}
}