package baekjoon.예산;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, money[];
	public static void main(String[] args) {
		input();
		pro();
	}
	static void pro() {
		Arrays.sort(money, 1, N+1);
		// 지방에서 요구하는 최소-최대 예산을 각각 (L,R)로 두고, 이분 탐색을 통해 예산을 조율해본다.
		int L = 0, R = money[N];
		int ans = 0;
		while(L<=R) {
			int mid = (L+R)/2;
			if(determination(mid)) { // 예산을 더 배정할 수 있다면 최소 금액을 늘려본다
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static boolean determination(int mid) {
		long sum = 0;
		for(int i=1; i<=N; i++) {
			if(money[i] <= mid) { // 배정된 예산(mid)을 모두 지급할 수 경우
				sum += money[i];
			} else {			  // 지방에서 요구한 금액보다 적게 주는 경우
				sum += mid;	
			}
		}
		return sum<=M;	// 총 예산에서 지급이 가능할까?
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			money = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}