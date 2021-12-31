package baekjoon.주몽;
import java.io.*;
import java.util.*;
public class Main {
	static class P1940 {
		BufferedReader br;
		StringTokenizer st;
		int N, M, material[], answer;
		P1940() {
			input();
			pro();
			System.out.println(answer);
		}
		void pro() {
			Arrays.sort(material, 1, N+1);
			int L = 1, R = N;
			while(L<R) {
				int sum = material[L]+material[R]; 
				if(sum>M) {
					R--;
				} else {
					if(sum==M)
						answer++;
					L++;
				}
			}
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				N = Integer.parseInt(br.readLine());
				M = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine().trim());
				material = new int[N+1];
				for(int i=1; i<=N; i++) {
					material[i] = Integer.parseInt(st.nextToken());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1940();
	}
}