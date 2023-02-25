package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj16637_괄호추가하기 {
    static int N;
    static List<Integer> nums = new ArrayList();
    static List<String> operations = new ArrayList();;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split("");
        for(int i=0; i<input.length; i++){
            if(i%2==0){
                nums.add(Integer.parseInt(input[i]));
            }else{
                operations.add(input[i]);
            }
        }

        dfs(nums.get(0),0);
        System.out.println(MAX);
    }

    public static void dfs(int value, int idx){
        //주어진 연산자들의 개수가 초과했을 경우
        if(idx>=operations.size()){
            MAX=Math.max(MAX,value);
            return;
        }

        //괄호 없는 경우 1 2 3 중에서 1 2 부터 계산
        int sum = calculate(value,nums.get(idx+1),operations.get(idx));
        dfs(sum,idx+1);

        //괄호 있는 경우
        // 1 2 3 중에서 2 3 부터 계산
        if(idx+1<operations.size()){
            //오른쪽 값들을 먼저 계산
            int sumtemp = calculate(nums.get(idx+1),nums.get(idx+2),operations.get(idx+1));
            //왼쪽에 남겨져 있는 값들을 재귀로 계산
            dfs(calculate(value,sumtemp,operations.get(idx)),idx+2);
        }

    }

    public static int calculate(int temp1 ,int temp2, String oper){
        switch (oper){
            case "+" :
                return temp1+temp2;
            case "-" :
                return temp1-temp2;
            case "*" :
                return temp1*temp2;
        }
        return 0;
    }


}
