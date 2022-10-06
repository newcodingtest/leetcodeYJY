package 백준.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
    }

    public static void solve(int seconds){
        
    }


    //경계면 찾아서 1초 제한시간 걸어주기
    public static void boundarySearch(){
        Queue<Node> q = new LinkedList<>();

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(cheeze[i][j]==0 && !visited[i][j]){
                    visited[i][j]=true;
                    q.add(new Node(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            Node n = q.poll();
            isValid(n.x, n.y);
        }
    }
    
    //1초인 경계면들 공기로 변경
    public static void changeCheezeToAir(){
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if(time[i][j]==1){
                  cheeze[i][j]=0;
                  //시간초기화
                  time[i][j]=0;
                }
            }
        }
    }

    public static void isValid(int x, int y){
        for (int i=0; i<4; i++){
            int nx = rows[i]+x;
            int ny = cols[i]+y;

            if(nx<0 || ny<0 || nx>N || ny>M){
                continue;
            }
            if(cheeze[nx][ny]==1 && !visited[nx][ny]){
                visited[nx][ny]=true;
                time[nx][ny]=1;
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
