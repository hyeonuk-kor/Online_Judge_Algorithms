package baekjoon.배열돌리기4;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
class Rotate {
	int r, c, s;
	public Rotate(int r, int c, int s) {
		this.r = r;	this.c = c;	this.s = s;
	}
}
public class Main {
	static int N, M, K, map[][], order[], min = Integer.MAX_VALUE;
	static boolean[] check;
	static Rotate rot[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	for(int j=0; j<M; j++) 
        		map[i][j] = Integer.parseInt(st.nextToken());
        }
        rot = new Rotate[K]; 
        for(int i=0; i<K; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	int r = Integer.parseInt(st.nextToken())-1;
        	int c = Integer.parseInt(st.nextToken())-1;
        	int s = Integer.parseInt(st.nextToken());
        	rot[i] = new Rotate(r,c,s);
        }
        order = new int[K]; check = new boolean[K];
        getResult(0, 0);
        System.out.println(min);
	}
	static void getResult(int depth, int index) {
		if(depth==K) {
			for(int i=0; i<N; i++) min = Math.min(min, IntStream.of(map[i]).sum());
			return;
		}
		for(int i=0; i<K; i++) {
			if(check[i]) continue;
			check[i] = true;
			order[index] = i;
			int rs = rot[order[index]].r - rot[order[index]].s;
			int re = rot[order[index]].r + rot[order[index]].s;
			int cs = rot[order[index]].c - rot[order[index]].s;
			int ce = rot[order[index]].c + rot[order[index]].s;
			for(int j=0; j<rot[order[index]].s; j++)
				rightRotate(rs+j, re-j, cs+j, ce-j);
			getResult(depth+1, index+1);
			for(int j=0; j<rot[order[index]].s; j++)
				leftRotate(rs+j, re-j, cs+j, ce-j);
			check[i] = false;
		}
	}
	static void rightRotate(int rs, int re, int cs, int ce) {
		int temp = map[rs][cs];
		for(int i=rs; i<re; i++) map[i][cs] = map[i+1][cs]; 
		for(int i=cs; i<ce; i++) map[re][i] = map[re][i+1];
		for(int i=re; i>rs; i--) map[i][ce] = map[i-1][ce];
		for(int i=ce; i>cs; i--) map[rs][i] = map[rs][i-1];
		map[rs][cs+1] = temp;
	}
	static void leftRotate(int rs, int re, int cs, int ce) {
		int temp = map[rs][cs];
		for(int i=cs; i<ce; i++) map[rs][i] = map[rs][i+1];
		for(int i=rs; i<re; i++) map[i][ce] = map[i+1][ce]; 
		for(int i=ce; i>cs; i--) map[re][i] = map[re][i-1];
		for(int i=re; i>rs; i--) map[i][cs] = map[i-1][cs];
		map[rs+1][cs] = temp;
	}
}