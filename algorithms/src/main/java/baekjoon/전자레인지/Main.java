package baekjoon.전자레인지;
import java.io.*;
public class Main {
	static class Solution {
		// T에서 가장 큰 버튼을 누를 수 있을 때 까지 누른다. 이 횟수를 p
		// 그 다음, 작은 버튼을 누를 수 있을 때 까지 누른다. 이 횟수를 q
		// 그 다음, 작은 버튼을 누를 수 있을 때 까지 누른다. 이 횟수를 r
		// 답 : p+q+r
		// 위 조건이 참이 되려면?
		// 가장 큰 버튼을 p-1 눌렀을 때, 최소조작 방법이 존재할까?
		// (거짓) p-1만큼 작은 버튼을 2회이상 더 조작해야한다. 
		// 따라서 존재하지 않는다.
		int T, time[] = {300, 60, 10};
		StringBuilder sb = new StringBuilder();
		String solve() {
			input();
			for(int i=0; i<3; i++) {
				if(T/time[i]==0)
					sb.append(0);
				else {
					sb.append(T/time[i]);
					T -= time[i]*(T/time[i]);
				}
				sb.append(' ');
			}
			if(T!=0) {
				sb.delete(0, sb.length());
				sb.append(-1);
			}
			return sb.toString();
		}
		void input() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				T = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	public static void main(String[] args) {
		System.out.println(new Solution().solve());
	}
}
