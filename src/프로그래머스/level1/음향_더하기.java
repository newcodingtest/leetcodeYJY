package 프로그래머스.level1;

public class 음향_더하기 {
    public static void main(String[] args){

        int[] absolutes = {1,2,3,4};
        boolean[] signs = {true,false,true};

        System.out.println(solution(absolutes,signs));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;

        for (int i=0; i<signs.length; i++){
            if (!signs[i]){
                absolutes[i] = absolutes[i] * -1;
            }
            sum+=absolutes[i];
        }
        return sum;
    }
}
