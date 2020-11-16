package baekjoon.이중우선순위큐;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map;
		for(int tc=1; tc<=T; tc++) {
			map = new TreeMap<Integer, Integer>();
			int k = Integer.parseInt(br.readLine());
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String cmd = st.nextToken();
				Integer num = Integer.parseInt(st.nextToken());
				if(cmd.equals("I")) {
					if(map.containsKey(num))
						map.put(num, map.get(num)+1);
					else
						map.put(num, 1);
				} else {
					if(map.isEmpty()) continue;
					int key = (num==-1) ? map.firstKey() : map.lastKey();
					int check = map.get(key)-1;
					if(check==0) 
						map.remove(key);
					else 
						map.put(key, check);
				}
			}

			if(map.isEmpty())
				bw.append("EMPTY\n");
			else
				bw.append(map.lastKey()+" "+map.firstKey()+"\n");
		}
		bw.flush();
	}
}
