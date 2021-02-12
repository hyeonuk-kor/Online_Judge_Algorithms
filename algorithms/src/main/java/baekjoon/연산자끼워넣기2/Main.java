package baekjoon.연산자끼워넣기2;
import java.io.*;
import java.util.*;
public class Main {
	static final int addition = 0, subtraction = 1, multiplication = 2, division = 3;
	static int N, number[], sign[];
	static int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		sign = new int[4];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)
			number[i] = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<4; i++)
			sign[i] = Integer.valueOf(st.nextToken());
		getResult(0, number[0]);
		System.out.println(max);
		System.out.println(min);
	}
	static void getResult(int depth, int result) {
		if(depth==N-1) {
			min = Math.min(result, min);
			max = Math.max(result, max);
			return;
		}
		for(int i=0; i<4; i++) {
			if(sign[i]==0) continue;
			sign[i]--;
			switch (i) {
				case addition:		 getResult(depth+1, result+number[depth+1]); break;
				case subtraction:	 getResult(depth+1, result-number[depth+1]); break;
				case multiplication: getResult(depth+1, result*number[depth+1]); break;
				case division:		 getResult(depth+1, result/number[depth+1]); break;
			}
			sign[i]++;
		}
	}
}