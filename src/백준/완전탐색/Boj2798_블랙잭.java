package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2798_블랙잭 {
    static int N, targetSum;
    static int[] black;
    static boolean[] visited;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        targetSum = Integer.parseInt(st.nextToken());

        black = new int[N];
        visited = new boolean[N];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            black[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(black);
        perfactSearch(0,0,0);
        System.out.println(MAX);
    }

    private static void perfactSearch(int sum, int cnt, int idx) {
        if(cnt==3){
            MAX = Math.max(MAX,sum);
            return;
        }

        for(int i=idx; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                int newSum = sum+black[i];
                if(targetSum>=newSum) {
                    perfactSearch(newSum, cnt + 1,idx+1);

                }
                visited[i]=false;
            }
        }

    }
}
