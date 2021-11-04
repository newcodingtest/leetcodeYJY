package 백준;

import java.io.*;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;

public class Boj_1427 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();
        while(n>0){
            list.add(n%10);
            n/=10;
        }
        Collections.sort(list);
        Integer[] target = new Integer[list.size()];

        int min = Integer.MIN_VALUE;
       for(int i=list.size()-1; i>=0; i--){
          sb.append(list.get(i));
           }


        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
