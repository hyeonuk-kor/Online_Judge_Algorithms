package baekjoon.전깃줄;
import java.io.*;
import java.util.*;
class Wire implements Comparable<Wire> {
	private int a;
	private int b;
	public Wire(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public int compareTo(Wire o) {
		return Integer.compare(this.a, o.a);
	}
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
}
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		boolean visit[] = new boolean[500001];
		ArrayList<Wire> array = new ArrayList<>();
		int index = 0, lisIndex[] = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visit[a] = true;
			array.add(new Wire(a,b));
		}
		Collections.sort(array);
		ArrayList<Integer> subSeq = new ArrayList<>();
		subSeq.add(array.get(0).getB());
		for(int i=1; i<array.size(); i++) {
			if(subSeq.get(subSeq.size()-1)<array.get(i).getB()) {
				subSeq.add(array.get(i).getB());
				index++;
				lisIndex[i] = index;
			} else {
				int right = Collections.binarySearch(subSeq, array.get(i).getB());
				if(right<0) 
					right = -right-1;
				subSeq.set(right, array.get(i).getB());
				lisIndex[i] = right;
			}
		}
		int answer = array.size() - subSeq.size();
		System.out.println(answer);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=N-1; i>=0; i--) {
			if(lisIndex[i]==index) {
				list.add(array.get(i).getA());
				index--;
			}
		}
		for(int number: list) {
			visit[number] = false;
		}
		for(int i=0; i<visit.length; i++)
			if(visit[i])
				System.out.println(i);
	}
}