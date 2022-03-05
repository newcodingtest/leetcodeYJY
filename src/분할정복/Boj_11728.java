package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11728 {
    static int[] firstArr,secondArr,resultArr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        firstArr = new int[one];
        secondArr = new int[two];
        resultArr = new int[one+two];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<one; i++){
            firstArr[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<two; i++){
            secondArr[i]=Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<one; i++){
            resultArr[i]=firstArr[i];
        }
        for (int i=one; i<one+two; i++){
            resultArr[i]=secondArr[i-one];
        }
        Arrays.sort(resultArr);

        for(int target : resultArr){
            bw.write(target+" ");
        }
        bw.flush();
        bw.close();

    }
}
