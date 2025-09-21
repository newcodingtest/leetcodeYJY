import java.util.*;
class Solution {
  static int answer = 0;
	
     public static int solution(int[] numbers, int target) {

        bfs(numbers, target, numbers.length);
        return answer;
    }

    public static void bfs(int[] numbers, int target, int len){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});// 합계, 길이

        while (!q.isEmpty()){
            int[] now = q.poll();
            int nowSum = now[0];
            int nowLen = now[1];

            if (nowLen==len){
                if (nowSum==target){
                    answer++;
                }
            } else {
                q.add(new int[]{nowSum+numbers[nowLen], nowLen+1});
                q.add(new int[]{nowSum-numbers[nowLen], nowLen+1});
            }
        }

    }
}