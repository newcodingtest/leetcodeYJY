import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //왼,오,위,아래
    static String[] op = {"-","+","*"};
    static boolean[] isVisited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(st.nextToken());
        int brother = Integer.parseInt(st.nextToken());

        System.out.print(bfs(subin, brother));
    }

    private static int bfs(int subin, int brother) {
        Queue<Information> q = new LinkedList<>();
        q.add(new Information(subin, 0));
        isVisited[subin]=true;

        while (!q.isEmpty()){
            Information now = q.poll();
            if (now.subin==brother){
                return now.seconds;
            }

            for (int i=0; i<3; i++) {
                int sum = calculate(now.subin, op[i]);
                if (sum>isVisited.length-1 || sum<0) continue;
                
                if (!isVisited[sum]){
                    isVisited[sum]=true;
                    q.add(new Information(sum, now.seconds+1));
                }
            }
        }
        return 0;
    }

    private static int calculate(int now, String op) {
        switch (op){
            case "+" : return now+1;
            case "-" : return now-1;
            case "*" : return now*2;
            default : return 0;
        }
    }

    static class Information {
        int subin;
        int seconds;

        public Information(int subin, int seconds){
            this.subin = subin;
            this.seconds = seconds;
        }
    }


}
