import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<String> names = new HashSet<>();
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++){
            names.add(br.readLine());
        }

        for (int i=0; i<m; i++){
            String name = br.readLine();
            if (names.contains(name)){
                answer.add(name);
            }
        }
        Collections.sort(answer);

        System.out.println(answer.size());
        for (String str : answer){
            System.out.println(str);
        }
    }

}
