package swexperts.초콜릿과건포도;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution
{
    static int n,m,result;
    static int[][] map;
    static int[][][][]dp;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n][m];
            dp = new int[n+1][m+1][n+1][m+1];
            
            for(int[][][] d1: dp) {
            	for(int[][] d2: d1) {
            		for(int[] d3: d2) {
            			Arrays.fill(d3, Integer.MAX_VALUE);
            		}
            	}
            }
            for(int i=0; i<n; i++) {
             	for(int j=0; j<m; j++) {
                 	map[i][j]=sc.nextInt();   
                }
            }
            
            result = dfs(0,0,n,m);
            
            System.out.println("#"+test_case+" "+result);
		}   
        
	}
    
    static int dfs(int y, int x, int h, int w) {
        //종료
        if(w==1 && h==1) {
            return 0;
        }
        if(dp[y][x][h][w]!=Integer.MAX_VALUE) {
        	return dp[y][x][h][w];
        }
        //실행
        //기존에 있던 덩어리의 건포도 갯수
        int sum = 0;
        for(int i=y; i<y+h;i++) {
         	for(int j=x; j<x+w;j++) {
         		sum += map[i][j];
         	}
        }
        //가로로 나누어서 비용을 최소비용으로 구한다.
        for(int i=1; i<h; i++) {
        	//위쪽 비용
        	if(dp[y][x][i][w]==Integer.MAX_VALUE) {
        		dp[y][x][i][w] = dfs(y,x,i,w);
        	}
            //아래쪽 비용
        	if(dp[y+1][x][h-i][w]==Integer.MAX_VALUE) {
        		dp[y+i][x][h-i][w] = dfs(y+i,x,h-i,w);
        	}
        	
        	int sum3 = sum + dp[y][x][i][w] + dp[y+i][x][h-i][w];
            dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
        }
        
        //세로로 나누어서 비용을 최소비용을 구한다.
        for(int i=1; i<w; i++) {
        	//왼쪽 비용
        	if(dp[y+1][x][h-i][w]==Integer.MAX_VALUE) {
        		dp[y+1][x][h-i][w] =  dfs(y+1,x,h-i,w);
        	}
        	//오른쪽 비용
        	if(dp[y][x+1][h][w-i]==Integer.MAX_VALUE) {
        		dp[y][x+i][h][w-i] = dfs(y,x+i,h,w-i);
        	}
        	int sum3 = sum + dp[y+1][x][h-i][w] + dp[y][x+i][h][w-i];
            dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
        }
        //재귀호출
        
        return dp[y][x][h][w];
    }
}