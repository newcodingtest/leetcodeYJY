package 백준.정렬.삽입;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};


        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {

                if (arr[j] < arr[j - 1]) {  //한 칸씩 왼쪽으로 이동
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                } else break;  //자기보다 작은 데이터를 만나면 그 위치에서 멈춤

            }
        }
        System.out.println(Arrays.toString(arr));
    }
}