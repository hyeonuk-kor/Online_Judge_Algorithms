package programmers.직업군추천하기;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"SI JAVA JAVASCRIPT SQL PYTHON C#", 
												  "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
												  "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
												  "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
												  "GAME C++ C# JAVASCRIPT C JAVA"},
									new String[] {"PYTHON", "C++", "SQL"},
									new int[] {7, 5, 5}
									)
						  );
		
	}

	static String solution(String[] table, String[] languages, int[] preference) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<languages.length; i++) 
			map.put(languages[i], preference[i]);
		int[] calc = new int[table.length];
		int max = -1;
		String max_symbol = "";
		for(int i=0; i<table.length; i++) {
			StringTokenizer st = new StringTokenizer(table[i]);
			String symbol = st.nextToken();
			for(int j=5; j>=1; j--) {
				String key = st.nextToken();
				calc[i] += j * map.getOrDefault(key, 0);
			}
			if(max<calc[i]) {
				max = calc[i];
				max_symbol = symbol;
			} else if(max==calc[i]) {
				if(symbol.compareTo(max_symbol)<0) {
					max_symbol = symbol;
				}
			}
		}
		return max_symbol;
	}
	
}
