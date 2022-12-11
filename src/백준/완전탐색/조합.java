package 백준.완전탐색;

import java.util.Arrays;

//조합
public class 조합 {

    static int arr[];
    static int numbers[];
    static int n = 5;
    static int r = 3;
    public static void main(String[] args) {

        arr = new int[] {1,2,3,4,5};
        numbers = new int[r];

        combi(0,0);
    }


    public static void combi(int start, int cnt) {
        if(cnt == r) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i=start;i<n;i++) {
            numbers[cnt] = arr[i];
            combi(i+1,cnt+1);
        }
    }
}
