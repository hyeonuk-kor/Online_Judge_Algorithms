package baekjoon.두수의합;
import java.io.*;
import java.util.*;
public class Main {
	static int N, A[], X, answer;
	public static void main(String[] args) {
		input();
		System.out.println(answer);
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			A = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			X = Integer.parseInt(br.readLine());
			// 정렬
			Arrays.sort(A, 1, N+1);
			for(int i=1; i<=N; i++) {
				if(A[i]>=X) { // 더 이상 만족하는 쌍을 찾을 수 없으므로 빠져나온다.
					break;
				} else {
					if(binary_search(A, i+1, N, A[i])) { // 만족하는 쌍을 찾는다면 answer 증가
						answer++;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	static boolean binary_search(int[] A, int L, int R, int value) {
		while(L<=R) {
			int mid = (L+R)/2;
			int sum = value + A[mid];
			if(sum==X) {
				return true;
			} else if(sum>X) { // 합이 더 크다면, R을 옮겨준다.
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return false;
	}
}