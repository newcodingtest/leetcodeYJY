import java.time.LocalTime;
import java.util.*;

public class Solution {

        public static int solution(String[][] book_time) {

        Arrays.sort(book_time, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                return strToLocalDateTime(o1[0]).compareTo(strToLocalDateTime(o2[0]));
            }

        });

        int answer = 0;
        PriorityQueue<RoomTime> po = new PriorityQueue<>(Comparator.comparing(roomTime -> roomTime.endDt));

        for (int i=0; i<book_time.length; i++){
            String[] now = book_time[i];
            LocalTime nowStartDt = strToLocalDateTime(now[0]);
            LocalTime nowEndDt = strToLocalDateTime(now[1]);
            if (po.isEmpty()){
                answer++;
                po.offer(new RoomTime(nowStartDt, nowEndDt));
                continue;
            }

                RoomTime pre = po.poll();
                //[이전 종료 시간]이 [다음시간 시작 시간]보다 크면 => 현재 대실 종료 시간과 다음 대실 시작시간이 맞지 않으면 방이 더 필요함
                if (pre.endDt.plusMinutes(10).compareTo(nowStartDt)==1){
                    answer++;
                    po.offer(pre);
                }
                po.offer(new RoomTime(nowStartDt, nowEndDt));


        }

        return answer;
    }
    
    
    public static LocalTime strToLocalDateTime(String str){
        return LocalTime.parse(str);
    }

   public static class RoomTime{
        LocalTime startDt;
        LocalTime endDt;

        public RoomTime(LocalTime startDt, LocalTime endDt){
            this.startDt = startDt;
            this.endDt = endDt;
        }
    }
    

}
