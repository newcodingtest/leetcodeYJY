import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        map = new int[S];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<S; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        long sum = Long.MAX_VALUE;
        int idx = Integer.MAX_VALUE;

        for (int i=0; i<S; i++){
            int tmp = 0;
            for (int j = 0; j < S; j++) {
                tmp+=Math.abs(map[i]-map[j]);
            }
            if(tmp<sum){
                sum = tmp;
                idx = map[i];
            } else if(tmp==sum){
                sum = tmp;
                idx = Math.min(idx, map[i]);
            }
        }
        System.out.print(idx);
    }
}

