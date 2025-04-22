import java.io.IOException;
import java.util.*;

class Solution {
    public static int solution(int[][] triangle) {
        for (int i=1; i<triangle.length; i++){
            for (int j=0; j<triangle[i].length; j++){
                //왼쪽
                if (j==0){
                    triangle[i][j] += triangle[i-1][j];
                } else if (j==i){
                    triangle[i][j] += triangle[i-1][j-1];
                }else {
                    triangle[i][j] = triangle[i][j]+Math.max(triangle[i-1][j],triangle[i-1][j-1]);
                }
            }
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}