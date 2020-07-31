package swexperts.Solution_3307_최장증가수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, number[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(in.readLine());
			number = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#"+t+" "+lis());
		}
	}

	private static int lis() {
		int[] lis = new int[N];
		int maxIndex = 0;
		for(int i=0; i<N; i++) {
			lis[i]=1;
			for (int j = 0; j < i; j++) {
				if(number[j]<number[i] && lis[i] < lis[j]+1) {
					lis[i] = lis[j]+1;
				}
			}
			if(lis[maxIndex]<lis[i]) {
				maxIndex=i;
			}
		}
		return lis[maxIndex];
	}

	private static int lisPath() {
		int[] lis = new int[N];
		int[] pre = new int[N];
		
		int maxIndex = 0;
		for(int i=0; i<N; i++) {
			lis[i]=1;
			pre[i]=-1;
			for (int j = 0; j < i; j++) {
				if(number[j]<number[i] && lis[i] < lis[j]+1) {
					lis[i] = lis[j]+1;
					pre[i] = j;
				}
			}
			if(lis[maxIndex]<lis[i]) {
				maxIndex=i;
			}
		}
		return lis[maxIndex];
	}

}
