package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14391_종이조각 {
    static int N,M;
    static boolean[][] visited;
    static int[][] map;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            String[] str = br.readLine().split("");
            for (int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(str[j]);
            }
        }

        dfs(0,0);
        System.out.println(MAX);
    }

    //가로,세로 비트마스크
    //가로=true, 세로=false
    public static void dfs(int row, int col){
        if(row>=N){
            sum();
            return;
        }
        //한행 끝나면 다른행으로 이동
        if(col>=M){
            dfs(row+1,0);
            return;
        }
        //가로
        visited[row][col]=true;
        dfs(row,col+1);
        //세로
        visited[row][col]=false;
        dfs(row,col+1);
    }

    public static void sum(){
        int result = 0;
        int temp = 0;
        //가로
        for (int i=0; i<N; i++){
            temp = 0;
            for (int j=0; j<M; j++){
                if(visited[i][j]){
                    temp*=10;
                    temp+=map[i][j];
                }else{
                    result+=temp;
                    temp=0;
                }
            }
            result+=temp;
        }
        //세로
        for (int i=0; i<M; i++){
            temp = 0;
            for (int j=0; j<N; j++){
                if(!visited[j][i]){
                    temp*=10;
                    temp+=map[j][i];
                }else{
                    result+=temp;
                    temp=0;
                }
            }
            result+=temp;
        }
        MAX = Math.max(MAX,result);
    }
}
