package baekjoon.배열돌리기3;
import java.io.*;
import java.util.*;
public class Main {
	static int array[][], N, M, A, command[], temp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		command = new int[A];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<A; i++) 
			command[i] = Integer.parseInt(st.nextToken());
		
		for(int c=0; c<A; c++) {
			switch (command[c]) {
			case 1:
				temp = new int[N][M];
				for(int i=0; i<N; i++) 
					temp[i] = array[N-i-1];
				array = temp;
				break;
			case 2:
				temp = new int[N][M];
				for(int i=0; i<N; i++) 
					for(int j=0; j<M; j++) 
						temp[i][j] = array[i][M-j-1];
				array = temp;
				break;
			case 3:
				temp = new int[M][N];
				for(int i=0; i<M; i++) 
					for(int j=0; j<N; j++) 
						temp[i][j] = array[N-j-1][i];
				array = temp; M^=N; N^=M; M^=N;
				break;
			case 4:
				temp = new int[M][N];
				for(int i=0; i<M; i++) 
					for(int j=0; j<N; j++) 
						temp[i][j] = array[j][M-i-1];
				array = temp; M^=N; N^=M; M^=N;
				break;
			case 5:
				temp = new int[N][M];
				for(int i=0; i<N/2; i++) 
					for(int j=M/2; j<M; j++) 
						temp[i][j] = array[i][j-M/2];
				for(int i=N/2; i<N; i++) 
					for(int j=M/2; j<M; j++) 
						temp[i][j] = array[i-N/2][j];
				for(int i=N/2; i<N; i++) 
					for(int j=0; j<M/2; j++) 
						temp[i][j] = array[i][M/2+j];
				for(int i=0; i<N/2; i++) 
					for(int j=0; j<M/2; j++) 
						temp[i][j] = array[N/2+i][j];
				array = temp;
				break;
			case 6:
				temp = new int[N][M];
				for(int i=N/2; i<N; i++)
					for(int j=0; j<M/2; j++)
						temp[i][j] = array[i-N/2][j];
				for(int i=N/2; i<N; i++)
					for(int j=M/2; j<M; j++)
						temp[i][j] = array[i][j-M/2];
				for(int i=0; i<N/2; i++)
					for(int j=M/2; j<M; j++)
						temp[i][j] = array[i+N/2][j];
				for(int i=0; i<N/2; i++) 
					for(int j=0; j<M/2; j++) 
						temp[i][j] = array[i][M/2+j];
				array = temp;
				break;
			}
		}
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				bw.append(array[i][j]+" ");
			}
			bw.append("\n");
		}
		bw.flush();
	}
}
