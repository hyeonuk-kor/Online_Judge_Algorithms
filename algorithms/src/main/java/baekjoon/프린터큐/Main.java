package baekjoon.프린터큐;
import java.io.*;
import java.util.*;
public class Main {
	static class Document {
		int index, number;
		public Document(int index, int number) {
			this.index = index;
			this.number = number;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayDeque<Document> deque = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				int number = Integer.parseInt(st.nextToken());
				deque.add(new Document(i, number));
			}
			int print = 0;
			while(!deque.isEmpty()) {
				Document peek = deque.poll();
				boolean check = false;
				Iterator<Document> it = deque.iterator();
				while(it.hasNext()) {
					Document next_peek = it.next();
					if(peek.number < next_peek.number) {
						check = true;
						break;
					}
				}
				if(!check) {
					print++;
					if(peek.index==M)
						break;
				} else
					deque.addLast(peek);
			}
			bw.append(print+"\n");
		}
		bw.flush();
	}
}