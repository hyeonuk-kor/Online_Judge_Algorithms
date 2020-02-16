package programmers.gomStudy.week1.하샤드수;

public class Solution {
	
	public boolean solution(int x) {
	      int sum = 0;
	      int input = x;
	      while(input!=0) {
				sum += input%10;
				input/=10;
		  }
		  return x%sum==0;
	}

}
