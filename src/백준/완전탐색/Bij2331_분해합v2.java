package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bij2331_분해합v2 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);

        int answer = 0;
        for (int i=1; i<N; i++){
            int sum = 0;
            String[] temp = String.valueOf(i).split("");
            for (int j=0; j<temp.length; j++){
                sum+=Integer.parseInt(temp[j]);
            }
            int result = i+sum;
            if(result==N){
                answer = i;
                break;
            }

        }
        System.out.println(answer);
    }
    //가장 작은 생성자
}
