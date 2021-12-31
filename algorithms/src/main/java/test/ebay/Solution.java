package test.ebay;
import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"}, {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"}, {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"}, {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"}, {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}}));
	}
	static boolean table[][];
	static int select[], answer = 1;
	static HashSet<String> set;
	public static int solution(String[][] schedule) {
		select = new int[6];
		dfs(1, schedule);
		return answer;
	}
	public static void dfs(int k, String[][] schedule) {
		if(k>5) {
			set = new HashSet<>();
			for(int i=1; i<=5; i++) {
				String str = schedule[i-1][select[i]-1];
				StringTokenizer st = new StringTokenizer(str, " :");
				if(str.length()<=8) {
					String day_all = st.nextToken();
					int hh = Integer.parseInt(st.nextToken());
					int mm = Integer.parseInt(st.nextToken());
					for(int j=0; j<3; j++) {
						String s = day_all+" "+(hh+j)+" "+mm;
						if(set.contains(s))
							return;
						set.add(s);
					}
				} else {
					String day_half = st.nextToken();
					int hh = Integer.parseInt(st.nextToken());
					int mm = Integer.parseInt(st.nextToken());
					for(int j=0; j<3; j++) {
						String s = day_half+" "+hh+" "+mm;
						if(set.contains(s))
							return;
						set.add(s);
						if(mm==0) {
							mm+=30;
						} else {
							mm = 0;
							hh++;
						}
					}
					day_half = st.nextToken();
					hh = Integer.parseInt(st.nextToken());
					mm = Integer.parseInt(st.nextToken());
					for(int j=0; j<3; j++) {
						String s = day_half+" "+hh+" "+mm;
						if(set.contains(s))
							return;
						set.add(s);
						if(mm==0) {
							mm+=30;
						} else {
							mm = 0;
							hh++;
						}
					}
				}
			}
			int sum = 1;
			for(int i=1; i<=5; i++) {
				sum *= select[i];
			}
			answer += sum;
			System.out.println(Arrays.toString(select));
		} else {
			int start = select[k-1];
			if(start==0) start = 1;
			for(int i=start; i<=4; i++) {
				select[k] = i;
				dfs(k+1, schedule);
			}
		}
	}
	
}
