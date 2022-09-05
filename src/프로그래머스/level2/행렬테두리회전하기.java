package 프로그래머스.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 행렬테두리회전하기 {
    static int[][] nums;
    static int MIN;
    static Queue<Integer>q;
    public static int[] solution(int rows, int columns, int[][] queries) {
        nums = new int[rows+1][columns+1];

        int cnt = 0;
        for(int i=1; i<nums.length; i++){
            for(int j=1; j< nums[0].length; j++){
                ++cnt;
                nums[i][j]=cnt;

            }
        }
  
        int[] answer = new int[queries.length];
        int rotationCnt = 0;
        for(int[] point : queries){
            MIN = Integer.MAX_VALUE;
            rotate(point[0],point[1],point[2],point[3]);
            answer[rotationCnt++]=MIN;
        }

        return answer;
    }

    //{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
    //123
    //456
    //789
    public static void rotate(int row1, int col1, int row2, int col2){
        q = new LinkedList<>();

        //이전값을 저장하여 다음에 들어갈값에 대입된다.
        q.offer(nums[row1][col1]);
        //위+
        for(int i=col1+1; i<col2; i++){
            //이전값을 저장하여 다음에 들어갈값에 대입된다.
            q.offer(nums[row1][i]);
            nums[row1][i]=q.remove();
            MIN = Math.min(MIN, nums[row1][i]);
        }
        //오른+
        for(int i=row1; i<row2; i++){
            //다음 변경될 값 저장
            q.offer(nums[i][col2]);
            nums[i][col2]=q.remove();
            MIN = Math.min(MIN, nums[i][col2]);
        }
        //아래-
        for(int i=col2; i>col1; i--){
            //다음 변경될 값 저장
            q.offer(nums[row2][i]);
            nums[row2][i]=q.remove();
            MIN = Math.min(MIN, nums[row2][i]);
        }
        //왼-
        for(int i=row2; i>=row1; i--){
            //다음 변경될 값 저장
            q.offer(nums[i][col1]);
            nums[i][col1]=q.remove();
            MIN = Math.min(MIN, nums[i][col1]);
        }
    }

    public static void main(String[] args){
        int rows1 = 6;
        int cols1 = 6;
        int[][] queries1 = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int rows2 = 3;
        int cols2 = 3;
        int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};

        int rows3 = 100;
        int cols3 = 97;
        int[][] queries3 = {{1,1,100,97}};

        Arrays.stream(solution(rows2,cols2,queries2)).forEach(x -> {
            System.out.println("x = " + x);
        });
    }
}
