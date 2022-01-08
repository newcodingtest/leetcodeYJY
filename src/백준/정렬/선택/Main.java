package 백준.정렬.선택;


import java.util.Arrays;

/*
* 가장 원시적인 방법
*
* 무작위 데이터 중에서
* 가장 작은 데이터를 선택해 맨 앞의 데이터와 바꾸고 그 다음 작은 데이터를 선택해
* 두번째 데이터와 바꾸는 과정을 반복한다.
*
* 시간복잡도
* 매번 작은 수를 찾기 위해 비교 연산이 필요하다.
* 시간 복잡도(O(N2))
* */
public class Main {
    public static void main(String[] args){
        int []arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int minIndex = 0; //가장 적은 원소의 인덱스

        for(int i=0; i < arr.length; i++){
            for(int j=i+1 ; j < arr.length; j++){
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            }

            //스와프
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
