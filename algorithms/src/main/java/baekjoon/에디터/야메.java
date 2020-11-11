package baekjoon.에디터;
import java.util.*;
import java.io.*;
public class 야메 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Character> d = new LinkedList<>();
		ListIterator<Character> iter = d.listIterator(); //iter.next() 요소가 커서역할을 함
		String input = br.readLine();
		for(int i=0; i<input.length(); i++) 
			iter.add((Character)input.charAt(i));
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
			try {
				switch (cmd) {
				default: //커서가 왼쪽으로 움직여야하는 부분에 대한 처리
					iter.previous(); // 커서 왼쪽으로 움직인다.
					if(cmd.equals("B")) iter.remove(); //B일때만 삭제한다
					break;
				case "D": //커서를 오른쪽으로 움직인다.
					iter.next();
					break;
				case "P":
					iter.add(st.nextToken().charAt(0));
					break;
				}
			} catch (Exception e) {
				continue;
			}
		}

		for (Character s : d)
			bw.append(s);
		bw.flush();
	}
	
}
