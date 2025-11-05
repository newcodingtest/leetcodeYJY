import java.util.HashSet;
import java.util.Set;

class Solution {
    static int N,M;
    static int MIN = Integer.MAX_VALUE;
     static Set<String> isVisited = new HashSet<>();
 public static int solution(int[][] info, int n, int m) {
        N = n;
        M = m;
        dfs(info, 0,0,0);

        return MIN==Integer.MAX_VALUE?-1:MIN;
    }


    public static void dfs(int[][] info, int a, int b, int cnt){
        if (cnt == info.length){
            if (N>a && M>b){
                MIN = Math.min(MIN, a);
            }
            return;
        }

        String key = a+","+b+","+cnt;
        if (isVisited.contains(key)) return;

        if (b+info[cnt][1]<M){
            dfs(info, a, b+info[cnt][1], cnt+1);
        }

        if (a+info[cnt][0]<N){
            dfs(info, a+info[cnt][0], b, cnt+1);
        }
        isVisited.add(key);
    }
}