import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int count = 0 ;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        while(st.hasMoreTokens()) {

            boolean check = true;

            int num = Integer.parseInt(st.nextToken());

            if(num==1) {
                continue;
            }
            for(int i=2; i<=Math.sqrt(num); i++) {
                if(num%i==0) {
                    check = false;
                    break;
                }
            }

            if(check) {
                count++;
            }
        }
        System.out.println(count);

    }



}