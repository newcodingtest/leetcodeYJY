package 프로그래머스.level1;

public class 치킨쿠폰 {
    public static int solution(int chicken) {
        return reculsive(chicken,0);
    }

    public static int reculsive(int target, int sum){
        if(target<10){
            return sum;
        }
        int newChiken = target/10;
        int restChicken = target%10;
        return reculsive(newChiken+restChicken,sum+newChiken);
    }
}
