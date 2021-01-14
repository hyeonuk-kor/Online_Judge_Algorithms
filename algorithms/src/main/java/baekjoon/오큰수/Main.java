package baekjoon.오큰수;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int result[] = new int[N];
		Arrays.fill(result, -1);
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Stack<int[]> s = new Stack<>();
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(st.nextToken());
			while(!s.isEmpty() && number > s.peek()[0]) 
				result[s.pop()[1]] = number;
			s.push(new int[] {number, i});
		}
		for(int i=0; i<N; i++) 
			bw.append(result[i]+" ");
		bw.flush();
	}
}