package 백준.정렬.퀵;

import java.util.Arrays;

// 참고:   https://scshim.tistory.com/267
/*
* 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘
*
* 퀵 정렬은 기준을 설정한 다음 큰 수와 작은 수를 교환한 후 리스트를 반으로 나누는 방식
* 피벗의 위치에 따라서 효율이 극명하게 나뉜다.
*
* 현재 방식은 호어 분할 방식을 채택한 것이다.
* 호어 분할 방식은 리스트에서 첫 번째 데이터를 피벗으로 정한다.
* */
public class Main {
    public static void main(String[] args){

        int array[] = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(array, 0, array.length -1);

        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int array[], int start, int end){

        if(start>=end){//원소가 1개인 경우 종료
            return;
        }

        int pivot = start; //피봇은 첫번째 원소
        int left = start+1;
        int right = end ;

        while(left <= right){

            //피벗보다 큰 데이터를 찾을 때 까지 반복복
            while(left <= end && array[left] <= array[pivot]){
                left+=1;
            }
            //피벗보다 작은 데이터를 찾을 때 까지 반복
            while(right > start && array[right] >= array[pivot]){
                right-=1;
            }

            if(left > right){ // 엇갈렸다면 작은 데이터와 피벗을 교체
                int tmp = array[right];
                array[right] = array[pivot];
                array[pivot] = tmp;
            }else{ //엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
                int tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
            }

            //분할 이후 왼쪽 부분과 오른쪽 부분에서 각 정렬 수행
            quickSort(array, start, right-1);
            quickSort(array, right+1, end);

         }
        }
    }

