package baekjoon.NM과K1;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int N, M, K, map[][], number[], dir[][] = {{0,1},{0,-1},{1,0},{-1,0}}, answer=Integer.MIN_VALUE;
	static boolean check[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		number = new int[K];
		check = new boolean[N*M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		getResult(0, 0);
		System.out.println(answer);
	}
	static void getResult(int depth, int index) {
		if(depth==K) {
			int sum = 0;
			for(int i=0; i<K; i++) {
				int y = number[i]/M;
				int x = number[i]%M;
				sum+=map[y][x];
			}
			answer = Math.max(answer, sum);
			return;
		}
		for(int i=index; i<N*M; i++) {
			if(isNext(index, i)) continue;
			if(check[i]) continue;
			check[i] = true;
			number[index] = i;
			getResult(depth+1, index+1);
			check[i] = false;
		}
		
	}
	static boolean isNext(int index, int next) {
		for(int j=0; j<index; j++) {
			if(number[j]/M==next/M && Math.abs(number[j]%M-next%M)==1) return true;
			if(number[j]%M==next%M && Math.abs(number[j]/M-next/M)==1) return true;
		}
		return false;
	}
}
