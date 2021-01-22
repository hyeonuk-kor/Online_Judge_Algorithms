package baekjoon.가장긴증가하는부분수열;
import java.io.*;
import java.util.*;
public class Main {
	static int memo[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		ArrayList<Integer> arr = new ArrayList<>();
		memo = new int[N];
		Arrays.fill(memo, -1);
		for(int i=0; i<N; i++) 
			arr.add(Integer.parseInt(st.nextToken()));
		int answer = 1;
		for(int i=0; i<N; i++)
			answer = Math.max(answer,getResult(arr, i));
		System.out.println(answer);
		System.out.println(Arrays.toString(memo));
	}
	static int getResult(ArrayList<Integer> arr, int start) {
		if(memo[start]!=-1)
			return memo[start];
		int result = 1;
		for(int next=start+1; next<arr.size(); next++) {
			if(arr.get(start)<arr.get(next))
				result = Math.max(result, 1+getResult(arr, next));
		}
		return memo[start]=result;
	}
}