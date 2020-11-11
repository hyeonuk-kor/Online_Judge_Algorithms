package baekjoon.에디터;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Character> d = new LinkedList<>();
		
		String input = br.readLine();
		int c = input.length();
		ListIterator<Character> iter = d.listIterator();
		for(int i=0; i<c; i++) {
			iter.add((Character)input.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int r = c-1;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
			if(cmd.equals("P")) { //문자를 커서 왼쪽에 추가
				char addChar = st.nextToken().charAt(0);
				iter.add(addChar);
				c++;
				r++;
			} else if(cmd.equals("D")) { //커서 오른쪽으로 이동, 맨뒤면 무시
				if(r+1==c) continue;
				iter.next();
				c++;
			} else if(cmd.equals("L")) { //커서 왼쪽으로 이동, 맨 앞 무시
				if(c==0) continue;
				iter.previous();
				c--;
			} else { //B // 커서 왼쪽 문자를 삭제 맨 앞 무시
				if(c==0) continue;
				r--;
				c--;
				iter.previous();
				iter.remove();
			}
		}

		for (Character s : d)
			bw.append(s);
		bw.flush();
	}
	
}
