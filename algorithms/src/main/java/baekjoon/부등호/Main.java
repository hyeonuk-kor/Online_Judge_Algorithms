package baekjoon.부등호;
import java.io.*;
import java.util.*;
public class Main {
	static class P2529 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int k, select[];
		long min=Long.MAX_VALUE, max=Long.MIN_VALUE;
		char sign[];
		boolean check[];
		String solve() {
			input();
			rec_func(0);
			sb.append(max).append('\n');
			while(Math.pow(10, k--)>min)
				sb.append(0);
			sb.append(min);
			return sb.toString();
		}
		private void rec_func(int depth) {
			if(depth==k+1) {
				long res = 0;
				for(int i=0; i<select.length; i++)
					res = res*10 + select[i];
				max = Math.max(res, max);
				min = Math.min(res, min);
				return;
			} else {
				for(int i=0; i<=9; i++) {
					if(!check[i]) {
						check[i] = true;
						select[depth] = i;
						boolean isOk = true;
						if(depth>0) {
							if(sign[depth]=='<') {
								if(select[depth-1] > select[depth])
									isOk = false;
							} else {
								if(select[depth-1] < select[depth])
									isOk = false;
							}
						}
						if(isOk)
							rec_func(depth+1);
						select[depth] = 0;
						check[i] = false;
					}
				}
			}
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				k = Integer.parseInt(br.readLine());
				sign = new char[k+1];
				select = new int[k+1];
				check = new boolean[10];
				st = new StringTokenizer(br.readLine());
				for(int i=1; i<=k; i++) {
					sign[i] = st.nextToken().charAt(0);
				}
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P2529().solve());
	}
}
