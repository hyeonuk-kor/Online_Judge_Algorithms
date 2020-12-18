package baekjoon.배열돌리기6;
import java.io.*;
import java.util.*;
public class Main {
	static int map[][], N, R, command[][], temp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[1<<N][1<<N];
		temp = new int[1<<N][1<<N];
		for(int i=0; i<map.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		command = new int[R][2];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			command[i][0] = Integer.parseInt(st.nextToken());
			command[i][1] = Integer.parseInt(st.nextToken());
		}
		simulation();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				bw.append(map[i][j]+" ");
			}
			bw.append('\n');
		}
		bw.flush();
	}

	static void simulation() {
		for(int c=0; c<R; c++) {
			int len = 1<<command[c][1];
			switch (command[c][0]) {
			case 1:
				for(int y=0; y<map.length; y+=len) {
					for(int x=0; x<map[y].length; x+=len) {
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								temp[i][j] = map[len+y-i-1][x+j];
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								map[y+i][x+j] = temp[i][j];
					}
				}
				break;
			case 2:
				for(int y=0; y<map.length; y+=len) {
					for(int x=0; x<map[y].length; x+=len) {
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								temp[i][j] = map[y+i][len+x-j-1];
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								map[y+i][x+j] = temp[i][j];
					}
				}
				break;
			case 3:
				for(int y=0; y<map.length; y+=len) {
					for(int x=0; x<map[y].length; x+=len) {
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								temp[i][j] = map[len+y-j-1][x+i];
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								map[y+i][x+j] = temp[i][j];
					}
				}
				break;
			case 4:
				for(int y=0; y<map.length; y+=len) {
					for(int x=0; x<map[y].length; x+=len) {
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								temp[i][j] = map[y+j][len+x-i-1];
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								map[y+i][x+j] = temp[i][j];
					}
				}
				break;
			case 5:
				for(int y=0; y<map.length; y+=len*2) {
					for(int x=0; x<map[y].length; x+=len) {
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								temp[i][j] = map[y+i][x+j];
						for(int i=0; i<len; i++)
							for(int j=0; j<len; j++)
								map[y+i][x+j] = map[map.length-y-len+i][x+j];
						for(int i=0; i<len; i++)
							for(int j=0; j<len; j++)
								map[map.length-y-len+i][x+j] = temp[i][j];
					}
				}
				break;
			case 6:
				for(int y=0; y<map.length; y+=len) {
					for(int x=0; x<map[y].length; x+=len*2) {
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								temp[i][j] = map[y+i][x+j];
						for(int i=0; i<len; i++)
							for(int j=0; j<len; j++)
								map[y+i][x+j] = map[y+i][map.length-len-x+j];
						for(int i=0; i<len; i++)
							for(int j=0; j<len; j++)
								map[y+i][map.length-len-x+j] = temp[i][j];
					}
				}
				break;
			case 7:
				for(int y=0; y<map.length; y+=len) 
					for(int x=0; x<map[y].length; x+=len) 
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								temp[i+x][map.length-len-y+j] = map[y+i][x+j];
				for(int i=0; i<map.length; i++) 
					map[i] = temp[i].clone();
				break;
			case 8: 
				for(int y=0; y<map.length; y+=len) 
					for(int x=0; x<map[y].length; x+=len) 
						for(int i=0; i<len; i++) 
							for(int j=0; j<len; j++) 
								temp[map.length-len-x+i][y+j] = map[y+i][x+j];
				for(int i=0; i<map.length; i++) 
					map[i] = temp[i].clone();
				break;
			}
		}
	}
}
