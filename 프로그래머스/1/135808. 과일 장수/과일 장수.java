
import java.util.*;
class Solution {
     public static int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;

        int start = score.length-1;
        for (int i=0; i<score.length/m; i++){
            int min = Integer.MAX_VALUE;
            for (int j = start; j>start-m; j--){
                min = Math.min(min, score[j]);

            }
            start-=m;
            answer+=min*m;
        }

        return answer;
    }
}