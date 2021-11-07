package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Boj_18870 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] arr = new int[count];

        for (int i=0; i<count; i++){
            arr[i]=Integer.parseInt(input[i]);
        }

        int[] sortNum = arr.clone(); //2 4 -10 4 -9
        Arrays.sort(sortNum); // -10 -9 2 4 4

        Map<Integer,Integer> first = new HashMap<>();
        int check = 0;
        for (int n : sortNum){
            if(!first.containsKey(n)){
                first.put(n,check++);
            }
        }

        for (int n:  arr){
                sb.append(first.get(n)).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
