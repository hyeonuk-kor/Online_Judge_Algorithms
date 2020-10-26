package baekjoon.숨바꼭질;
import java.util.*;
public class Main {
	static int N, K, answer;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		getResult(0,N);
	}
	
	static void getResult(int cnt, int find) {
		if(find==K) {
			if(answer>cnt)
				answer = cnt;
			System.out.println(cnt);
			return;
		}
		
		getResult(cnt+1, find*2);
		getResult(cnt+1, find+1);
		getResult(cnt+1, find-1);
	
	}
}
