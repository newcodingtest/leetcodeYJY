
import java.io.IOException;
import java.util.Arrays;

class Solution {
    static int[][] map;
    static boolean[][] mustChange;
    public static int[] solution(int columns, int rows, int[][] queries) {
        map = new int[columns][rows];

        int[] answer = new int[queries.length];
        int num = 1;
        for (int i = 0; i <columns ; i++) {
            for (int j = 0; j <rows ; j++) {
                map[i][j]= num++;
            }
        }

        for (int i = 0; i < queries.length ; i++) {
        mustChange = new boolean[columns][rows];
            int[] q = queries[i];
            int col1= q[0]-1;
            int row1= q[1]-1;
            int col2= q[2]-1;
            int row2= q[3]-1;

            int min = findBoundary(col1, row1, col2, row2);
            answer[i]= min;

            int[][] rotateMap = rotate(map, col1, row1, col2, row2);

            //2차원 깊은 복사
            map = rotateMap;
        }
        return answer;
    }

    public static int findBoundary(int col1, int row1, int col2, int row2){
        int min = Integer.MAX_VALUE;
        //왼쪽
        for (int i =col1; i <=col2 ; i++) {
            min = Math.min(min, map[i][row1]);
            mustChange[i][row1] = true;
        }

        //오른쪽
        for (int i = col1; i <=col2 ; i++) {
            min = Math.min(min, map[i][row2]);
            mustChange[i][row2] = true;
        }

        //위
        for (int i = row1+1; i <row2 ; i++) {
            min = Math.min(min, map[col1][i]);
            mustChange[col1][i] = true;
        }

        //아래
        for (int i = row1+1; i <row2 ; i++) {
            min = Math.min(min, map[col2][i]);
            mustChange[col2][i] = true;
        }
        return min;
    }
    public static int[][] rotate(int[][] map, int x1, int y1, int x2, int y2){
        int[][] swapMap = new int[map.length][map[0].length];

        //2차원 깊은 복사
        for (int i = 0; i < map.length ; i++) {
            System.arraycopy(map[i], 0, swapMap[i], 0, swapMap[0].length);
        }

        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j <map[0].length ; j++) {
                //변경 대상
                if (mustChange[i][j]){
                    //꼭지점 4개
                    // row++
                    if (i==x1 && j==y1){
                        swapMap[i][j+1] = map[i][j];
                    }
                    // col++
                    else if(i==x1 && j==y2){
                        swapMap[i+1][j] = map[i][j];
                    }
                    // row--
                    else if(i==x2 && j==y2){
                        swapMap[i][j-1] = map[i][j];
                    }
                    // col--
                    else if(i==x2 && j==y1){
                        swapMap[i-1][j] = map[i][j];
                    }
                    // 꼭지점을 제외한 4방향(왼,오,위,아래)
                    else {
                        int[] next = findSwapPoint(i,j,x1,y1,x2,y2);
                        swapMap[next[0]][next[1]] = map[i][j];
                    }

                }
            }
        }
        return swapMap;
    }

    public static int[] findSwapPoint(int col, int row, int x1, int y1, int x2, int y2){
        //4방향
        //왼
        if (row==y1){
            if (x1<col && col<x2){
                return new int[]{col-1, row};
            }
        }
        //오
        if (row==y2){
            if (x1<col && col<x2){
                return new int[]{col+1, row};
            }
        }
        //위
        if (col==x1){
            if (y1<row && row<y2){
                return new int[]{col, row+1};
            }
        }
        //아래
        if (col==x2){
            if (y1<row && row<y2){
                return new int[]{col, row-1};
            }
        }

        System.out.println(col+":"+row);
        return null;
    }

}