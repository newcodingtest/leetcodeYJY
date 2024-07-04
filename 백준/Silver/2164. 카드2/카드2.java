import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=count; i++){
            q.add(i);
        }
        sb.append(calculate(q));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int calculate(Queue<Integer> q){
        while (q.size()>1){
            int trash = q.poll();
            int tail = q.poll();

            q.add(tail);
        }
        return q.poll();
    }
}
