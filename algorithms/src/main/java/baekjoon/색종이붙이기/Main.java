package baekjoon.색종이붙이기;

import java.io.*;
import java.util.*;

public class Main {

	static int map[][], paper[]= {0,5,5,5,5,5};
	static int result=Integer.MAX_VALUE, count;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getResult(0, 0);
		if(result==Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
		
	}
	static void getResult(int r, int c) {
		if(r==10) {
			result = Math.min(result, count);
			return;
		}
		
		if(c==10) {
			getResult(r+1, 0);
			return;
		}
		
		
		if(map[r][c]==0) {
			getResult(r, c+1);
			return;
		}
		
		loop:for (int len = 1; len <= 5; len++) {
			if(paper[len]==0 || r+len>10 || c+len>10) continue;
			for(int i=0; i<len; i++) {
				for(int j=0; j<len; j++) {
					if(map[r+i][c+j]==0)
						continue loop;
				}
			}
			
			//색종이 붙여보고 검사해보기
			for(int i=0; i<len; i++) {
				for(int j=0; j<len; j++) {
					map[r+i][c+j] = 0;
				}
			}
			paper[len]--;
			count++;
			getResult(r, c+len); // 검사
			//검사 후 다시 원래대로 복원
			count--;
			paper[len]++;
			for(int i=0; i<len; i++) {
				for(int j=0; j<len; j++) {
					map[r+i][c+j] = 1;
				}
			}
		}
		
		
		
	}

	
}
