package baekjoon.숫자의신;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		String[] number = new String[N];
		
		int max = (int)-1e9;
		for(int i=0; i<K; i++) {
			number[i] = br.readLine();
			if(Integer.parseInt(number[i])>max) 
				max = Integer.parseInt(number[i]);
		}
		
		for(int i=K; i<N; i++)
			number[i] = Integer.toString(max);
		
		Arrays.sort(number, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -o1.concat(o2).compareTo(o2.concat(o1));
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String i: number)
			sb.append(i);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
