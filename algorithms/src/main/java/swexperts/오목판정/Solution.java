package swexperts.오목판정;
import java.io.*;
public class Solution {
    static final int dy[] = {-1,-1,-1,0,0,1,1,1};
    static final int dx[] = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            char[][] board = new char[N][N];
            for(int i=0; i<N; i++) {
                board[i] = br.readLine().toCharArray();
            }
            String answer = getResult(N, board);
            bw.append("#"+tc+" "+answer+"\n");
        }
        bw.flush();
    }
    static String getResult(int size, char[][] board) {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(board[i][j]=='o') {
                    for(int d=0; d<7; d++) {
                        if(check(board, size, d, i, j, 1))
                            return "YES";
                    }
                }
            }
        }
        return "NO";
    }
    static boolean check(char[][] board, int size, int dir, int i, int j, int count) {
        if(count==5)
            return true;
        int ny = i + dy[dir];
        int nx = j + dx[dir];
        if(ny<0 || nx<0 || ny>=size || nx>=size || board[ny][nx]=='.')
            return false;
        return check(board, size, dir, ny, nx, count+1);
    }
}