package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_1373 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int length = input.length();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        if (length % 3 ==1){
            sb.append(input.charAt(0)-'0');
        }else if(length % 3 ==2){
            sb.append((input.charAt(0)-'0')*2+(input.charAt(1)-'0'));
        }

        for (int i = length % 3; i<length; i+=3){
            num = (input.charAt(i)-'0')*4+(input.charAt(i+1)-'0')*2+(input.charAt(i+2)-'0');
            sb.append(num);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
