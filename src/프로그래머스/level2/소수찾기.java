package 프로그래머스.level2;

import java.util.HashSet;

public class 소수찾기 {
    static HashSet<Integer>sosu = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(solution("17"));

    }

    public static int solution(String numbers) {

        reculsive("",numbers);
        return sosu.size();
    }

    //문자열로 만들수 있는 모든 숫자의 경우의수 기입
    public static void reculsive(String target, String others){
        if(!target.equals("")){
            int temp = Integer.parseInt(target);
            if(isValid(temp)){
                sosu.add(temp);
            }
        }

        for (int i=0; i<others.length(); i++){
            reculsive(target+others.charAt(i),others.substring(0,i)+others.substring(i+1));
        }
    }

    //143
    //11 x 13 = 143이고, 143은 2,3,5,7로 나눠지지 않는 수이지만 소수가 아닙니다.
    //그러기 때문에 단순 2357 으로 비교하는 조건만으로는 필터링이 안된다.
    public static boolean isValid(int num){
        if(num==0 || num==1){
            return false;
        }

        //최대치
        int limit =(int)Math.sqrt(num);

        for (int i=2; i<=limit; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }


}
