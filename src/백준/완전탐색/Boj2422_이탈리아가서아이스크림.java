package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2422_이탈리아가서아이스크림 {
    static int N,M;
    static List<Integer>[] list;
    static boolean[] isVisited;
    static int way = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        isVisited = new boolean[N+1];

        for (int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        for (int i=1; i<=N; i++){
            isVisited = new boolean[N+1];
                dfs(i,1);
        }
        System.out.println(way);
    }

    public static void dfs(int start,int cnt){
        if(cnt ==3 ){
            way++;
            return;
        }

        for (int i=start+1; i<=N; i++){

            for (int elem : list[start]){
                isVisited[elem]=true;
            }

            if(!isVisited[i]){
                isVisited[i]= true;
                dfs(i,cnt+1);
                isVisited[i]=false;
            }

            for (int elem : list[start]){
                isVisited[elem]=false;
            }

        }
    }

    public static boolean isValid(int i, int n){
        for (int elem : list[n]){
            if(i==elem){
              return false;
            }
        }
        return true;
    }
}
