package baekjoon.IF문좀대신써줘;
import java.io.*;
import java.util.*;
public class Main {
	static class P19637 {
		BufferedReader br;
		StringTokenizer st;
		StringBuilder sb;
		int N, M;
		TreeMap<Integer, String> map;
		P19637() {
			sb = new StringBuilder();
			input();
			System.out.println(sb);
		}
		void input() {
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				st = new StringTokenizer(br.readLine().trim());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				map = new TreeMap<>(); 
				for(int n=0; n<N; n++) {
					st = new StringTokenizer(br.readLine().trim());
					String id = st.nextToken();
					int power = Integer.parseInt(st.nextToken());
					if(!map.containsKey(power)) // 가장 먼저 입력된 칭호 하나만 출력
						map.put(power, id);
				}
				for(int m=0; m<M; m++) {
					int power = Integer.parseInt(br.readLine());
					int L = map.firstKey();
					int R = map.lastKey();
					int res = R + 1;
					while(L<=R) {
						int mid = (L+R)/2;
						if(map.floorKey(mid)>=power) {
							res = mid;
							R = mid - 1;
						} else {
							L = mid + 1;
						}
					}
					sb.append(map.get(res)).append('\n');
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P19637();
	}
}