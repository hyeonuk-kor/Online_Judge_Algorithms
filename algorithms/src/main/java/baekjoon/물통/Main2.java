package baekjoon.물통;
import java.io.*;
import java.util.*;
public class Main2 {
	static class P14867 {
		BufferedReader br;
		StringTokenizer st;
		int a, b, c, d;
		Set<String> visit;
		P14867() {
			input();
			visit = new HashSet<>();
			System.out.println(bfs());
		}
		int bfs() {
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {0, 0, 0});
			visit.add(0+" "+0);
			while(!q.isEmpty()) {
				int[] info = q.poll();
				int ca = info[0];
				int cb = info[1];
				int count = info[2];
				if(ca==c && cb==d) {
					return count;
				} else {
					for(int step=0; step<6; step++) {
						int na = ca, nb = cb;
						switch (step) {
							case 0:	na = a;	break; // 물통 a 물 가득 채우기
							case 1:	nb = b;	break; // 물통 b 물 가득 채우기
							case 2:	na = 0;	break; // 물통 a 물 모두 버리기
							case 3:	nb = 0;	break; // 물통 b 물 모두 버리기
							case 4:	// 물통 a -> b 이동
								if(na+nb<=b) {
									nb += na;
									na = 0;
								} else {
									int t = b - nb;
									nb = b;
									na -= t;
								}
								break; 
							case 5:	// 물통 b -> a 이동	
								if(nb+na<=a) {
									na += nb;
									nb = 0;
								} else {
									int t = a - na;
									na = a;
									nb -= t;
								}
								break; 
						}
						String next = na+" "+nb;
						if(!visit.contains(next)) {
							q.add(new int[] {na, nb, count+1});
							visit.add(next);
						}
					}
				}
			}
			return -1;
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P14867();
	}
}