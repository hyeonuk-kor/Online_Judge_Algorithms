package baekjoon.게리맨더링;
import java.util.*;
import java.io.*;
public class Main {
	static int N, people[], answer = Integer.MAX_VALUE;
	static boolean graph[][], distinct[], visit[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N; i++)  
			people[i] = Integer.parseInt(st.nextToken());
		graph = new boolean[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				int next = Integer.parseInt(st.nextToken());
				graph[i][next] = true;
			}
		}
		distinct = new boolean[N+1];
		divideDistinct(1);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	static void divideDistinct(int index) {
		if(index==N) {
			int red = 0, blue = 0;
			for(int i=1; i<=N; i++) {
				if(distinct[i]) red+=people[i]; 
				else blue+=people[i];
			}
			visit = new boolean[N+1];
			int count = 0;
			for(int i=1; i<=N; i++) {
				if(!visit[i]) {
					check(i, distinct[i]);
					count++;
				}
			}
			if(count==2) 
				answer = Math.min(answer, Math.abs(red-blue));
			return;
		}
		distinct[index] = true;
		divideDistinct(index+1);
		distinct[index] = false;
		divideDistinct(index+1);
	}
	static void check(int n, boolean color) {
		visit[n] = true;
		for(int i=1; i<=N; i++) {
			if(graph[n][i] && !visit[i] && distinct[i]==color)
				check(i, color);
		}
	}
}
