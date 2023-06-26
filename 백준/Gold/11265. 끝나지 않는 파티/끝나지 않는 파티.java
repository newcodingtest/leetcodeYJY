import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int MIN = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();
    static boolean[] isVisited;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            //손님위치
            int A = Integer.parseInt(st.nextToken());
            //다음 파티장 위치
            int B = Integer.parseInt(st.nextToken());
            //파티장 OPEN 시간
            int C = Integer.parseInt(st.nextToken());

            if(map[A][B]<=C){
                sb.append("Enjoy other party"+"\n");
            }else{
                sb.append("Stay here"+"\n");
            }

        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    //모든 정점 구하기 => 플로이드 워셜
    public static void BFS() {
        //모든정점-모든정점 최단값 적용
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
    }
}

