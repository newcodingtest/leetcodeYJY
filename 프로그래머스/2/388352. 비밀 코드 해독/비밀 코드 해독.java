import java.util.HashSet;
import java.util.Set;

class Solution {
        static int[] arr = new int[5];
    static int answer = 0;

 public static int solution(int n, int[][] q, int[] ans) {
        dfs(n,q,ans,1,0);
        return answer;
    }

    public static void dfs(int n, int[][] q, int[] ans, int start, int cnt){
        if (cnt==5){
            if (check(q,ans,arr)){
                answer++;
            }
            return;
        }

        for (int i=start; i<=n; i++){
            arr[cnt] = i;
            dfs(n,q,ans,i+1, cnt+1);
        }

    }

    private static boolean check(int[][] q, int[] ans, int[] arr) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < q[i].length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (q[i][j]==arr[k]){
                        cnt++;
                    }
                }
            }
            if (cnt!=ans[i]){
                return false;
            }
        }
        return true;
    }
      


}