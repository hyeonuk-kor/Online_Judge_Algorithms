package swexperts.보물상자비밀번호;
import java.io.*;
import java.util.*;
public class Solution {
	static class P5658 {
		class Testcase {
			int N, K;
			String str;
			public Testcase(int n, int k, String str) {
				N = n;
				K = k;
				this.str = str;
			}
		}
		ArrayList<Testcase> tc;
		StringBuilder sb = new StringBuilder();
		BufferedReader br;
		StringTokenizer st;
		int T, answer;
		String solve() {
			input();
			for(int t=1; t<=T; t++) {
				answer = 0;
				rotate(tc.get(t-1));
				sb.append("#").append(t).append(" ").append(answer).append("\n");
			}
			return sb.toString();
		}
		void rotate(Testcase t) {
			TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
			int N = t.N;
			int K = t.K;
			String str = t.str;
			int group = N/4;
			ArrayList<Character> cap = new ArrayList<>();
			for(int i=0; i<str.length(); i++) {
				cap.add(str.charAt(i));
			}
			for(int i=0; i<group; i++) {
				for(int j=0; j<cap.size(); j+=group) {
					StringBuilder s = new StringBuilder();
					for(int k=j; k<j+group; k++) {
						s.append(cap.get(k));
					}
					set.add(s.toString());
				}
				Collections.rotate(cap, 1);
			}
			List<String> result = new ArrayList<>(set);
			answer = Integer.parseInt(result.get(K-1), 16);
		}
		private void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			tc = new ArrayList<>();
			try {
				T = Integer.parseInt(br.readLine());
				for(int t=1; t<=T; t++) {
					st = new StringTokenizer(br.readLine());
					int N = Integer.parseInt(st.nextToken());
					int K = Integer.parseInt(st.nextToken());
					String str = br.readLine();
					tc.add(new Testcase(N, K, str));
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(new P5658().solve());
	}
}
