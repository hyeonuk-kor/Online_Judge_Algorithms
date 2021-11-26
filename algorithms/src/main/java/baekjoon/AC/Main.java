package baekjoon.AC;
import java.io.*;
import java.util.*;
public class Main {
	static class P5430 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		Deque<Integer> array;
		P5430() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				int T = Integer.parseInt(br.readLine());
				for(int t=0; t<T; t++) {
					String P = br.readLine();
					int N = Integer.parseInt(br.readLine());
					array = new ArrayDeque<>();
					st = new StringTokenizer(br.readLine(), "[],");
					for(int n=0; n<N; n++) {
						array.add(Integer.parseInt(st.nextToken()));
					}
					boolean error_check = false;
					boolean pop = true;
					for(int p=0; p<P.length(); p++) {
						if(P.charAt(p)=='R') {
							pop = !pop;
						} else {
							if(!array.isEmpty()) {
								if(pop) {
									array.pollFirst();
								} else {
									array.pollLast();
								}
							} else {
								error_check = true;
								break;
							}
						}
					}
					if(error_check) {
						sb.append("error");
					} else {
						if(array.isEmpty()) {
							sb.append("[]");
						} else {
							sb.append('[');
							while(!array.isEmpty()) {
								if(pop) {
									sb.append(array.pollFirst()).append(',');
								} else {
									sb.append(array.pollLast()).append(',');
								}
							}
							sb.replace(sb.length()-1, sb.length(), "]");
						}
					}
					sb.append('\n');
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P5430();
	}
}
