package baekjoon.보석도둑;
import java.io.*;
import java.util.*;
class Gem {
	private int M, V;
	public Gem(int m, int v) {
		M = m; // 무게
		V = v; // 가격
	}
	public int getM() {
		return M;
	}
	public int getV() {
		return V;
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		ArrayList<Gem> gem = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			gem.add(new Gem(m,v));
		}
		ArrayList<Integer> bag = new ArrayList<Integer>();
		for(int i=0; i<K; i++) {
			bag.add(Integer.valueOf(br.readLine()));
		}
		Collections.sort(gem, new Comparator<Gem>() {
			@Override
			public int compare(Gem o1, Gem o2) {
				return Integer.compare(o1.getM(), o2.getM()); //무게 오름차순
			}
		});
		Collections.sort(bag);
		
		PriorityQueue<Gem> pq = new PriorityQueue<>(new Comparator<Gem>() {
			@Override
			public int compare(Gem o1, Gem o2) {
				return Integer.compare(o2.getV(), o1.getV()); //가격 내림차순
			}
		});
		long result = 0;
		int idx = 0;
		for(int i=0; i<K; i++) {
			while(idx<N && gem.get(idx).getM()<=bag.get(i)) {
				pq.add(gem.get(idx++));
			}
			if(pq.size()!=0) {
				result += pq.poll().getV();
			}
		}
		System.out.println(result);
	}
}