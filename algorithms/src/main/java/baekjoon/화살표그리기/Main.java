package baekjoon.화살표그리기;
import java.io.*;
import java.util.*;
public class Main {
	static class P15970 {
		BufferedReader br;
		StringTokenizer st;
		int N, color[];
		int solve() {
			input();
			int sum = 0;
			for(int i=0; i<=100000; i++) {
				if(color[i]!=0) {
					int left = Integer.MAX_VALUE;
					int l = i-1, r = i+1;
					while(l>=0) {
						if(color[l]==color[i]) {
							left = i-l;
							break;
						}
						if(--l<0)
							break;
					}
					int right = Integer.MAX_VALUE;
					while(r<=100000) {
						if(color[r]==color[i]) {
							right = r-i;
							break;
						}
						if(++r>100000)
							break;
					}
					sum += Math.min(left, right);
				}
			}
			return sum;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				color = new int[100001];
				for(int i=1; i<=N; i++) {
					st = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					color[x] = y;
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P15970().solve());
	}
}