package baekjoon.배열돌리기5;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.valueOf(st.nextToken()); 
		int M = Integer.valueOf(st.nextToken()); 
		int A = Integer.valueOf(st.nextToken()); 
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		int matrix[][] = new int[100][100];
		for(int i=0; i<N; i++) {
			arr.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				arr.get(i).add(Integer.valueOf(st.nextToken()));
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		int x=1, y=1, r=0, m=0;
		for(int i=0; i<A; i++) {
			int command = Integer.valueOf(st.nextToken());
			switch (command) {
				case 1:
					y*=-1;
					break;
				case 2:
					x*=-1;
					break;
				case 3:
					r=(r+2-x*y)%4;
					break;
				case 4:
					r=(r+2+x*y)%4;
					break;
				case 5:
					m=(m+2-x*y)%4;
					break;
				case 6:
					m=(m+2+x*y)%4;
					break;
			}
		}
		for(int row=N>>1,col=M>>1,rot=0; rot<m; rot++) {
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					Collections.swap(arr.get(i), j, j+col);
					int temp = arr.get(i).get(j);
					arr.get(i).set(j, arr.get(i+row).get(j+col));
					arr.get(i+row).set(j+col, temp);
					temp = arr.get(i).get(j);
					arr.get(i).set(j, arr.get(i+row).get(j));
					arr.get(i+row).set(j, temp);
				}
			}
		}
		if(x*y<0)
			r = (4-r)%4;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int nx = i, ny = j;
				if(x<0) ny = M-1-ny;
				if(y<0) nx = N-1-nx;
				int tx=nx, ty=ny;
				if(r==1) {
					nx=ty;
					ny=N-1-tx;
				} else if(r==2) {
					nx=N-1-tx;
					ny=M-1-ty;
				} else if(r==3) {
					nx=M-1-ty;
					ny=tx;
				}
				matrix[nx][ny] = arr.get(i).get(j);
			}
		}
		if(r%2==1) {
			int temp = N;
			N = M;
			M = temp;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) 
				pw.write(matrix[i][j]+" ");
			pw.println();
		}
		pw.flush();
	}
}