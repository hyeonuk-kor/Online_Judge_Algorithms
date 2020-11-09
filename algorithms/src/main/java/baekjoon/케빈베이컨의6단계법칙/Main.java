package baekjoon.케빈베이컨의6단계법칙;
import java.io.*;
import java.util.*;
public class Main {
	static final int INF = (int)1e9;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] relation = new int[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(relation[i], INF);
			relation[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			relation[a][b] = 1;
			relation[b][a] = 1;
		}
		
		for(int k=0; k<N; k++) {
			for(int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					relation[a][b] = Math.min(relation[a][b], relation[a][k]+relation[k][b]);
				}
			}
		}
		
		int min = INF;
		int answer = 1;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				sum = sum + relation[i][j];
			}
			if(min>sum) {
				min = sum;
				answer = i+1;
			}
		}
		
		System.out.println(answer);
	}
}
