package baekjoon.블로그;
import java.io.*;
import java.util.*;
public class Main {
	static class P21921 {
		BufferedReader br;
		StringTokenizer st;
		int N, X, arr[];
		P21921() {
			input();
			solve();
		}
		void solve() {
			int right = 0, answer = 0, day = 0, sum = 0;
			for(int left=1; left<=N; left++) {
				sum -= arr[left-1];
				while(right+1<=N && right-left+1<X) {
					right++;
					sum += arr[right];
				}
				if(sum>answer) {
					day = 1;
					answer = sum;
				} else if(answer==sum) {
					day++;
				}
			}
			if(answer==0) {
				System.out.println("SAD");
			} else {
				System.out.println(answer);
				System.out.println(day);
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				X = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(br.readLine().trim());
				arr = new int[N+1];
				for(int i=1; i<=N; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P21921();
	}
}