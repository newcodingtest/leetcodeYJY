package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2745 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String target = st.nextToken();
        int input = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i =0; i<target.length(); i++){
            if('0'<=target.charAt(i) && '9'>=target.charAt(i)){
                result = result*input + ((int)target.charAt(i)-(int)'0');
            }else{
                result = result*input + ((int)target.charAt(i) - (int)'A' + 10);
            }
        }
        System.out.println(result);

    }
}
