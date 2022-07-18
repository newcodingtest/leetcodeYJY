package 프로그래머스.level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    static List<Map<String,String>>intrance = new LinkedList<>();
    static Map<String,String>userInfo = new HashMap<>();
    public static void main(String[] args){
        String[] test= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}
    }


    public String[] solution(String[] record) {
        String[] answer = record;


        return answer;
    }

    public static void behavior(String str){
        String[] tmpUserInfo = str.split(" ");
        switch (tmpUserInfo[0]){
            case "Enter":
                userInfo.put(tmpUserInfo[1],tmpUserInfo[2]+"님이 들어왔습니다");
                intrance.add(userInfo);
                break;
            case "Leave":
                userInfo.put(tmpUserInfo[1],tmpUserInfo[2]+"님이 나갔습니다.");
                intrance.add(userInfo);
                break;
            case "Change":

                intrance.add(userInfo);
                break;
        }
    }

    //채팅방을 들어오고 나가고 닉네임을 변경하고 다시 들어왔을때
    public static void whenNameIsChangedAndEnter(String uuid, String changedName){
        
        
        if(userInfo.containsKey(uuid)){

        }
    }
}
