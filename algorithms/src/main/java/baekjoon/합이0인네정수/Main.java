package baekjoon.합이0인네정수;
import java.io.*;
import java.util.*;
public class Main {
	static int N, A[], B[], C[], D[], AB[], CD[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		// 모든 경우의 수 계산 O(N*N)을 해야할...까...?
		// 단순히 AB의 합과 CD의 합을 투포인터로 접근하게 되면,
		// 2
		// 0 0 0 0
		// 0 0 0 0
		// 이란 반례를 해결하지 못했다..
		int count = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				AB[count] = A[i] + B[j];
				CD[count] = C[i] + D[j];
				count++;
			}
		}
		//정렬 (n*n logn)을 일단 해보자...
		Arrays.sort(AB, 1, count);
		Arrays.sort(CD, 1, count);
		// 정렬의 특성을 이용해서 최소와 최대를 통해 0에 가깝게 찾아본다.
		// 세 용액 문제처럼 AB를 순차적으로, CD의 시작점을 L, 끝 점을 R로 두고 Two Pointer로 합이 0인 개수를 찾아내면 되지 않을까?
		// 하지만... 이렇게 풀면 N*N*N*N이 되버려서 시간초과를 받겠지...? 시간을 더 줄여야 한다.
		// 그렇다면 target을 찾을 때 이진 탐색으로 반 씩 좁힌다면...? 더 늘어나는구나 N*N*N*N*logN 어떻게


		//현재 시도 중인 방법 4000^4 경우의수 long
		long answer = 0; 
		for(int L=1, R=N*N; L<=N*N && R>=1; ) {
			int sum = AB[L] + CD[R];
			if(sum==0) {
				int left = L, right = R;
				long ab_count = 0, cd_count = 0;
				while(L<=N*N && AB[L]+CD[right]==0) {
					ab_count++;
					L++;
				}
				while(R>=1 && AB[left]+CD[R]==0) {
					cd_count++;
					R--;
				}
				answer += (ab_count * cd_count); 
			} else if(sum>0) {
				R--;
			} else {
				L++;
			}
		}
		// 정답 출력
		System.out.println(answer);
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			N = Integer.parseInt(br.readLine()); // 1<= N <= 4000
			// 각 입력 최대치 2^28, 4개를 다 더해도 Integer 범위!!
			A = new int[N+1]; B = new int[N+1]; C = new int[N+1]; D = new int[N+1];
			AB = new int[N*N+1];	CD = new int[N*N+1]; // AB : A와 B의 합, CD: C와 D의 합
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
				D[i] = Integer.parseInt(st.nextToken());
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}