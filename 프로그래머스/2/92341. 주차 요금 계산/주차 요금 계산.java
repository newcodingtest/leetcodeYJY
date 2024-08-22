import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Solution {
    static int defaultMin = 0;
    static int defaultFee = 0;
    static int overMin = 0;
    static int overFee = 0;
    //차 번호 : 하루 누적 주차시간
    static HashMap<String, String> parkInfo = new HashMap<>();
    static HashMap<String, Long> adjustment = new HashMap<>();
    public static int[] solution(int[] fees, String[] records) {
        defaultMin = fees[0];
        defaultFee = fees[1];

        overMin = fees[2];
        overFee = fees[3];

        for (String infos : records){
            String[] info = infos.split(" ");

            String time = info[0];
            String carNumber = info[1];
            String where = info[2];

            if (where.equals("OUT")){
//                if(!isOut[Integer.parseInt(carNumber)]){
//                    fee(parkInfo.get(carNumber), time);
//                }
                if(parkInfo.containsKey(carNumber)){
                    long min = minDiff(parkInfo.get(carNumber), time);
                    //long parkedFee = CalculateFee(min, fees);
                    adjustment.put(carNumber, adjustment.getOrDefault(carNumber,0L)+min);
                }
                parkInfo.remove(carNumber);
            } else {
                parkInfo.put(carNumber, time);
            }
        }

        for (String key : parkInfo.keySet()){
            long min = minDiff(parkInfo.get(key), "23:59");
            adjustment.put(key, adjustment.getOrDefault(key,0L)+min);
        }

     return adjustment.
                entrySet()
                .stream().sorted(Map.Entry.comparingByKey())
                .mapToInt(x -> (int) calculateFee(x.getValue()))
                .toArray();
    }

    public static long minDiff(String inTime, String outTime){
        LocalTime x = strHHMMToLocalTime(inTime);
        LocalTime y = strHHMMToLocalTime(outTime);

        Duration duration = Duration.between(x,y);

        return duration.toMinutes();
    }

    public static long calculateFee(long minutes){
        if (minutes<=defaultMin){
            return defaultFee;
        }

        Double result = defaultFee+(
                        Math.ceil(
                                (double)(minutes-defaultMin)/overMin
                        )*overFee
        );
        return result.longValue();
    }

    public static LocalTime strHHMMToLocalTime(String hhmm){
        String[] pattern = hhmm.split(":");

        int hh = Integer.parseInt(pattern[0]);
        int mm = Integer.parseInt(pattern[1]);

        return LocalTime.of(hh,mm);
    }
}