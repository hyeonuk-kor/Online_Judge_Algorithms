package baekjoon.톱니바퀴;
import java.util.*;
import java.io.*;
public class Main {
	static char[][] geer;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		geer = new char[4][8];
		visit = new boolean[4];
		for(int i=0; i<4; i++) {
			geer[i] = br.readLine().toCharArray();
		}
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int number = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			rotate(number-1, dir);
		}
		int sum = 0;
		for(int i=0; i<4; i++) {
			if(geer[i][0]=='1') {
				sum += (1<<i); 
			}
		}
		bw.append(sum+"\n");
		bw.flush();
	}
	static void rotate(int number, int dir) {
		if(visit[number]) return; //이미 처리된 톱니바퀴면 되돌아감.
		visit[number] = true;
		switch (number) {
			case 0: //첫 번째 톱니바퀴
				if(geer[number][2]!=geer[number+1][6]) 
					rotate(number+1, -dir);
				break;
			case 3: //마지막 톱니바퀴
				if(geer[number][6]!=geer[number-1][2]) 
					rotate(number-1, -dir);
				break;
			default: //양 옆으로 비교 가능한 톱니바퀴
				if(geer[number][6]!=geer[number-1][2] && geer[number][2]!=geer[number+1][6]) {
					rotate(number-1, -dir);
					rotate(number+1, -dir);
				} else { //한 쪽만 가능한 경우
					if(geer[number][6]!=geer[number-1][2]) 
						rotate(number-1, -dir);
					else if(geer[number][2]!=geer[number+1][6]) 
						rotate(number+1, -dir);
				}
				break;
		}
		adjust(number, dir); //조정
		visit[number] = false; //재탐색을 위한 방문해제
	}
	static void adjust(int number, int dir) {
		if(dir==1) {
			char temp = geer[number][7];
			for(int i=7; i>=1; i--) {
				geer[number][i] = geer[number][i-1];
			}
			geer[number][0] = temp;
		} else {
			char temp = geer[number][0];
			for(int i=1; i<=7; i++) {
				geer[number][i-1] = geer[number][i];
			}
			geer[number][7] = temp;
		}
	}
}
