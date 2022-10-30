package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2231_분해합 {
    static int N;
    static int length;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        N = Integer.parseInt(input);
        length = input.length();

        search();
    }

    public static void search(){
        int target = N;
        int result = 0;
            for (int i=(N-(length*9)); i<N; i++){
                int temp = i;
                int sum = 0;
                while(temp!=0) {
                    sum += temp % 10;
                    temp/=10;
                }

                if(sum+i == N){

                    result=i;
                    break;
                }
            }
        System.out.println(result);
    }
}
