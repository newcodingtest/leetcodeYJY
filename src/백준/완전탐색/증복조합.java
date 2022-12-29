package 백준.완전탐색;

import java.util.Arrays;

//조합
public class 증복조합 {
    static int arr[];
    static int numbers[];
    static int n = 3;
    static int r = 4;
    public static void main(String[] args) {

        arr = new int[] {1,2,3};
        numbers = new int[r];

        comRep(0);
    }

    public static void comRep(int cnt) {
        if(cnt == r) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i=0;i<n;i++) {
            numbers[cnt] = arr[i];
            comRep(cnt+1);
        }
    }
}
