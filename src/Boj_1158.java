import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj_1158 {
    static Queue<Integer> list = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb.append("<");
        String[] input = br.readLine().split(" ");

        for (int i = 1; i<=Integer.parseInt(input[0]); i++){
            list.add(i);
        }

        int count = Integer.parseInt(input[1]);
        while(!list.isEmpty()){
            for (int i=0; i<count; i++){
             if(i==count-1){
                 sb.append(list.poll()+", ");
             }else{
                 list.add(list.poll());
             }
            }
        }
        bw.write(sb.substring(0,sb.length()-2)+">");
        bw.flush();
        bw.close();

    }


}
