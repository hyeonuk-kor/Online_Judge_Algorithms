package baekjoon.듣보잡;
import java.io.*;
import java.util.*;
public class Main {
	static int N, M, count;
	static String[] name;
	static TreeSet<String> answer;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(sb);
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			name = new String[N+1];
			for(int i=1; i<=N; i++) {
				name[i] = br.readLine();
			}
			Arrays.sort(name, 1, N+1);
			answer = new TreeSet<String>();
			for(int i=1; i<=M; i++) {
				String input = br.readLine();
				if(binary_search(name, 1, N, input)) {
					answer.add(input);
				}
			}
			sb.append(answer.size()).append('\n');
			for(String name: answer) {
				sb.append(name).append('\n');
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	static boolean binary_search(String[] A, int L, int R, String X) {
		while(L<=R) {
			int mid = (L+R)/2;
			if(A[mid].equals(X)) {
				return true;
			}
			if(A[mid].compareTo(X)<0) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return false;
	}
}
