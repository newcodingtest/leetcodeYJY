import java.util.*;
class Solution {
    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] answer = {};

        for (int i=0; i<players.length; i++){
            map.put(players[i], i);
        }

        for (String callsign : callings){

            int idx = map.get(callsign);
            if (idx>0){
                String win = players[idx];
                String lose = players[idx-1];

                players[idx-1] = win;
                players[idx] = lose;

                map.put(callsign, map.get(callsign)-1);
                map.put(lose, map.get(callsign)+1);
            }
        }
        return players;
    }
}