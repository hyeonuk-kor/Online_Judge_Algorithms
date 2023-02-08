package programmers.gemshopping;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(solution(gems));
	}

	static String solution(String[] gems) {
		Set<String> s = new HashSet<>();
		s.addAll(Arrays.asList(gems));
		int gemsCount = s.size(); // 보석의 종류
		int l = 0, r = gems.length-1;
		Map<String, Integer> m = new HashMap<>();
		while(l<r) {
			m.put(gems[l], m.getOrDefault(gems[l], 0) + 1);
			int count = m.getOrDefault(gems[l], 0);
			if(count>1) {
				m.remove(gems[l]);
				l++;
			} else {
				r--;
			}
		}
		return l + " " + r;
	}

}
