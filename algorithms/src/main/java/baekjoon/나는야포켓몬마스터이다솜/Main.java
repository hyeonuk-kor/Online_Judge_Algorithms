package baekjoon.나는야포켓몬마스터이다솜;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TreeMap<String, Integer> map = new TreeMap<>();
		String pocketmon[] = new String[N+1];
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			map.put(name, i);
			pocketmon[i] = name; 
		}
		
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			char check = input.charAt(0);
			if(check>='0' && check<='9') {
				bw.append(pocketmon[Integer.parseInt(input)]+"\n");
			} else { 
				bw.append(map.get(input)+"\n");
			}
		}
		bw.flush();
	}

}
