package programmers.여행경로;
import java.util.*;
public class Main {
	static class Solution {
		Solution() {
			String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
			System.out.println(solution(tickets));
		}
		List<String> list;
		boolean visit[];
		String[] solution(String[][] tickets) {
			list = new ArrayList<>();
			visit = new boolean[tickets.length];
			go(0, "ICN", "ICN", tickets);
			Collections.sort(list);
			return list.get(0).split(" ");
		}
		void go(int depth, String from, String path, String[][] tickets) {
			if(depth==tickets.length) {
				list.add(path);
			} else {
				for(int i=0; i<tickets.length; i++) {
					if(visit[i]) continue;
					if(tickets[i][0].equals(from)) {
						visit[i] = true;
						go(depth+1, tickets[i][1], path+" "+tickets[i][1], tickets);
						visit[i] = false;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Solution();
	}
}
