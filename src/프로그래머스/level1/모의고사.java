package 프로그래머스.level1;
import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    static List<Integer> list = new ArrayList<Integer>();
    static int[] rank = new int[3];
    static int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    public int[] solution(int[] answers) {
        for(int i=0; i<rank.length; i++) {
            for(int j = 0; j<answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) {
                    rank[i]++;
                }
            }
        }

        int max = Math.max(rank[0], Math.max(rank[1], rank[2]));

        for(int i=0; i<rank.length; i++) {
            if(max == rank[i]) {
                list.add(i+1);
            }
        }

        int[] result = new int[list.size()];
        int cnt = 0;

        for(int value : list) {
            result[cnt++]=value;
        }

        return result;
    }
}
