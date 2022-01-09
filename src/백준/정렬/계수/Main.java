package 백준.정렬.계수;


/*
* 특정 조건이 부합할때 매우 빠른 정렬 알고리즘
*
* 모든 데이터가 양의 정수인 상황에서 데이터 개수가 N
* 데이터 중에서 최대값이 K 일때 계수 정렬은 최악의 경우에도 O(N+K) 보장
*
* 그러나 계수 정렬은 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을때만 사용
* 데이터의 최소 최대의 차가 1,000,000을 넘지 않을때 효과적
* 이유는 계수 정렬은 모든 범위를 담을 수 있는 크기의 리스트를 선언해야 되기 때문
* */
public class Main {
    public static void main(String[] args){

        int[] arr = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};

        int[] count = new int[arr.length];

        for (int i=0; i<count.length; i++){
            count[arr[i]]+=1;
        }

        for (int i=0; i<count.length; i++){
            for (int j=0; j<count[i]; j++){
                System.out.printf("%d",i);
            }
        }
    }
}

