import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
        static int[][] userList;
    static int[] emoticonList;
    static int userCount = 0;
    static int earnMoney = 0;
    public static int[] solution(int[][] users, int[] emoticons) {
        userList = users;
        emoticonList = emoticons;
        int[] discountList = new int[emoticons.length];
        bfs(0,discountList);
              int[] answer = new int[2];
        answer[0]= userCount;
        answer[1] = earnMoney;
        return answer;
    }

    public static void bfs(int start,int[] discountList){
        if(start == discountList.length){
            //계산
            calculate(discountList);
            return;
        }

        for (int i=10; i<=40; i+=10){
            discountList[start] = i;
            bfs(start+1,discountList);
        }
    }

    public static void calculate(int[] discountList){
        int join = 0;
        int earn = 0;

        for(int[] user: userList){
            int discount = user[0];
            int goalPrice = user[1];
            int sum = 0;

            for (int i=0; i<discountList.length; i++){
                if (discountList[i]>=discount){
                    sum+=(emoticonList[i]/100)*(100-discountList[i]);
                }
            }

            //이모티콘 할인 금액을 샀을때 목표 금액에 달성한 사람이면 서비스 가입 후, 수입 제외
            if(sum>=goalPrice){
                join++;
            }
            //아닌 경우 수입에만 포함
            else {
                earn+=sum;
            }
        }

        //해당 유저가 서비스를 가입했으면 수입은 없음
        if(join>userCount){
            userCount = Math.max(userCount,join);
            earnMoney = earn;
        }
        //서비스 가입자가 이전과 동일 하다면 -> 이모티콘 구매시 가입 할당비 충족이 안됫기 때문에 가입은 안되고 수입으로 인지한다.
        else if(join==userCount){
            if(earnMoney<earn){
                earnMoney = Math.max(earnMoney,earn);
            }
        }
    }
}
