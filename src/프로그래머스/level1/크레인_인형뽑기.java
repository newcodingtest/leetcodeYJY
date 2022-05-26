package 프로그래머스.level1;

import java.util.Stack;

public class 크레인_인형뽑기 {
    static Stack[] stack;
    static Stack<Integer> pick = new Stack<>();
    static int count=0;
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] move = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println( solution(board,move));
    }

    public static int solution(int[][] board, int[] moves) {
        final int length = board[0].length;
        stack = new Stack[length];

        for (int i = 0; i < length; i++) {
            stack[i]=new Stack<Integer>();
        }

        for (int i = length-1; i >=0; i--) {
            for (int j = 0; j < length; j++) {
                int element = board[i][j];
                if(element!=0){
                    stack[j].push(element);
                }

            }
        }

        for (int i = 0; i < moves.length; i++) {
            checkStack(moves[i]);
        }

        return count*2;
    }

    public static void checkStack(int input) {
        //인형 바구니열이 빈 경우
        if(!stack[input-1].isEmpty()){
            int value = (int)stack[input-1].pop();
            //바구니가 빈 경우
            if(pick.isEmpty()){
                //바구니에 넣는데
                pick.push(value);
            //바구니에 인형이 있는 경우
            }else{
                //바로 아래 있는 인형을 꺼내서 서로 다은 인형이면 넣는다.
                if (pick.peek() != value) {
                    pick.push(value);
                //서로 같은 인형이면 꺼내서 삭제시키고 카운팅 해준다.
                }else if(pick.peek() == value){
                    //삭제
                    pick.pop();
                    count++;
                }
            }
        }
    }
}
