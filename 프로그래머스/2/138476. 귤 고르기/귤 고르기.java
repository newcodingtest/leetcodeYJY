import java.util.Arrays;
class Solution {
     //키, 값 세팅
    //값 기준으로 내림차순 정렬
    //k-값 연산 하면서 0에 수렴할 때까지
       public static int solution(int k, int[] tangerine) {
        int answer = 0;
        int result = k;
        Arrays.sort(tangerine);

        int[] temp = new int[tangerine[tangerine.length-1]+1];

        for (int i=0; i<tangerine.length; i++){
            temp[tangerine[i]]++;
        }

        Arrays.sort(temp);

        for (int i=temp.length-1; i>0; i--){

               if (result<=0){
                break;
            }

            result-=temp[i];
            answer++;

        }
        return answer;
    }
}