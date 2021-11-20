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
		int lower_bound(int X) { // TreeMap에서 X 이상의 수 중, 제일 왼쪽 인덱스를 리턴하는 함수
			int L = map.firstKey();
			int R = map.lastKey();
			int res = R + 1; // X 이상의 수 중, 제일 왼쪽 인덱스가 없다면? R+1을 반환한다.
			while(L<=R) {
				int mid = (L+R)/2;
				if(map.floorKey(mid)>=X) {
					res = mid;
					R = mid - 1;
				} else {
					L = mid + 1;
				}
			}
			return res;
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
					int result = lower_bound(power); // power에 해당하는 if문 index를 찾아
					sb.append(map.get(result)).append('\n'); // 출력해주면 된다.
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