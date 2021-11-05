package baekjoon.신입사원;
import java.io.*;
import java.util.*;
public class Main {
	static class P1946 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		class Recruitment {
			int cv, interview;
			public Recruitment(int cv, int interview) {
				this.cv = cv;
				this.interview = interview;
			}
			public int getCv() {
				return cv;
			}
		}
		int T, N;
		Recruitment people[];
		P1946() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void solve() {
			int rank = people[0].interview;
			int count = 1;
			for(int i=1; i<N; i++) {
				if(people[i].interview < rank) {
					count++;
					rank = people[i].interview;
				}
			}
			sb.append(count).append('\n');
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				T = Integer.parseInt(br.readLine());
				for(int tc=1; tc<=T; tc++) {
					N = Integer.parseInt(br.readLine());
					people = new Recruitment[N];
					for(int i=0; i<N; i++) {
						st = new StringTokenizer(br.readLine().trim());
						int cv = Integer.parseInt(st.nextToken());
						int interview = Integer.parseInt(st.nextToken());
						people[i] = new Recruitment(cv, interview);
					}
					Comparator<Recruitment> cv = Comparator.comparing(Recruitment::getCv);
					Arrays.sort(people, cv);
					solve();
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1946();
	}
}
