import java.util.*;
class Solution {
  static int answer = 0;
	
    public static int solution(int[] numbers, int target) {

        dfs(0, target, numbers, 0);
        return answer;
    }

    private static void dfs(int sum, int target, int[] number, int cnt) {
        if (number.length==cnt){
            if (sum==target){
                answer++;
            }
        } else {
            dfs(sum+number[cnt], target, number, cnt+1);
            dfs(sum-number[cnt], target, number, cnt+1);
        }
    }
}