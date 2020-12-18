package baekjoon.큐빙;
import java.io.*;
import java.util.*;
public class Main {
	static final int U=0,D=1,F=2,B=3,L=4,R=5;
	static char cube[][][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			makeCube();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<n; c++) {
				String cmd = st.nextToken();
				rotate(cmd.charAt(0), cmd.charAt(1)=='+'); 
			}
			char[][] pov = leftRotate(U);
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) 
					bw.append(pov[i][j]);
				bw.append("\n");
			}
		}
		bw.flush();
	}
	static void rotate(char cmd, boolean dir) {
		int cnt = (dir)?3:1;
		switch (cmd) {
			case 'U': while(cnt-->0) cubing(U, L, F, R, B);	break;
			case 'D': while(cnt-->0) cubing(D, B, R, F, L);	break;
			case 'F': while(cnt-->0) cubing(F, U, L, D, R);	break;
			case 'B': while(cnt-->0) cubing(B, R, D, L, U); break;
			case 'L': while(cnt-->0) cubing(L, F, U, B, D); break;
			case 'R': while(cnt-->0) cubing(R, D, B, U, F);	break;
		}
	}
	static char[][] leftRotate(int idx) {
		char temp[][] = new char[3][3];
		for(int i=0; i<3; i++) 
			for(int j=0; j<3; j++) 
				temp[i][j] = cube[idx][j][2-i];
		return temp;
	}
	static void cubing(int f, int u, int l, int d, int r) {
		char[] temp = new char[3];
		cube[f] = leftRotate(f);
		for(int i=0; i<3; i++) temp[i] = cube[u][i][0];
		for(int i=0; i<3; i++) cube[u][i][0] = cube[r][2-i][2];
		for(int i=0; i<3; i++) cube[r][2-i][2] = cube[d][2][i];
		for(int i=0; i<3; i++) cube[d][2][i] = cube[l][0][2-i];
		for(int i=0; i<3; i++) cube[l][0][2-i] = temp[i];
	}
	static void makeCube() {
		char color[] = {'w', 'y', 'r', 'o', 'g', 'b'};
		cube = new char[6][3][3];
		for(int i=0; i<6; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					cube[i][j][k] = color[i];
				}
			}
		}		
	}
}