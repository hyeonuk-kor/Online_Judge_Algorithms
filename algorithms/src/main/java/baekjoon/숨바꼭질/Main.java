package baekjoon.숨바꼭질;
import java.util.*;
public class Main {
	static int N, K, answer=99999;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visit = new boolean[100000];
		getResult();
		System.out.println(answer);
	}
	
	static void getResult() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {N, 0});
		visit[N] = true;
		while(!q.isEmpty()) {
			int[] info = q.poll();
			int point = info[0];
			int count = info[1];
			if(point==K) {
				answer = count;
				break;
			}
			for(int i=0; i<3; i++) {
				int np = 0;
				if(i==0) np = point*2;
				else if(i==1) np = point+1;
				else np=point-1;
				if(np>100000 || np<0 || visit[np]) continue;
				visit[np] = true;
				q.add(new int[] {np, count+1});
			}
		}
	}
}
