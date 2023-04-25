package 프로그래머스.스택_큐;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};

        solution(prices);
    }
    //43110
    public static int[] solution(int[] prices) {
        int[] answer =new int[prices.length];

        for (int i=0; i<prices.length; i++){
            int cnt = 0;
            for (int j=i+1; j<prices.length; j++){
                cnt++;
                if(prices[i]>prices[j]){
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
