package 프로그래머스.level2;

import java.util.ArrayList;
import java.util.List;

public class 하노이탑 {
    static int N;
    static List<int[]> moveList = new ArrayList<>();
    static int idx = 0;
    public static void main(String[] args){
        //move(1,3,2,0);

        solution(2);
    }

    public static int[][] solution(int n) {
        N = n;
        move(1,3,2,0);
        int[][] answer = new int[moveList.size()][];

        for (int i=0; i<moveList.size(); i++){
            answer[i]=moveList.get(i);
        }
        return answer;
    }

    //1,3,2
    public static void move(int from, int temp, int to,int k){
        if(k == 2){
            return;
        }

        move(from,to,temp,k+1);
        moveList.add(new int[]{from,to});
        move(temp,to,from,k+1);
    }
}
