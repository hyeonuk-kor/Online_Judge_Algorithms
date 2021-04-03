package baekjoon.게리맨더링2;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int map[][] = new int[N][N];
		int population[] = new int[5];
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				for(int d1=1; d1<N; d1++) {
					for(int d2=1; d2<N; d2++) {
						if(x+d1+d2>N || y-d1<0 || y+d2>N)
							continue;
						for(int r=0; r<N; r++) {
							for(int c=0; c<N; c++) {
								if(r<x+d1 && c<=y && (c<((y-d1)+(x+d1)-r))) { //왼방향으로
									population[0] += map[r][c];
								} else if(r<=x+d2 && c>y && (c>(y+d2)-(x+d2)+r)) { //아래방향
									population[1] += map[r][c];
								} else if(r>=x+d1 && c<y-d1+d2 && (c<(y-d1+d2-(x+d1+d2)+r))) { //오른쪽방향
									population[2] += map[r][c];
								} else if(r>x+d2 && c>=y-d1+d2 && (c>(y+d2-d1+(x+d2+d1)-r))) { //윗방향
									population[3] += map[r][c];
								} else {
									population[4] += map[r][c];
								}
							}
						}
						int pmax = Integer.MIN_VALUE, pmin = Integer.MAX_VALUE;
						for(int i=0; i<5; i++) {
							pmax = Math.max(pmax, population[i]);
							pmin = Math.min(pmin, population[i]);
						}
						answer = Math.min(answer, pmax-pmin);
						Arrays.fill(population, 0);
					}
				}
			}
		}
		System.out.println(answer);
	}
}