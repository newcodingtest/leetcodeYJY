package 프로그래머스.lgcns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class no_2 {
    static int k;
    static int[] limits = {2000,1000,3000,200,600,500};
    static List<Integer>[] list; //자식정보 저장리스트
    static List<Integer> plug;
    static int[] consumeInfo;
    static boolean[] visited;
    public static void main(String[] args){
        int[][]sockets = {{2,3,-1,-1,-1},{4,0,-1,-1,6},{5,0,0,0,0},{-1,0,0,0,0},{-1,-1,-1,-1,-1},{-1,-1,0,0,0}};
        solution(300, limits,sockets );
    }

    public static int solution(int k, int[] limits, int[][]sockets){
        int len = limits.length;

        plug = new ArrayList<>();
        consumeInfo = new int[len+1];
        visited = new boolean[len+1];
        list = new ArrayList[len+1];


        for (int i=1; i<=len; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<sockets.length; i++){
            int plugCnt = 0;
            for (int j=0; j<sockets[i].length; j++){
                if(sockets[i][j]<0){
                    plugCnt++;
                }else if(sockets[i][j]>0){
                    //자식 저장
                    list[i+1].add(sockets[i][j]);
                    //부모 저장
                    list[sockets[i][j]].add(i+1);
                }
            }
            plug.add(plugCnt);
        }

        //부모의 소비전력 구하기
         for (int i=1; i<=len; i++){
             consumeInfo[i]=cost(i)*k;
             System.out.println(cost(i)*k);
         }

         //소비전력>허용전력, 지점 찾기

        int answer = 0;
        return answer;
    }


    public static int cost(int n){
        Queue<Integer>temp = new LinkedList<>();
        temp.add(n);


        int sum = 0;
        while(!temp.isEmpty()){
            int x = temp.poll();
            visited[x]=true;
            //자식들 구하기
            for (int y:list[x]){
                if(!visited[y]) {
                    temp.add(y);
                    sum += plug.get(y-1);
                }
            }
        }
        return sum;

    }

    class Info{
        int plugCnt;
        int limit;
        int consumeCost;

        public Info(int cnt, int limit, int cost){
            this.plugCnt = cnt;
            this.limit = limit;
            this.consumeCost = cost;
        }

        public void setConsumeCost(int n){
            this.consumeCost = n;
        }
    }

}
