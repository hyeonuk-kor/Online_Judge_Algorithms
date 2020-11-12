package baekjoon.쿠키의신체측정;
import java.io.*;
public class Main {
	static int N;
	static char map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int hy=0, hx=0;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		boolean headCheck = true;
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='*' && headCheck) {
					hy = i+1;
					hx = j;
					headCheck = false;
				}
			}
		}
		bw.append((hy+1)+" "+(hx+1)+"\n");
		int leftArm = getLength(hy, hx-1, 0, -1, 0);
		int rightArm = getLength(hy, hx+1, 0, 1, 0);
		int waist = getLength(hy+1, hx, 1, 0, 0);
		int leftLeg = getLength(hy+waist+1, hx-1, 1, 0, 0);
		int rightLeg = getLength(hy+waist+1, hx+1, 1, 0, 0);
		bw.append(leftArm+" ");
		bw.append(rightArm+" ");
		bw.append(waist+" ");
		bw.append(leftLeg+" ");
		bw.append(rightLeg+" ");
		bw.flush();
	}

	static int getLength(int y, int x, int dy, int dx, int length) {
		if(y>=N || x>=N || y<0 || x<0 || map[y][x]=='_') 
			return length;
		return getLength(y+dy, x+dx, dy, dx, length+1);
	}
}
