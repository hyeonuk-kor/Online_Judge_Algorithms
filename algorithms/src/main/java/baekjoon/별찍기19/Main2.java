package baekjoon.별찍기19;
import java.io.*;
import java.util.Arrays;
public class Main2 {
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int length = (n<<2)-3;
		map = new char[length][length];
		for(int i=0; i<length; i++) 
			Arrays.fill(map[i], ' ');
		draw(0, length);
		for(int i=0; i<length; i++) {
			for(int j=0; j<length; j++) {
				bw.append(map[i][j]);
			}
			bw.append('\n');
		}
		bw.flush();
	}
	
	static void draw(int rc, int len) {
		if(len==1) {
			map[rc][rc]='*';
			return;
		}
		for(int i=0; i<len; i++) {
			map[rc][rc+i] = '*';
			map[rc+len-1][rc+i] = '*';
			map[rc+i][rc] = '*';
			map[rc+i][rc+len-1] = '*';
		}
		draw(rc+2, len-4);
	}

}
