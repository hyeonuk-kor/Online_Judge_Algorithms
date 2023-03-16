package baekjoon.빙산2;
import java.io.*;
import java.util.*;

public class Main {
    
    static int R, C;
    static int[][] map, delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<Position> q1 = new LinkedList<>();
    
    private static class Position {
        
        int r, c;
        
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        
        for(int r = 0; r < R; r++) {
            st = new StringTokenizer(in.readLine());
            
            for(int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                
                if(map[r][c] != 0)
                    q1.offer(new Position(r, c));
            }
        }
        
        System.out.println(sol());
        
    }
    
    private static int sol() {
        int res =0;
        Queue<Position> q2 = new LinkedList<>(), temp = new LinkedList<>();
        int counting =0;
        while(!q1.isEmpty()) {
            boolean[][] visited = new boolean[R][C];
            int cnt = 0;
            
            while(!q1.isEmpty()) {
                Position pos = q1.poll();
                
                if(!visited[pos.r][pos.c]) {
                    if(cnt++ == 1)
                        return res;
                    
                    temp.offer(pos);
                    visited[pos.r][pos.c] = true;
                    
                    while(!temp.isEmpty()) {
                        Position p = temp.poll();
                        
                        for(int d = 0; d < delta.length; d++) {
                            int r = p.r + delta[d][0], c = p.c + delta[d][1];
                            
                            if(vaild(r, c) && map[r][c] > 0 && !visited[r][c]) {
                                visited[r][c] = true;
                                temp.offer(new Position(r, c));
                            }
                        }
                    }
                }
                
                q2.offer(pos);
            }
            
            visited = new boolean[R][C];
            
            while(!q2.isEmpty()) {
                Position pos = q2.poll();
                cnt = 0;
                
                for(int d = 0; d < delta.length; d++) {
                    int r = pos.r + delta[d][0], c = pos.c + delta[d][1];
                
                    if(vaild(r, c) && map[r][c] == 0 && !visited[r][c])
                        cnt++;
                }
                
                if(map[pos.r][pos.c] <= cnt) {
                    map[pos.r][pos.c] = 0;
                    visited[pos.r][pos.c] = true;
                }
                else {
                    map[pos.r][pos.c] -= cnt;
                    q1.offer(pos);
                }
            }
            
            res++;

        }
        
        return 0;
    }
                    
    private static boolean vaild(int r, int c) {
        if(r >= 0 && r < R && c >=0 && c < C)
            return true;
        
        return false;
    }
    
}