package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_2331 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(a);

        while(true){
            int temp = list.get(list.size()-1);

            int result = 0;

            while(temp!=0){
                result += Math.pow(temp%10,b);
                temp /=10;
            }

            if(list.contains(result)){
                int ans = list.indexOf(result);
                bw.write(ans + "\n");
                break;
            }
            list.add(result);
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
