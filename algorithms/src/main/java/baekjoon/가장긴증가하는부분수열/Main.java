package baekjoon.가장긴증가하는부분수열;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++) 
			arr.add(Integer.parseInt(st.nextToken()));
		System.out.println(getResult(arr));
	}
	static int getResult(ArrayList<Integer> arr) {
		if(arr.size()==0)
			return 0;
		int result = 0;
		for(int i=0; i<arr.size(); i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j=i+1; j<arr.size(); j++) {
				if(arr.get(i)<arr.get(j))
					temp.add(arr.get(j));
			}
			result = Math.max(result, 1+getResult(temp));
		}
		return result;
	}
}