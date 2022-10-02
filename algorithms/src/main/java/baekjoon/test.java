package baekjoon;
import java.io.*;

public class test {
    
    static int N, ans = Integer.MAX_VALUE;
    static boolean[][] map;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            String str = in.readLine();
            
            for(int j = 0; j < N; j++)
                if(str.charAt(j) == 'H')
                    map[i][j] = true;
        }
        
        sol(0);
        System.out.println(ans);
        
    }
    
    private static void sol(int idx) {
        if(idx == N) {
            int cnt = 0;
            
            for(int r = 0; r < N; r++) {
                int H = 0;
                
                for(int c = 0; c < N; c++)
                    if(map[r][c])
                        H++;
                
                cnt += Math.min(H, N - H);
            }
            
            ans = Math.min(ans, cnt);
            return;
        }
        
  
        sol(idx + 1);
        
        for(int r = 0; r < N; r++)
            map[r][idx] = !map[r][idx];
        sol(idx + 1);
    }
    
}