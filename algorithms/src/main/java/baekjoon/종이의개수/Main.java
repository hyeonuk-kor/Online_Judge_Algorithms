package baekjoon.종이의개수;
import java.io.*;
import java.util.*;
public class Main {
	static int N, paper[][], number[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		number = new int[3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) 
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		getResult(0,0,N);
		for(int i=0; i<3; i++)
			bw.append(number[i]+"\n");
		bw.flush();
	}
	static void getResult(int y, int x, int n) {
		if(check(y, x, n)) {
			number[paper[y][x]+1]++;
		} else {
			int size = n/3;
			for(int i=0; i<3; i++)
				for(int j=0; j<3; j++)
					getResult(y+size*i, x+size*j, size);
		}
	}
	static boolean check(int y, int x, int size) {
		for(int i=y; i<y+size; i++)
			for(int j=x; j<x+size; j++)
				if(paper[y][x]!=paper[i][j])
					return false;
		return true;
	}
}