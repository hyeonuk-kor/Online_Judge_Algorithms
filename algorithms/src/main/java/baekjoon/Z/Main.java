package baekjoon.Z;
import java.util.*;
import java.io.*;
public class Main {
	static int N, r, c, answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int offset = 1<<N;
		getResult(offset, 0, 0);
	}

	static void getResult(int size, int y, int x) {
		if(checkValue(y, x)) {
			System.out.println(answer);
			return;
		} 

		int half = size/2;
		if(isRange(y, x, size)) {
			getResult(half, y, x);
			getResult(half, y, x+half);
			getResult(half, y+half, x);
			getResult(half, y+half, x+half);
		} else {
			answer += size*size;
		}
	}	
	static boolean checkValue(int y, int x) {
		return r==y && c==x;
	}

	static boolean isRange(int y, int x, int size) {
		return r<y+size && r>=y && c<x+size && c>=x;
	}
}
