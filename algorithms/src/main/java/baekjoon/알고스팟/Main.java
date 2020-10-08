package baekjoon.알고스팟;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	
	private int i;
	private int j;
	private int block;
	
	public Node(int i, int j, int block) {
		this.i = i;
		this.j = j;
		this.block = block;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public int getBlock() {
		return block;
	}

	@Override
	public int compareTo(Node o) {
		return this.block - o.block;
	}
	
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		int[][] maze = new int[N][M];
		boolean[][] check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = input.charAt(j)-'0';
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		check[0][0] = true;
		pq.add(new Node(0,0,0));
		
		int[][] dir = {
				{-1,0}, //상
				{1,0}, //하
				{0,-1}, //좌
				{0,1} //우
		};
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int ci = node.getI();
			int cj = node.getJ();
			int block = node.getBlock();
			
			if(ci==N-1 && cj==M-1) {
				answer = block;
			}
			
			for (int i = 0; i < dir.length; i++) {
				int ni = ci + dir[i][0];
				int nj = cj + dir[i][1];
				if(ni<0 || nj <0 || ni>=N || nj>=M || check[ni][nj])
					continue;
				check[ni][nj]=true;
				if(maze[ni][nj]==1)
					pq.add(new Node(ni, nj, block+1));
				else
					pq.add(new Node(ni, nj, block));
					
			}
		}
		
		System.out.println(answer);
	}

}
