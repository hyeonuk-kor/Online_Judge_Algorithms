package baekjoon.합이0인네정수;
import java.io.*;
import java.util.*;
public class Main2 {
	static int N, A[], B[], C[], D[], AB[], CD[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		int count = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				AB[count] = A[i] + B[j];
				CD[count] = C[i] + D[j];
				count++;
			}
		}
		//Arrays.sort(AB, 1, count);
		Arrays.sort(CD, 1, count);

		//현재 시도 중인 방법 4000^4 경우의수 long
		long answer = 0; 
		for(int i=1; i<=N*N; i++ ) {
			int key = -AB[i];
			int L = lower_bound(CD, 1, N*N, key);
			int R = lower_bound(CD, 1, N*N, key+1);
			answer += R-L;
		}
		// 정답 출력
		System.out.println(answer);
	}
	static int lower_bound(int[] A, int L, int R, int key) {
		// A[L...R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 R + 1 을 return 한다
        int res = R + 1;  // 만약 A[L...R] 중
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= key) {
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