package baekjoon.부분수열의합;
import java.util.*;
import java.io.*;
public class Main {
	static int N, S, arr[], answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		arr = new int[N];
		for(int i=0; i<N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		getCount();
		if(S==0) answer--;
		System.out.println(answer);
	}
	static void getCount() {
		for(int i=0; i<1<<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				if((i&1<<j)!=0) {
					sum += arr[j];
				}
			}
			if(sum==S) answer++;
		}
	}
}
