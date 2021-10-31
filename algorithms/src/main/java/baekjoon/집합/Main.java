package baekjoon.집합;
import java.io.*;
import java.util.*;
public class Main {
	static class P11723 {
		Set<Integer> set;
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		P11723() {
			br = new BufferedReader(new InputStreamReader(System.in));
			set = new HashSet<>();
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void solve(String cmd, int x) {
			switch (cmd) {
			case "add":
				set.add(x);
				break;
			case "remove":
				set.remove(x);
				break;
			case "check":
				if(set.contains(x)) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "toggle":
				if(set.contains(x)) {
					set.remove(x);
				} else {
					set.add(x);
				}
				break;
			case "all":
				set = new HashSet<>(allSet());
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		Set<Integer> allSet() {
			Set<Integer> s = new HashSet<>();
			for(int i=1; i<=20; i++)
				s.add(i);
			return s;
		}
		void input() {
			try {
				int T = Integer.parseInt(br.readLine());
				for(int t=1; t<=T; t++) {
					st = new StringTokenizer(br.readLine().trim());
					String cmd = st.nextToken();
					int x = 0;
					if(!cmd.equals("all") && !cmd.equals("empty")) {
						x = Integer.parseInt(st.nextToken());
					}
					solve(cmd, x);
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P11723();
	}
}