package 프로그래머스.level2;

public class 타겟넘버 {
    static int cnt = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return cnt;
    }

    //@param(입력배열, 노드레벨, 합계, 목표치 )
    public static void dfs(int[] numbers, int deep, int sum, int target) {
        //마지막 노드까지 탐색한 경우
        if(numbers.length==deep) {
            if(target==sum) {
                cnt++;
            }
        }else {
            //해당 노드의 값을 더해서 dfs 탐색
            dfs(numbers,deep+1, sum+numbers[deep], target);
            //해당 노드의 값을 빼서 dfs 탐색
            dfs(numbers,deep+1, sum-numbers[deep], target);
        }
    }
}
