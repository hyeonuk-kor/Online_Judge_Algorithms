package baekjoon.십자가찾기;
import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		check = new boolean[n][m];
		for(int i=0; i<n; i++)
			map[i] = br.readLine().toCharArray(); 
		List<Integer[]> ansList = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]=='*') {
					int l = 0;
					for(int k=1; ;k++) {
						if(i+k<n && i-k>=0 && j+k<m && j-k>=0) {
							if(map[i+k][j]=='*' && map[i-k][j]=='*' && map[i][j+k]=='*' && map[i][j-k]=='*') {
								l = k;								
							} else {
								break;
							}
						} else {
							break;
						}
					}
					if(l>0) {
						ansList.add(new Integer[] {i+1, j+1, l});
						check[i][j] = true;
						for(int k=1;k<=l;k++) {
							check[i+k][j] = true;
							check[i-k][j] = true;
							check[i][j+k] = true;
							check[i][j-k] = true; 
						}
					}
				}
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]=='*' && check[i][j]==false) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		System.out.println(ansList.size());
		for(int i=0; i<ansList.size(); i++) {
			System.out.println(ansList.get(i)[0]+" "+ansList.get(i)[1]+" "+ansList.get(i)[2]);
		}
		
	}
}
