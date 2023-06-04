package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bij2331_분해합v1 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i=1; i<N; i++){
            int sum = 0;
            int temp = i;
          while(temp>=10){
            sum+=temp%10;
            temp/=10;
           }
            sum+=temp;
            if((sum+i)==N){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
    //가장 작은 생성자
}
