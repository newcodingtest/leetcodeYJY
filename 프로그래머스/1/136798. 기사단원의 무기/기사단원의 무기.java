class Solution {
    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1; i<=number; i++){
            int cal = measure(i);
            if (cal>limit){
                answer+=power;
            } else {
                answer+=cal;
            }
        }
        return answer;
    }

    public static int measure(int n){
        int answer = 0;
        for (int i=1; i*i<=n; i++){
            if (i*i==n){
                answer++;
            } else if (n%i==0){
                answer+=2;
            }
        }
        return answer;
    }
}