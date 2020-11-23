package baekjoon.Z;
import java.util.*;
import java.io.*;
public class Z2 {
	static int N, r, c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		bw.append(Integer.toString(getResult(N, r, c)));
		bw.flush();
	}
	static int getResult(int n, int r, int c) {
		if(n==0) return 0;
		int half = 1<<(n-1);
		int size = half*half;
		int quadrant = isRange(r, c, half);
		int number = size*quadrant;
		int result=0;
		switch (quadrant) {
			case 0: result = number+getResult(n-1, r, c);			break;
			case 1: result = number+getResult(n-1, r, c-half);		break;
			case 2: result = number+getResult(n-1, r-half, c);		break;
			case 3: result = number+getResult(n-1, r-half, c-half);	break;
		}
		return result;
	}		
	static int isRange(int r, int c, int size) {
		if(r<size && c<size) return 0;
		else if(r<size && c>=size) return 1;
		else if(r>=size && c<size) return 2;
		else return 3;
	}
}
