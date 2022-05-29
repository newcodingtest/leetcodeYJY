package 프로그래머스.level1;

public class 내적 {
    public static void main(String[] args){

        int[] absolutes = {1,2,3,4};
        int[] signs = {-3,-1,0,2};

        System.out.println(solution(absolutes,signs));
    }

    public static int solution(int[] a, int[] b) {
        int sum = 0;
        for (int i=0; i<a.length; i++){
            sum+=a[i] * b[i];
        }
        return sum;
    }
}
