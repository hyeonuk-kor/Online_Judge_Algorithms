package baekjoon.모르고리즘회장님추천받습니다;
import java.util.*;
import java.io.*;

class User implements Comparable<User> {
	private String name;
	private int score;
	public User(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public int compareTo(User o) {
		if(o.score==this.score)
			return this.name.compareTo(o.name);
		return Integer.compare(o.score, this.score);
	}
	public String getName() {
		return name;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<User> pq = new PriorityQueue<User>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			pq.add(new User(name, score));
		}
		bw.append(pq.poll().getName());
		bw.flush();
	}
}
