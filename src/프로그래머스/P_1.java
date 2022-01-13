package 프로그래머스;

import java.util.Arrays;
import java.util.Collections;


class Solution {
     public static void main(String[] args){

          System.out.println( Arrays.toString(solution(12345)));
     }
     public static long[] solution(long n) {

          String[] test = String.valueOf(n).split("");
          long[] answer = new long[test.length];

          for(int i = 0; i<test.length; i++){
               answer[i]=Long.parseLong(test[i]);
          }


          for (int i=1; i<answer.length; i++){
               for(int j = i; j>=1; j--){
                    if(answer[j]>answer[j-1]){
                         long temp = answer[j];
                         answer[j] =answer[j-1];
                         answer[j-1] =  temp;
                    }
               }
          }

          return answer;

     }
}