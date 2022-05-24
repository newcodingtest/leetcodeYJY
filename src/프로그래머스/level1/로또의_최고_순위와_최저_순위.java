package 프로그래머스.level1;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
    static int[] resultRank = new int[2];
    public static int[] solution(int[] lottos, int[] win_nums) {

        int[] myNumber = lottos;
        int[] winNumber = win_nums;
        Arrays.sort(myNumber);
        Arrays.sort(winNumber);

        int minCase=min(myNumber, winNumber);
        int maxCase=max(myNumber, winNumber);

        resultRank[0]=rank(maxCase);
        resultRank[1]=rank(minCase);;

        return resultRank;
    }

    public static int max(int[] my, int[] win) {
        int count = 0;
        int zeroCase = 0;


        for (int i = 0; i < my.length; i++) {
            for (int j = 0; j < win.length; j++) {
                if(my[i]==win[j]) {
                    count++;
                    break;
                }else if(my[i]==0) {
                    zeroCase++;
                    break;
                }
            }
        }
        return count+zeroCase;
    }

    public static int min(int[] my, int[] win) {
        int count = 0;
        int zeroCase = 0;


        for (int i = 0; i < my.length; i++) {
            for (int j = 0; j < win.length; j++) {
                if(my[i]==win[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    public static int rank(int count) {
        switch (count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
