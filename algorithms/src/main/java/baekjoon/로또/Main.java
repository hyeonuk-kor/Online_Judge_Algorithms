package baekjoon.로또;
import java.io.*;
import java.util.*;
public class Main {
	static int selected[];	// 6개의 선택된 숫자를 담는 배열
	static ArrayList<ArrayList<Integer>> lotto; // 테스트케이스 별 로또 번호 리스트
	static StringBuilder sb; 
	public static void main(String[] args) {
		input();
		for(int i=0; i<lotto.size(); i++) {
			rec_func(0, lotto.get(i));
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
	// testcase의 숫자를 중복없이 6개를 고르는데, 오름차순  
	// 시간 복잡도 O(testcase.size()*13!/6!*7!)) 보단 작다.
	static void rec_func(int k, ArrayList<Integer> testcase) {
		if(k==6) { // 6개가 선택된다면 출력
			for(int number: selected)
				sb.append(number).append(' ');
			sb.append('\n');
		} else {
			//testcase에서 k번째 숫자를 고르는데
			for(int i=k; i<testcase.size(); i++) {
				int cand = testcase.get(i);
				// 직전의 값이 현재 후보(cand)보다 크다면 수행하지 않는다. 
				if(k>0 && selected[k-1]>=cand)
					continue;
				selected[k] = cand;
				rec_func(k+1, testcase);
				selected[k] = 0;
			}
		}
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();
		lotto = new ArrayList<ArrayList<Integer>>();
		selected = new int[6];
		int testcase = 0;
		try {
			String input = br.readLine();
			while(!input.equals("0")) {
				lotto.add(new ArrayList<Integer>());
				st = new StringTokenizer(input);
				int N = Integer.parseInt(st.nextToken());
				for(int i=0; i<N; i++) {
					int number = Integer.parseInt(st.nextToken());
					lotto.get(testcase).add(number);
				}
				testcase++;
				input = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}