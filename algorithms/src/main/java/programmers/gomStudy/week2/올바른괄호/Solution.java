package programmers.gomStudy.week2.올바른괄호;

public class Solution {
	public boolean solution(String s) {
		
		int count = 0;
		for(char ch : s.toCharArray()) {
			if(ch=='(') {
				count++;
			} else if(count==0) {
				return false;
			} else {
				count--;
			}
		}
		
		return count==0;
    }	
}
