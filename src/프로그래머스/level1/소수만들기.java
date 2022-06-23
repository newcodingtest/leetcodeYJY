package 프로그래머스.level1;

public class 소수만들기 {
    public static void main(String[] args){
        int[] test = {1,2,3,4};
    }

    public static int solution(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(check(nums[i]+nums[j]+nums[k])) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean check(int n) {
        if (n <= 1) return false;    // 1은 소수가 아니다.
        if (n <= 3) return true;    // 2와3은 소수이다.
        if (n % 2 ==0) return false;
        for(int i = 3; i <= Math.sqrt(n); i+=2) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
