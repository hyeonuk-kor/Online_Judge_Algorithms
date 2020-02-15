package Programmers.GomStudy.Week1;

public class 다음큰숫자 {

	public static void main(String[] args) {
		System.out.println(solution(78));
	}

	public static int solution(int n) {
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
