package baekjoon.두용액;
import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, A[];
	public static void main(String[] args) {
		input();
		pro();
		System.out.println(sb.toString());
	}
	static void pro() {
		// 정렬하기, -99 -2 -1 4 98
		Arrays.sort(A, 1, N+1);
		int sum = Integer.MAX_VALUE;
		int v1 = 0, v2 = 0;
		for(int left = 1; left<=N-1; left++) {
			int candidate = lower_bound(A, left+1, N, -A[left]);
			// 정렬의 특성은 각 원소마다 가장 가까운 원소가 양 옆중에 있다.
			// A[candidate -1]과 A[candidate]에서 두 용액을 섞어비교하면서 정답에 갱신시킨다.
			if(left < candidate-1 && Math.abs(A[left] + A[candidate-1])<sum) {
				sum = Math.abs(A[left] + A[candidate-1]);
				v1 = A[left];
				v2 = A[candidate-1];
			}
			if(candidate <=N && Math.abs(A[left] + A[candidate])<sum) {
				sum = Math.abs(A[left] + A[candidate]);
				v1 = A[left];
				v2 = A[candidate];
			}
		}
		sb.append(v1).append(' ').append(v2);
	}
	static int lower_bound(int[] A, int L, int R, int X) {
		// A[L...R]에서 X 이상의 수 중 제일 왼쪽 인덱스를 찾는 함수
		// 없다면 R + 1을 리턴한다.
		int res = R + 1;
		while(L<=R) {
			int mid = (L+R)/2;
			if(A[mid]>=X) {
				res = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return res;
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			A = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
