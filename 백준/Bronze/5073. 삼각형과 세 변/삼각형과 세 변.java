import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len1;
        int len2;
        int len3;

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
             len1 = Integer.parseInt(st.nextToken());
             len2 = Integer.parseInt(st.nextToken());
             len3 = Integer.parseInt(st.nextToken());

             if (len1==0 && len2==0 && len3==0){
                 break;
             }
            System.out.println(solution(len1,len2,len3));
        }
    }

    public static String solution(int len1, int len2, int len3){
        if (len1==len2 && len2==len3){
            return "Equilateral";
        }

        int[] order = new int[3];
        order[0] = len1;
        order[1] = len2;
        order[2] = len3;
        Arrays.sort(order);

        if (order[0]+order[1]<=order[2]){
            return "Invalid";
        }

        if (order[0]==order[1] || order[1]==order[2]){
            return "Isosceles";
        }
        return "Scalene";
    }
}
