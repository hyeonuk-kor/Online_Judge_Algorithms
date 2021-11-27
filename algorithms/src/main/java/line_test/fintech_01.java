package line_test;
import java.util.*;
public class fintech_01 {
	static class Solution {
		Solution() {
			String[][] record = {
					{"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"},
					{"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"},
					{"P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"}
			};
			for(String[] r: record)
				System.out.println(Arrays.toString(solution(r)));
		}
		public int[] solution(String[] record) {
			int answer[] = new int[2];
			StringTokenizer st = null;
			ArrayDeque<Integer> q1 = new ArrayDeque<>();
			ArrayDeque<Integer> q2 = new ArrayDeque<>();
			for(int i=0; i<record.length; i++) {
				st = new StringTokenizer(record[i], " ");
				String cmd = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				if(cmd.equals("S")) {
					for(int j=0; j<amount; j++) {
						answer[0] += q1.pollFirst();
						answer[1] += q2.pollLast();
					}
				} else {
					for(int j=0; j<amount; j++) {
						q1.add(price);
						q2.add(price);
					}
				}
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		new Solution();
	}
}
