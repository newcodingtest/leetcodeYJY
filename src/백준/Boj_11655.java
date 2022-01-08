package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11655 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int cal = 13;
        for (int i=0; i<input.length(); i++){
            int temp = input.charAt(i);

            if(65<=temp && temp<=90){
                temp+=13;
                if(temp>90){
                    int temp1 = temp-91;
                    temp = 65+temp1;
                }
            }else if(97<=temp && temp<=122){
                temp+=13;
                if(temp>122){
                    int temp1 = temp-123;
                    temp = 97+temp1;
                }
            }
            sb.append((char)temp);
        }
        System.out.println(sb.toString());
    }
}
