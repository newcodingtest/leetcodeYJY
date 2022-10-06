package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj2636_치즈 {

    static int[][] cheeze;
    static int[][] time;
    static boolean[][] visited;
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    static int N,M;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheeze = new int[N][M];
        time = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            for (int j=0; j<M; j++){
                cheeze[i][j] = Integer.parseInt(str[j]);
            }
        }

        start();
    }


    public static void start(){
        int result = 0;
        int cnt = 0;
        System.out.println(count());
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
               if(cheeze[i][j]==0 && !visited[i][j]){
                 int test =   boundarySearch(i,j);
                   System.out.println("cheeze cnt = " + test);
                    ++cnt;
               }
            }
            System.out.println("count() = " + count());
        }
        System.out.println("seconds = " + cnt);
    }
    public static int count(){
      int cnt = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(cheeze[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }


    //경계면 찾아서 1초 제한시간 걸어주기
    public static int boundarySearch(int row, int col){
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(row,col));
        visited[0][0]=true;

        int cnt = 0;
        while(!q.isEmpty()){
            Node n = q.poll();
            putTime(n.x, n.y);
            changeCheezeToAir();
            ++cnt;
        }
        return count();
    }
    public static void putTime(int x, int y){
        for (int i=0; i<4; i++){
            int nx = rows[i]+x;
            int ny = cols[i]+y;

            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    if(cheeze[nx][ny]==1){
                        time[nx][ny]=1;
                    }else{
                        putTime(nx,ny);
                    }

                }
            }
        }
    }
    //1초인 경계면들 공기로 변경
    public static void changeCheezeToAir(){
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(time[i][j]==1){
                    changeAir(i,j);
                }
            }
        }
    }

    public static void changeAir(int x, int y){
        for (int i=0; i<4; i++){
            int nx = rows[i]+x;
            int ny = cols[i]+y;

            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(cheeze[nx][ny]==1){
                        cheeze[nx][ny]=0;
                }
            }
        }
    }


    static class Node{
        int x;
        int y;

        public Node(int row, int col){
            this.x = row;
            this.y = col;
        }
    }

}
