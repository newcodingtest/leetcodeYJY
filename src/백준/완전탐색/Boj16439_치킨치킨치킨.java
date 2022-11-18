package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16439_치킨치킨치킨 {
    static int N,M;
    static Map<Integer,Integer> cnt = new HashMap<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                int idx = Integer.parseInt(st.nextToken());
                cnt.put(j+1,cnt.getOrDefault(j+1,0)+idx);
            }
        }

        int []sortedCnt = cnt.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> {
                    return o2.intValue()-o1.intValue();
                }))
                .mapToInt(value -> value.getKey())
                .toArray();

        Arrays.stream(sortedCnt).forEach(x -> {
            System.out.print(x);
        });

    }
}
