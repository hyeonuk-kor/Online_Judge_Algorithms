package baekjoon.멀티탭스케쥴링;
import java.io.*;
import java.util.*;
public class Main {
	static class P1700 {
		BufferedReader br;
		StringTokenizer st;
		int N, K; 
		int e[];
		P1700() {
			input();
			solve();
		}
		void solve() {
			Map<Integer, Boolean> multi = new HashMap<>();
			int answer = 0;
			for(int i=0; i<K; i++) {
				if(!multi.containsKey(e[i])) {
					if(multi.size()==N) { // 멀티탭이 꽉 차있다.
						TreeMap<Integer, Boolean> t = new TreeMap<>(multi);
						for(int j=i+1; j<K; j++) {
							if(t.size()==1)
								break;
							if(t.containsKey(e[j]))
								t.remove(e[j]);
						}
						multi.remove(t.firstKey());
						multi.put(e[i], true);
						answer++;
					} else {
						multi.put(e[i], true);
					}
				}
			}
			System.out.println(answer);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
				e = new int[K];
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<K; i++)
					e[i] = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P1700();
	}
} 