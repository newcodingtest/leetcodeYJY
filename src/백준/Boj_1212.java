package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_1212 {
    static String[] list = {"000","001","010","011","100","101","110","111"}; //0,1,2,3,4,5,6,7
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int temp = input.charAt(i)-'0';
            if(temp < 4 && i==0) {
                if(temp < 2) {
                    sb.append(list[temp].substring(2));
                }else {
                    sb.append(list[temp].substring(1));

                }

            }else {
                sb.append(list[temp]);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
