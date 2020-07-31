package swexperts.Solution_3307_최장증가수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {

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
		int[] lis = new int[N]; // i 인덱스 위치를 끝으로 하는 lis의 원소의 최소값  
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(lis, 0, size, number[i]);
			// temp : 없어치거나 추가될 위치의 인덱스(음수 : -해당인덱스 - 1)
			lis[-temp-1] = number[i];
			if(temp==size) ++size;
		}
		
		return size;
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
