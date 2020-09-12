package kakao_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test_02 {
	
	static String[][] s;
	static int count = 0;
	public static void main(String[] args) {
		String[] orders = {
				"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
		};
		StringBuilder sb = new StringBuilder();
		
		s = new String[orders.length][];
		int max = 0;
		//부분집합 구하기
		for (int i=0; i<orders.length; i++) {
			count = 0;
			char[] data = orders[i].toCharArray();
			if(max<data.length)
				max = data.length;
			int[] flag = new int[data.length];
			s[i] = new String[1<<data.length];
			powerSet(data, flag, 0, i);
		}
		
		Map<String, Integer> hs = new HashMap<>();
		
		for (int i = 0; i < s.length; i++) {
			for(String s : s[i]) {
				if(hs.containsKey(s)) {
					hs.put(s, hs.get(s)+1);
				} else {
					hs.put(s, 1);
				}
			}
		}
		
		List<String> keySetList = new ArrayList<>(hs.keySet());
		Collections.sort(keySetList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length())
					return o1.length()-o2.length();
				return hs.get(o2).compareTo(hs.get(o1));
			}
		});
		
		int curlen = 2;
		int index = 0;
		int cnt = 0;
		for(String key: keySetList) {
			index++;
			if(key.length()==curlen && hs.get(key)>1) {
				if(key.length()<max && hs.get(key)!=hs.get(keySetList.get(index)))
					curlen++;
				sb.append(key+" "+hs.get(key)+" ");
			}
		}
		
		System.out.println(sb);
	}

	private static void powerSet(char[] data, int[] flag, int n, int idx) {
		if(n==data.length) {
			String temp = "";
			for(int i=0; i<flag.length; i++) {
				if(flag[i]==1)
					temp += data[i];
			}
			s[idx][count++] = temp;
			return;
		}
		
		flag[n]=1;
		powerSet(data, flag, n+1, idx);
		flag[n]=0;
		powerSet(data, flag, n+1, idx);
		
	}
	
}
