package 프로그래머스.level1;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long sum = 0;
        while(count>0) {
            sum +=price*count--;
        }
        return sum<=money?0:sum-money;
    }
}
