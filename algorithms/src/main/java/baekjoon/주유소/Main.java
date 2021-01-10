package baekjoon.주유소;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int distance[] = new int[N-1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N-1; i++) 
			distance[i] = Integer.parseInt(st.nextToken());
		long answer = 0, min = Long.MAX_VALUE;
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N-1; i++) {
			min = Math.min(min, Long.parseLong(st.nextToken()));
			answer += min * distance[i];
		}
		System.out.println(answer);
	}
}