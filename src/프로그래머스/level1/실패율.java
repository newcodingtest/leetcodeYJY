package 프로그래머스.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 실패율 {
    static int[][] dp;
    static Map<Integer,Double> failure = new HashMap<>();
    public static void main(String[] args){
        int n = 4;
        int[] arr = {3,3, 3, 3};

        solution(n, arr);
    }
    public static int[] solution(int N, int[] stages) {
        final int length = N;
        dp = new int[3][N+2];
        double[] fail = new double[N+2];
        int totalUser = stages.length;

        for(int element : stages){
            dp[0][element]++;
        }

//        for(int test : dp[0]){
//            System.out.println("test = " + test);
//        }

        for (int i=1; i<=length; i++){
            if(totalUser>0) {
                fail[i] = (double) dp[0][i] / totalUser;

                totalUser = totalUser - dp[0][i];
            }else{
                fail[i] = 0 ;
            }
         // System.out.println(i+" "+fail[i]);
        }

        for (int i=1; i<=length; i++){
            failure.put(i,fail[i]);
        }
//        failure.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.compareTo(o1)))
//                .mapToInt(x -> x.getKey().intValue())
//                .forEach(System.out::println);


        return failure.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.compareTo(o1)))
                .mapToInt(x -> x.getKey().intValue())
                .toArray();
    }
}
