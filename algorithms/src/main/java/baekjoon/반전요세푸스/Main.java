package baekjoon.반전요세푸스;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(Integer i=1; i<=N; i++)
			q.add(i);
		int cnt = 0;
		int dir = 0;
		boolean check = true;
		while(!q.isEmpty()) {
			int number = 0;
			if(check) {
				number = q.pollFirst();
			} else {
				number = q.pollLast();
			}
			if(++cnt==K) {
				cnt=0;
				dir++;
				bw.append(number+"\n");
			} else {
				if(check) {
					q.addLast(number);
				} else {
					q.addFirst(number);
				}
			}
			if(dir==M) {
				dir = 0;
				check = !check;
			}
		}
		bw.flush();
	}
}