package 백준.완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15686_치킨배달 {
    static int r,c;
    static int [][] map;
    static List<Node> chicken = new ArrayList<>();
    static int MIN = Integer.MAX_VALUE;
    static boolean[] visited;
    static List<Node> house = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for (int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==2){
                    chicken.add(new Node(i,j));
                }else if(map[i][j]==1){
                    house.add(new Node(i,j));
                }
            }
        }

        visited = new boolean[house.size()];
        solve(0,0,0);

        for (int )

        System.out.println(MIN);
    }

    static void solve(int start, int sum, int cnt){
        if(cnt==c){
            MIN = Math.min(MIN, sum);
            return;
        }

        for (int i=0; i<house.size(); i++){
            for (int j=0; j<chicken.size(); j++){
                if(!visited[i]){
                    visited[i]=true;
                    Node n1 = house.get(i);
                    Node n2 = chicken.get(j);

                    int temp = Math.abs(n1.col-n2.col)+Math.abs(n1.row-n2.row);
                    solve(i+1,sum+temp, cnt+1);
                    visited[i]=false;
                }

            }
        }
    }

    static class Node {
        int col;
        int row;

        public Node(int col, int row){
            this.col = col;
            this.row = row;
        }
    }
}
