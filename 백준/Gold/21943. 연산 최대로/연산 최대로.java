import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

    static int[] nums;
    static int plusCnt = 0;
    static int multipleCnt = 0;
    static int[] target;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        nums = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<cnt; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        plusCnt = Integer.parseInt(st.nextToken());
        multipleCnt = Integer.parseInt(st.nextToken());
        target = new int[multipleCnt+1];

        dfs(0);
        System.out.println(answer);
    }
    
public static void dfs(int level){
        if (level == nums.length){
            int sum = Arrays.stream(target)
                    .reduce((x,y) -> x*y)
                    .getAsInt();

            answer = Math.max(answer, sum);
            return;
        }

        for (int i=0; i<target.length; i++){
            target[i] += nums[level];
            dfs(level + 1);
            target[i] -= nums[level];
        }
    }
}