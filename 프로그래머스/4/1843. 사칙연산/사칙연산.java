import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
class Solution {
      public static int solution(String arr[]) {
        int len = (arr.length+1)/2;
        int[][]  MAX_DP = new int[len][len];
        int[][]  MIN_DP = new int[len][len];

        IntStream.range(0, MAX_DP.length)
                .forEach(i -> Arrays.fill(MAX_DP[i], Integer.MIN_VALUE));
        IntStream.range(0, MIN_DP.length)
                .forEach(i -> Arrays.fill(MIN_DP[i], Integer.MAX_VALUE));

        //dp 초기화
        for (int i=0; i<len; i++){
            MAX_DP[i][i] = Integer.parseInt(arr[i*2]);
            MIN_DP[i][i] = Integer.parseInt(arr[i*2]);
        }

        for (int range=1; range<len; range++){
            for (int start=0; start<len-range; start++){
                int end = range+start;

                for (int k=start; k<end; k++){
                    if (arr[k*2+1].equals("+")){
                        MAX_DP[start][end] = Math.max(MAX_DP[start][end], MAX_DP[start][k]+MAX_DP[k+1][end]);
                        MIN_DP[start][end] = Math.min(MIN_DP[start][end], MIN_DP[start][k]+MIN_DP[k+1][end]);
                    } else {
                        MAX_DP[start][end] = Math.max(MAX_DP[start][end], MAX_DP[start][k]-MIN_DP[k+1][end]);
                        MIN_DP[start][end] = Math.min(MIN_DP[start][end], MIN_DP[start][k]-MAX_DP[k+1][end]);
                    }
                }
            }

        }

        return MAX_DP[0][len-1];
    }
}