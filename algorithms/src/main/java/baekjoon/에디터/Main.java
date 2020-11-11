package baekjoon.에디터;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Character> d = new LinkedList<>();
		ListIterator<Character> iter = d.listIterator();
		String input = br.readLine();
		for(int i=0; i<input.length(); i++) 
			iter.add((Character)input.charAt(i));
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
			switch (cmd) {
				case "L":
					if(!iter.hasPrevious()) continue;
					iter.previous();
					break;
				case "D":
					if(!iter.hasNext()) continue;
					iter.next();
					break;
				case "B":
					if(!iter.hasPrevious()) continue;
					iter.previous();
					iter.remove();
					break;
				case "P":
					iter.add(st.nextToken().charAt(0));
					break;
			}
		}

		for (Character s : d)
			bw.append(s);
		bw.flush();
	}
	
}
