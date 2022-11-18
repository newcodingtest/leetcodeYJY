package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj16439_치킨치킨치킨 {
    static int N,M;
    static boolean[] isVisited;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[M];
        arr = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                int idx = Integer.parseInt(st.nextToken());
                arr[i][j]=idx;
            }
        }

        dfs(0,0);

        System.out.println(result);
    }

    public static void dfs(int start, int deep){
        if(deep==3){
            int sum = 0;
            for (int i=0; i<N; i++){
                int max = 0;
                for (int j=0; j<M; j++){
                    if (isVisited[j]){
                        max = Math.max(max,arr[i][j]);
                    }
                }
                sum+=max;
            }
            result = Math.max(result,sum);
            return;
        }

        for (int i=start; i<M; i++){
            if (!isVisited[i]){
                isVisited[i]=true;
                dfs(start+1, deep+1);
                isVisited[i]=false;
            }
        }
    }
}
