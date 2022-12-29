package 백준.완전탐색;

import java.util.Arrays;

//순열
public class 순열 {
    static int arr[];
    static boolean isSelected[];
    static int numbers[];
    static int n = 5;
    static int r = 5;

    public static void main(String[] args) {
        arr= new int[]{1,2,3,4,5};
        isSelected = new boolean[r];
        numbers = new int[r];

        per(0);
    }

    public static void per(int cnt) {
        if(cnt==r) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i=0;i<n;i++) {
            if(isSelected[i])continue;
            numbers[cnt] = arr[i];
            isSelected[i] = true;
            per(cnt+1);
            isSelected[i] = false;
        }
    }

}
