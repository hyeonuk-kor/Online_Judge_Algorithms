package programmers.gomStudy.week1;

public class 하샤드수 {

	public static void main(String[] args) {
		System.out.println(solution(2));
	}
	
	public static boolean solution(int x) {
	      int sum = 0;
	      int input = x;
	      while(input!=0) {
				sum += input%10;
				input/=10;
		  }
		  return x%sum==0;
	}

}
