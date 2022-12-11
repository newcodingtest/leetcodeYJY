package 백준.완전탐색;

import java.util.Arrays;

//중복순열
public class 중복순열 {

    static int arr[];
    static int numbers[];
    static int n = 5;
    static int r = 3;
    public static void main(String[] args) {

        arr = new int[] {1,2,3,4,5};
        numbers = new int[r];

        perRep(0);
    }

    public static void perRep(int cnt) {
        if(cnt == r) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i=0;i<n;i++) {
            numbers[cnt] = arr[i];
            perRep(cnt+1);
        }
    }


}
