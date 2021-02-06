package baekjoon.별찍기11;
import java.io.*;
import java.util.*;
public class Main {
	static final String star[] = {
			"  *  ",
			" * * ",
			"*****"
	};
	static char map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][2*N];
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], ' ');
		}
		fill(N, 0, N-1);
		for(int i=0; i<N; i++)
			pw.println(map[i]);
		pw.flush();
	}
	static void fill(int n, int y, int x) {
		if(n==3) {
			for(int i=y; i<y+3; i++) {
				for(int j=x-2; j<=x+2; j++) {
					map[i][j] = star[i-y].charAt(j-(x-2));
				}
			}
			return;
		}
		fill(n/2,y,x);
		fill(n/2,y+(n/2),x-(n/2));
		fill(n/2,y+(n/2),x+(n/2));
	}
}