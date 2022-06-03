package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj10816_숫자카드 {
    static long[] card ;
    static Map<String,Integer> nums = new HashMap<>();
    static StringTokenizer st;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        card = new long[10000000];
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            String key = st.nextToken();
            nums.put(key, nums.getOrDefault(key,0)+1);
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            String key = st.nextToken();

            if(nums.containsKey(key)) {
                bw.write(nums.get(key)+" ");
            }else if(!nums.containsKey(key)) {
                bw.write(0+" ");
            }

        }

        bw.flush();
        bw.close();
    }
}
