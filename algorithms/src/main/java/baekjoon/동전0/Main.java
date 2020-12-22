package baekjoon.동전0;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int coin[] = new int[N];
		for(int i=0; i<N; i++) 
			coin[i] = Integer.parseInt(br.readLine());
		N--;
		int answer = 0;
		while(K!=0) {
			if(coin[N]>K) {
				N--;
			} else {
				answer++;
				K=K-coin[N];
			}
		}
		System.out.println(answer);
	}
}
