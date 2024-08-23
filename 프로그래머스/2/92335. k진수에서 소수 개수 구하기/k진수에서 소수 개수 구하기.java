import java.util.*;
class Solution {
  
    public static int solution(int n, int k) {
        String bin = changeBinary(n,k);
        List<Long> nums = extractionNumber(bin);
        int answer = 0;
        for (long num : nums){
            if (isPrimeNumber(num)){
                answer++;
            }
        }
        return answer;
    }

    public static String changeBinary(int n, int k){
        int tmp = n;
        StringBuilder sb = new StringBuilder();
        while (tmp!=0){
            int quotient = tmp/k;
            int remainder = tmp%k;

            tmp = quotient;
            sb.append(remainder);
        }

        return sb.reverse().toString();
    }

    public static List<Long> extractionNumber(String str){
        List<Long> nums = new ArrayList<>();
        String[] arr = str.split("0");

        for (String elem : arr){
            String result = elem.trim();
            if (result.length()>0){
                nums.add(Long.parseLong(result));
            }
        }
        return nums;
    }

    public static boolean isPrimeNumber(long n){
        if (n==1){
            return false;
        }
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}