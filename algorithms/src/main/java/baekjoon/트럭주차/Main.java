package baekjoon.트럭주차;
import java.io.*;
import java.util.*;
public class Main {
	static int time[][] = new int[3][101];
	static int sum[] = new int[101];
	static int A, B, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for(int j=s; j<e; j++) {
				time[i][j] = 1; 
			}
		}
		for(int j=0; j<101; j++) {
			for(int i=0; i<3; i++) {
				sum[j] += time[i][j];
			}
		}
		int answer = 0;
		for(int i=1; i<=100; i++) {
			switch (sum[i]) {
			case 1:	answer += sum[i]*A; break;
			case 2:	answer += sum[i]*B; break;
			case 3:	answer += sum[i]*C; break;
			}
		}
		System.out.println(answer);
	}
}
