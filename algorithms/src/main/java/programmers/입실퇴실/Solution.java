package programmers.입실퇴실;
import java.util.*;
public class Solution {
	public static int[] solution(int[] enter, int[] leave) { //greedy algorithm
		int size = enter.length;
		int[] answer = new int[size];
		Set<Integer> meeting = new HashSet<>();
		boolean[][] visit = new boolean[size][size];
		int l = 0;
		for(int e=0; e<enter.length; e++) {
			meeting.add(enter[e]);
			while(!meeting.isEmpty() && meeting.contains(leave[l])) {
				meeting.remove(leave[l]);
				for(int n: meeting) {
					visit[leave[l]-1][n-1] = true;
					visit[n-1][leave[l]-1] = true;
				}
				l++;
			}
		}
		for(int i=0, meet=0; i<visit.length; i++, meet=0) {
			for(int j=0; j<visit.length; j++) {
				if(visit[i][j])
					meet++;
			}
			answer[i] = meet;
			System.out.println(Arrays.toString(visit[i]));
		}
		return answer;
	}
	public static int[] solution2(int[] enter, int[] leave) {
		int size = enter.length;
		int[] answer = new int[size];
		Set<Integer> meeting = new HashSet<>();
		int[][] memo = new int[size][2];
		int index=0;
		for(int i=0; i<size; i++) {
			while(!meeting.contains(leave[i])) {
				memo[enter[index]-1][0] = meeting.size();
				memo[enter[index]-1][1] = index;
				meeting.add(enter[index++]);
			}
			meeting.remove(leave[i]);
			answer[leave[i]-1] = memo[leave[i]-1][0] + index - memo[leave[i]-1][1] - 1; 
		}
		for(int j=0; j<size; j++)
			System.out.println(Arrays.toString(memo[j]));
		System.out.println();
		return answer;
	}
	public static void main(String[] args) {
		StringTokenizer st = null;
		String m1 = "[1,4,2,3]";
		String m2 = "[2,1,3,4]";
		st = new StringTokenizer(m1, "[,]");
		int[] enter = new int[st.countTokens()];
		int index = 0;
		while(st.hasMoreTokens()) 
			enter[index++] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(m2, "[,]");
		index = 0;
		int[] leave = new int[st.countTokens()];
		while(st.hasMoreTokens()) 
			leave[index++] = Integer.parseInt(st.nextToken());
		//System.out.println(Arrays.toString(solution(enter, leave)));
		System.out.println(Arrays.toString(solution2(enter, leave)));
	}
}
