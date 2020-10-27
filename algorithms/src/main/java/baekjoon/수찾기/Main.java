package baekjoon.수찾기;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr.add(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<M; i++) {
			if(arr.contains(st.nextToken()))
				bw.append(1+"\n");
			else
				bw.append(0+"\n");
		}
		bw.flush();
		bw.close();
	}
}
