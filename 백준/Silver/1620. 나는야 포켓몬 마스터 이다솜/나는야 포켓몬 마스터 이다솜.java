
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int answer = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i=1; i<=count; i++){
            String idx = String.valueOf(i);
            String name = br.readLine();
            map.put(idx, name);
            map.put(name, idx);
        }
        for (int i=0; i<answer; i++){
            String key = br.readLine();
            sb.append(map.get(key)).append(System.lineSeparator());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}