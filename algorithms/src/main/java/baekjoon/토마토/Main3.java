package baekjoon.토마토;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main3 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br=new BufferedReader(new FileReader(new File(s)));
        }
        String nextLine(){
            String str="";
            try{
                str=br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
        String next(){
            while(st==null||!st.hasMoreTokens()){
                try{
                    st=new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.valueOf(next());
        }
        long nextLong(){
            return Long.valueOf(next());
        }
        Double nextDouble(){
            return Double.valueOf(next());
        }
    }
    static FastReader r=new FastReader();
    static int M,N,H;
    static int[][][] tomatoes;
    static boolean[][][] visited;
    static int[][] dir={
            {0,0,1},
            {0,0,-1},
            {0,1,0},
            {0,-1,0},
            {1,0,0},
            {-1,0,0}
    };
    static int[][][] dist;
    static int max=Integer.MIN_VALUE;
    static void input(){
        M=r.nextInt();
        N=r.nextInt();
        H=r.nextInt();
        tomatoes=new int[H][N][M];
        dist=new int[H][N][M];
        visited=new boolean[H][N][M];
        //모든 토마토가 익었는지 확인
        int chk=0;
        //토마토가 없는 경우
        int no=0;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    tomatoes[i][j][k]=r.nextInt();
                    if(tomatoes[i][j][k]==1){
                        chk++;
                    }else if(tomatoes[i][j][k]==-1){
                        no++;
                    }
                }
            }
        }
    }
    static void bfs(){
        //multisource- bfs
        Queue<int[]> que=new LinkedList<>();
        //익은 것을 시작점으로 생각하기
        int x=0,y=0,z=0;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(tomatoes[i][j][k]==1){
                        visited[i][j][k]=true;
                        que.add(new int[]{i,j,k});
                    }
                }
            }
        }
        while(!que.isEmpty()){
            int[] temp=que.poll();
            x=temp[0];
            y=temp[1];
            z=temp[2];
            for(int cand=0;cand<6;cand++){
                int nextX=x+dir[cand][0];
                int nextY=y+dir[cand][1];
                int nextZ=z+dir[cand][2];
                if(nextX<0 || nextY<0 || nextZ<0||
                        nextX>=H || nextY>=N || nextZ>=M) continue;
                if(visited[nextX][nextY][nextZ]) continue;
                if(tomatoes[nextX][nextY][nextZ]!=0) continue;//토마토가 없는 경우, 익은경우는 스킵
                //if(tomatoes[nextX][nextY][nextZ]==1) continue;//익은경우
                visited[nextX][nextY][nextZ]=true;
                que.add(new int[]{nextX,nextY,nextZ});
                tomatoes[nextX][nextY][nextZ]=1;
                dist[nextX][nextY][nextZ]=dist[x][y][z]+1;
            }
        }
    }
    static void pro(){
        bfs();
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(tomatoes[i][j][k]==0){
                        System.out.println(-1);
                        System.exit(0);
                    }
                   if(dist[i][j][k]>max){
                       max=dist[i][j][k];
                   }
                }
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}