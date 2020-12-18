package baekjoon.배열돌리기5;
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
		array = new int[100][100];
		temp = new int[100][100];
		command = new int[A];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		int index=0;
		for(int i=0; i<A; i++) {
			command[index++] = Integer.parseInt(st.nextToken());
			if(index>=2) {
				if(command[index-1]==command[index-2] && command[index-1]<=2) {
					index-=2;
				} else {
					if(command[index-1]==3 && command[index-2]==4 ||
					   command[index-1]==4 && command[index-2]==3	||
					   command[index-1]==5 && command[index-2]==6	||
					   command[index-1]==6 && command[index-2]==5) {
						index-=2;
					}
				}
			}
			if(index>=3) {
				if(command[index-1]==command[index-2] && 
				   command[index-2]==command[index-3] && 
				   command[index-1]==3) {
					command[index-3]=4;
					index-=2;
				} else if(command[index-1]==command[index-2] && 
						   command[index-2]==command[index-3] && 
						   command[index-1]==4) {
							command[index-3]=3;
							index-=2;
				} else if(command[index-1]==command[index-2] && 
						   command[index-2]==command[index-3] && 
						   command[index-1]==5) {
							command[index-3]=6;
							index-=2;
				} else if(command[index-1]==command[index-2] && 
						   command[index-2]==command[index-3] && 
						   command[index-1]==6) {
							command[index-3]=5;
							index-=2;
				} 
			}
			if(index>=4) {
				if(command[index-1]==command[index-2] && 
				   command[index-2]==command[index-3] && 
				   command[index-3]==command[index-4]) {
					index-=4;
				}
			}
		}
		for(int c=0; c<index; c++) {
			switch (command[c]) {
			case 1:
				for(int i=0; i<N/2; i++) {
					for(int j=0; j<M; j++) {
						int t = array[i][j];
						array[i][j] = array[N-i-1][j];
						array[N-i-1][j] = t;
					}
				}
				break;
			case 2:
				for(int i=0; i<N; i++) {
					for(int j=0; j<M/2; j++) {
						int t = array[i][j];
						array[i][j] = array[i][M-j-1];
						array[M-j-1][j] = t;
					}
				}
				break;
			case 3:
				for(int i=0; i<M; i++) 
					for(int j=0; j<N; j++) 
						temp[i][j] = array[N-j-1][i];
				for(int i=0; i<M; i++)
					array[i] = temp[i].clone();
				M^=N; N^=M; M^=N;
				break;
			case 4:
				for(int i=0; i<M; i++) 
					for(int j=0; j<N; j++) 
						temp[i][j] = array[j][M-i-1];
				for(int i=0; i<M; i++)
					array[i] = temp[i].clone(); 
				M^=N; N^=M; M^=N;
				break;
			case 5:
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
				for(int i=0; i<N; i++)
					array[i] = temp[i].clone(); 
				break;
			case 6:
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
				for(int i=0; i<N; i++)
					array[i] = temp[i].clone(); 
				break;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				bw.append(array[i][j]+" ");
			}
			bw.append("\n");
		}
		bw.flush();
	}
}