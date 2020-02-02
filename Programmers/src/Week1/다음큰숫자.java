package Week1;

public class 다음큰숫자 {

	public static void main(String[] args) {
		System.out.println(solution(78));
	}
	
	 public static int solution(int n) {
	      int input = n;
	      int key = 1;
	      
	      while(n!=1) {
	          if(n%2==1) key++;
	          n/=2;
	      }
	      
	      int fkey=1;
	      while(fkey!=key) {
	          fkey=1;
	          int fn = ++input;
	          while(fn!=1) {
	              if(fn%2==1) fkey++;
	              fn/=2;
	              if(fkey>key) break;
	          }
	      }
	      
	      return input;
	  }

}
