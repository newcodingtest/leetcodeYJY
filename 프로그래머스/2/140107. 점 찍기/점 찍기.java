
class Solution {
    public static long solution(int k, int d) {
        long answer = 0;

        //x^2+y^2
        for (int i= 0; i<=d; i+=k){
            //현재 i 에서, j의 최대값을 구할 수 있음
            //최대값에서 d+1을 나눠주면 개수가 나옴, d+1의 이유는 (0,0) 좌표도 포함하기 때문
            long maxY = (long) Math.sqrt(Math.pow(d,2)-Math.pow(i,2));
            answer += maxY / k + 1;
        }
        return answer;
    }
}