package baekjoon.P10815_숫자카드;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Set<Integer> card = new HashSet<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)
			card.add(Integer.parseInt(st.nextToken()));
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(card.contains(number))
				bw.append("1 ");
			else
				bw.append("0 ");
		}
		bw.flush();
	}
}