package programmers.gomStudy.week1.다음큰숫자;

public class Solution {

	public  int solution(int n) {
		int input = n;
		int oneCount = binOneCount(input);
		int nextOneCount = binOneCount(++input);
		while (oneCount != nextOneCount) {
			nextOneCount = binOneCount(++input);
		}
		
		return input;
	}

	public static int binOneCount(int num) {
		int oneCount = 1;
		while (num != 0) {
			num&=(num-1);
			oneCount++;
		}
		return oneCount;
	}

}
