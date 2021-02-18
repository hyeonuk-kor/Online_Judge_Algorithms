package baekjoon.요세푸스문제0;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(Integer i=1; i<=N; i++)
			q.add(i);
		int cnt = 0;
		while(!q.isEmpty()) {
			if(++cnt==K) {
				list.add(q.poll());
				cnt=0;
			} else {
				q.addLast(q.poll());
			}
		}
		bw.append("<");
		for(int i=0; i<list.size(); i++) {
			bw.append(list.get(i).toString());
			if(i==list.size()-1) {
				bw.append(">");
			} else {
				bw.append(',').append(' ');
			}
		}
		bw.flush();
	}
}