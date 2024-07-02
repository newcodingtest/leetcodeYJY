import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
/*
*  다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.
*
* 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
*
* 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
* */
     public static int solution(String[] friends, String[] gifts) {
        Map<String, Integer> nameIndex = new HashMap<>();


        int[][] history = new int[friends.length+1][friends.length+1];


        for (int i=1; i<=friends.length; i++){
            nameIndex.put(friends[i-1], i);
        }
        //선물점수 초기화
        Arrays.stream(history).forEach(row -> row[0]=-1);
        for (int i=0; i<gifts.length; i++){
            String[] info = gifts[i].split(" ");
            String sendPerson = info[0];
            String recvPerson = info[1];

            int sendIdx = findIndex(nameIndex, sendPerson);
            int recvIdx = findIndex(nameIndex, recvPerson);

            //sendIdx가 recvIdx에게 선물 보낸 개수 증가
            history[sendIdx][recvIdx]++;

            //선물점수 증가
            history[sendIdx][0]++;
            //선물점수 감소
            history[recvIdx][0]--;

        }
        //System.out.println(friends.length);
        //다음 날 선물 받을 사람 계산
        for (int i=1; i<=friends.length; i++){
            for (int j=1; j<=friends.length; j++){
                if (i!=j) {
                    //두 사람이 선물을 주고받은 기록이 있다면
                    if (history[i][j]>0 || history[j][i]>0){
                        //더 많은 선물을 준 사람은 다음 달 선물 하나 받는다.
                        if (history[i][j] > history[j][i]){
                            history[0][i]++;
                        } else if(history[i][j] == history[j][i]){
                            if (history[i][0]>history[j][0]){
                                history[0][i]++;
                            }
                        }
                    }  //두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수 작은 사람이 큰 사람에게 선물을 하나 준다.
                    else {
                        if (history[i][0]>history[j][0]){
                            history[0][i]++;
                        }
                    }
                }

            }
        }
        
        int answer = Arrays.stream(history[0],1, friends.length)
                        .max()
                        .getAsInt();
        return answer;
    }
    
    public static int findIndex(Map<String, Integer> nameIndex, String name){
        return nameIndex.get(name);
    }
}