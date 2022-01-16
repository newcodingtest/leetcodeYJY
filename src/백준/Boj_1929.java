import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[b+1];
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <= i*i; i++) {
            for (int j = i*i; j < b+1; j+=i) {
                arr[j] = true;
            }
        }

        for (int i = a; i < b+1; i++) {
            if(!arr[i]) {
                System.out.println(i);
            }
        }
    }

}
