
import java.util.*;
class Solution {
      public static int solution(String s) {
        int answer = 0;
        char pre = s.charAt(0);
        int cnt = 0;
        for (char c : s.toCharArray()){
            if (cnt == 0){
                pre = c;
            }
            if (pre == c){
                cnt++;
            } else {
                cnt--;
            }

            if (cnt==0){
                answer++;
            }
        }
        if (cnt>0){
            answer++;
        }

        return answer;
    }
}