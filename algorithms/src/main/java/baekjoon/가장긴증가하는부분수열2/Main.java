package baekjoon.가장긴증가하는부분수열2;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		ArrayList<Integer> calc = new ArrayList<>();
		calc.add(Integer.parseInt(st.nextToken()));
		for(int i=1; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			if(calc.get(calc.size()-1)<value) {
				calc.add(value);
			} else {
				int right = Collections.binarySearch(calc, value);
				if(right>=0) {
					calc.set(right, value);
				} else {
					calc.set(-right-1, value);
				}
			}
		}
		bw.append(calc.size()+"\n");
		bw.flush();
	}
}