package 프로그래머스.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 최소직사각형 {
    public static void main(String[] args){
        int[][] test1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] test2 = {{10,7}, {12, 3}, {8, 15}, {14, 7}, {5,15}};
        int[][] test3 = {{14, 4}, {19, 6}, {18, 7}, {7, 11}};

        solution(test2);
    }

    public static int solution(int[][] sizes) {
        int max_x=0;
        int max_y=0;

        for(int i=0;i<sizes.length;i++){
            int temp_x=Math.max(sizes[i][0],sizes[i][1]);
            int temp_y=Math.min(sizes[i][0],sizes[i][1]);
            max_x=Math.max(temp_x,max_x);
            max_y=Math.max(temp_y,max_y);
        }
        return max_x*max_y;
    }
}
