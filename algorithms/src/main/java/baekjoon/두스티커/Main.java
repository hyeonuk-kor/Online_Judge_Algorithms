package baekjoon.두스티커;
import java.io.*;
import java.util.*;
public class Main {
	static int H, W, N, R[], C[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		R = new int[N];
		C = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int r1 = R[i], c1 = C[i];
			for (int j = i + 1; j < N; j++) {
				int r2 = R[j], c2 = C[j];
				for (int rot1 = 0; rot1 < 2; rot1++) {
					for (int rot2 = 0; rot2 < 2; rot2++) {
						if (r1 + r2 <= H && Math.max(c1, c2) <= W) {
							int calc = r1 * c1 + r2 * c2;
							answer = Math.max(answer, calc);
						}
						if (Math.max(r1, r2) <= H && c1 + c2 <= W) {
							int calc = r1 * c1 + r2 * c2;
							answer = Math.max(answer, calc);
						}
						int temp = r2;
						r2 = c2;
						c2 = temp;
					}
					int temp = r1;
					r1 = c1;
					c1  = temp;
				}
			}
		}
		System.out.println(answer);
	}
}