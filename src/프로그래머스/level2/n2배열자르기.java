package 프로그래머스.level2;

import java.util.Arrays;

public class n2배열자르기 {
    public static int[] solution(int n, long left, long right) {
        int size = (int)(right-left);

        int[] answer = new int[size+1];

        for (int i=0; i<=size; i++){
            long num = left+i;
            long temp1 = num/n;
            long temp2 = num%n;

            if(temp1>=temp2){
                answer[i]=(int)temp1+1;
            }else{
                answer[i]=(int)temp2+1;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int n1 = 3;
        int left1 = 2;
        int right1 = 5;

        int n2 = 4;
        int left2 = 7;
        int right2 = 14;

        solution(n1,left1,right1);

    }
}
