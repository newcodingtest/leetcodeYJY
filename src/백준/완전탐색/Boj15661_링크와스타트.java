package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15661_링크와스타트 {
    static int N;
    static boolean[] visited;
    static int[][] map;
    static int team=0;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st = null;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (team=1; team<N; team++){
            reculsive(0,0);
        }
        System.out.println(MIN);

    }

    public static void reculsive(int depth, int start){
        if (depth==team ){
            int startTeam = 0;
            int linkTeam = 0;
            for (int i=0; i<N; i++){
                for (int j=i+1; j<N; j++){
                    //방문했으면 스타트팀
                    if(visited[i]&&visited[j]){
                        startTeam +=map[i][j]+map[j][i];
                    }
                    //아니면 링크팀
                    if(!visited[i]&&!visited[j]){
                        linkTeam +=map[i][j]+map[j][i];
                    }
                }
            }
            MIN = Math.min(MIN,Math.abs(startTeam-linkTeam));
            return;
        }

        for (int i = start; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                reculsive(depth+1,i+1);
                visited[i]=false;
            }
        }
    }
}