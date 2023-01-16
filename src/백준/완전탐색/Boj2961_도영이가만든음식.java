package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2961_도영이가만든음식 {
    static int N;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;
    static Cook[] cooks;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        cooks = new Cook[N];
        StringTokenizer st = null;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            cooks[i]=new Cook(sour,bitter);
        }

        BFS(0,1,0,0);

        System.out.println(MIN);
    }

    public static void BFS(int cnt,int first, int second, int deep){
        if(cnt==N){
            if(MIN>Math.abs((first-second)) && deep!=0){
                MIN = Math.abs((first-second));
            }
            return;
        }

        BFS(cnt+1,
                first,
                second,
                deep);

            BFS(cnt+1,
                    first*cooks[cnt].sourTaste,
                    second+cooks[cnt].bitterTaste,
                    deep+1);


    }

    static class Cook {
        int sourTaste;
        int bitterTaste;

        public Cook(int sourTaste, int bitterTaste){
            this.sourTaste = sourTaste;
            this.bitterTaste = bitterTaste;
        }
    }
}
