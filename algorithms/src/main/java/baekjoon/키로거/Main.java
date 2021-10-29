package baekjoon.키로거;
import java.io.*;
import java.util.*;
public class Main {
	static class P5397 {
		BufferedReader br;
		StringBuilder sb;
		int N;
		ArrayList<String> tc;
		void solve() {
			input();
			for(int i=0; i<N; i++) {
				getPassword(tc.get(i));
				System.out.println(sb);
			}
		}
		void getPassword(String string) {
			LinkedList<Character> password = new LinkedList<>();
			ListIterator<Character> cursor = password.listIterator();
			// - 지우기, 이동 <, >
			for(char c: string.toCharArray()) {
				switch (c) {
				case '-':
					if(cursor.hasPrevious()) { // 이전 위치가 존재한다면?
						cursor.previous();		// 커서 이동
						cursor.remove();		// 커서의 현재 원소 삭제
					}
					break;
				case '<':
					if(cursor.hasPrevious()) {	// 이전 위치 존재한다면?
						cursor.previous();		// 커서 한칸 앞으로 이동
					}
					break;
				case '>':
					if(cursor.hasNext()) {		// 다음 위치가 존재한다면?
						cursor.next();			// 커서 한칸 뒤로 이동
					}
					break;
				default:
					cursor.add(c);				// 위 명령어가 아닐 경우, 커서 현재 위치에 추가하고 커서 현재위치 1증가
					break;
				}
			}
			sb = new StringBuilder();
			for(char c: password) {
				sb.append(c);
			}
		}
		void input() {
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				N = Integer.parseInt(br.readLine());
				tc = new ArrayList<>();
				for(int i=0; i<N; i++) {
					tc.add(br.readLine());
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new P5397().solve();
	}
}
