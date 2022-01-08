package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11005 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());

        List<Character> list = new ArrayList<>();

        while(target>0){
            if(target%input < 10){
                list.add((char)(target%input+'0'));
            }else{
                list.add((char)(target%input-10+'A'));
            }
            target/=input;
        }

        for(int i=list.size()-1; i>=0; i--)
            System.out.print(list.get(i));
    }


}
