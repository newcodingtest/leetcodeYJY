package 프로그래머스.level1;

public class 최빈값 {
    static int[] numbers = new int[1001];
    class Solution {
        public int solution(int[] array) {
            int max = 0;
            int answer = 0;
            for (int i=0; i<array.length; i++){
                numbers[array[i]]++;
            }
            for (int i=0; i<numbers.length; i++){
                if(numbers[i]>max){
                    max= numbers[i];
                    answer = i;
                }else if(numbers[i]==max){
                    answer = -1;
                }
            }

            return answer;
        }
    }
}
