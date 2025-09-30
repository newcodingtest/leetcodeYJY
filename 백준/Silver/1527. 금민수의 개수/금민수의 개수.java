import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Map<Integer, Set<Long>> comb = new HashMap<>();
    public static void main(String[] args) throws IOException {
        setUp();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String x1 = st.nextToken();
        String x2 = st.nextToken();

        for (int i=1; i<=10; i++){
            dfs("",i,0);
        }

        List<Long> nums = comb.entrySet().stream()
                .filter(e -> e.getKey() >= x1.length() && e.getKey() <= x2.length())
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.toList());

        long start=Long.parseLong(x1);
        long end=Long.parseLong(x2);
        Collections.sort(nums);

        int answer = 0;
        for (Long num : nums){
            if (start<=num && end>=num){
                //System.out.println(num);
                answer++;
            }
            if (num>end){
                break;
            }
        }
        System.out.print(answer);

        // 10억개
    }
    private static void setUp(){
        for (int i=1; i<=10; i++){
            comb.put(i, new HashSet<>());
        }
    }

    public static void dfs(String s, int target, int now){
        if (target==now){
            comb.get(now).add(Long.parseLong(s));
            return;
        }
        dfs(s+"4", target, now+1);
        dfs(s+"7", target, now+1);
    }

}

