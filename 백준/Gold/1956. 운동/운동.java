import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int V,E;
    static int[][] map;
    static int MAX = 100000000;
    static int ANS = MAX;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //운동을 한 후에는 다시 시작점으로 돌아오는 것
        //도로의 길이의 합이 가장 작은 사이클을 찾는 프로그램을 작성하시오
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V+1][V+1];
        Arrays.stream(map).forEach(x -> {
            Arrays.fill(x,MAX);
        });

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start][end] = cost;
        }


        for (int i=1; i<=V; i++){
            for (int j=1; j<=V; j++){
                for (int k=1; k<=V; k++){
                    if(j==k) continue;
                    map[j][k]=Math.min(map[j][k],map[j][i]+map[i][k]);
                }
            }
        }

        for (int i=1; i<=V; i++){
            for (int j=1; j<=V; j++){
                if(map[i][j]!=MAX && map[j][i]!=MAX){
                    ANS = Math.min(ANS,map[i][j]+map[j][i]);
                }
            }
        }

        System.out.println(ANS==MAX?-1:ANS);
    }
}

