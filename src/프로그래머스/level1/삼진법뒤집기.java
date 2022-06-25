package 프로그래머스.level1;

public class 삼진법뒤집기 {
    public static void main(String[] args){
        int n = 125;
        divide_3(n);

    }
    public static int solution(int n) {
        return divide_3(n);
    }

    public static int divide_3(int n){
        StringBuffer sb = new StringBuffer();

        int temp = n;
        while(temp>0){
            sb.append(temp%3);
            temp = temp/3;
        }
        sb.reverse();
       return divide_10(sb.toString());
    }

    public static int divide_10(String str){

        String[] arr = str.split("");
        int temp = 1;
        int result = 0;
        for(int i=0; i<=arr.length-1; i++){
            int test = Integer.parseInt(arr[i]);
            result +=test*temp;
            temp =temp*3;
        }
        System.out.println(result);
        return result;
    }
}
