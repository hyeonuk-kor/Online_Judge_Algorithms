package IIst;
import java.util.*;
public class Main2 {
	static class Solution {
		Solution() {
			//String[] s = {"abc", "bca", "dbe"}; // 0, 2, 1
			//String[] s = {"zzzz", "ferz", "zdsr", "fgtd"}; // 0, 1, 3 // 1 3 0도 되지만
			//String[] s = {"gr", "sd", "rg"}; // []
			String[] s = {"bdafg", "ceagi"}; // 0 1 2
			System.out.println(Arrays.toString(solution(s)));
		}
		public int[] solution(String[] S) {
			ArrayList<int[]> list = new ArrayList<>();
			int length = S[0].length();
			for(int i=0; i<length; i++) {
				for(int j=0; j<S.length-1; j++) {
					for(int k=j+1; k<S.length; k++) {
						if(S[j].charAt(i)==S[k].charAt(i)) {
							list.add(new int[] {j, k, i});
						}
					}
				}
			}
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0]) {
						if(o1[1]==o2[1]) {
							return Integer.compare(o1[2], o2[2]);
						}
						return Integer.compare(o1[1], o2[1]);
					}
					return Integer.compare(o1[0], o2[0]);
				}
			});
			if(list.isEmpty())
				return new int[] {};
			return list.get(0);
		}
	}
	public static void main(String[] args) {
		// N 1이상 30000이하
		// M 1이상 2000이하
		// N*M <= 30000
		// 각 원소는 소문자 a-z로 구성
		new Solution();
	}
}
