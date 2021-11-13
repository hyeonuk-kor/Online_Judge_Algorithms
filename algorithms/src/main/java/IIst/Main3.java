package IIst;
import java.util.*;
public class Main3 {
	static class Solution {
		Solution() {
			// n 0~Integer.MAX_VALUE
			//int n = 213; // output 321
			int n = Integer.MAX_VALUE/100; // output 553
			System.out.println(solution(n));
		}
		public int solution(int N) {
			char[] str = (N+"").toCharArray();
			ArrayList<String> list = new ArrayList<>();
			for(char c: str) {
				list.add(c+"");
			}
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return -o1.concat(o2).compareTo(o2.concat(o1));
				}
			});
			StringBuilder sb = new StringBuilder();
			for(String s: list)
				sb.append(s);
			long answer = Long.parseLong(sb.toString());
			if(answer>1e8)
				answer = -1;
			return (int)answer;
		}
	}
	public static void main(String[] args) {
		new Solution();
	}
}
