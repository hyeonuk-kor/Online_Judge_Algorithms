package baekjoon.NQUEEN9663;
import java.io.*;
import java.util.*;
public class Main {
	static int N, answer;
	static ArrayList<Integer> candidate;
	public static void main(String[] args) {
		input();
		dfs(0);
		System.out.println(answer);
	}
	static void dfs(int depth) {
		if(depth==N) {
			answer++;
			return;
		} 
		for(int i=0; i<N; i++) {
			if(isAvailable(candidate, i)) {
				candidate.add(i);
				dfs(depth+1);
				candidate.remove(candidate.size()-1);
			}
		}
	}
	static boolean isAvailable(ArrayList<Integer> candidate, int col) {
		int row = candidate.size();
		for(int i=0; i<row; i++) {
			if(candidate.get(i)==col || Math.abs(candidate.get(i)-col) == row-i)
				return false;
		}
		return true;
	}
	static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());        
			br.close();
			candidate = new ArrayList<>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}