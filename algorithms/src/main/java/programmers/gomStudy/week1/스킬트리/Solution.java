package programmers.gomStudy.week1.스킬트리;

import java.util.Arrays;

public class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		
		loop:for(int i=0; i<skill_trees.length; i++) {
			int index = 0;
			
			for(int j=0; j<skill_trees[i].length(); j++) {
				if(index == skill.indexOf(skill_trees[i].charAt(j))) {
					index++;
				} else if (index < skill.indexOf(skill_trees[i].charAt(j))) {
					continue loop;
				}
			}
			answer++;
		}

		return answer;
	}
}