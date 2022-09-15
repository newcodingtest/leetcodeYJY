package 프로그래머스.level2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class 주차요금계산 {
    static final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    static final String lastTime = "23:59";
    public static void main(String[] args) throws ParseException {
        int[] fees1 = {180,5000,10,600};
        String[] records1 ={"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                           "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                           "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] fees2 = {120, 0, 60, 591};
        String[] records2 ={"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        int[] fees3 = {1, 461, 1, 10};
        String[] records3 ={"00:00 1234 IN"};

        Arrays.stream(solution(fees3, records3)).forEach(x -> {
            System.out.println(x);
        });

    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        Map<Integer, InOutRecords> check = new ConcurrentHashMap<>();
        Map<Integer, Integer> accumulate = new HashMap<>();


        for(String info : records){
            String[] temp = info.split(" ");
            int key = Integer.valueOf(temp[1]);
            if(check.containsKey(key)){
                if(temp[2].equals("OUT")) {
                    int min = totalTimeByMin(check.get(key).getTime(),temp[0]);

                   // int totalFee = calculate(check.get(temp[1]).getTime(), temp[0], fees);
                    accumulate.put(key,accumulate.get(key)+min);
                    check.remove(key);
                }
            }else{
                check.put(key, new InOutRecords(temp[0],key,temp[2]));
                accumulate.put(key,accumulate.getOrDefault(key,0));
            }
        }
        
        //마지막 한번더 검사
        //마지막으로 계산제거가 안되고 남은요소는 23:59 OUT 으로 요금을 계산한다.
        if(check.size()>0) {
            Iterator<Integer> keys = check.keySet().iterator();
            while (keys.hasNext()) {
                int key = keys.next();
                //int totalFee = calculate(check.get(key).getTime(), "23:59", fees);
                int min = totalTimeByMin(check.get(key).getTime(), lastTime);
                accumulate.put(key, accumulate.get(key) + min);
                check.remove(key);
            }
        }
        //차량번호로 정렬필요
        return accumulate.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .mapToInt(value-> calculate(value.getValue(),fees))
                .toArray();
    }

    public static int totalTimeByMin(String from, String to) throws ParseException {
        Date d1 = sdf.parse(from);
        Date d2 = sdf.parse(to);

        return (int)(d2.getTime()-d1.getTime())/1000;
    }

    public static int calculate(int totalTime, int[] fees){
        int result = 0;   

        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        //출차-입차 기록이 기본시간을 초과한경우 초과비까지 계산
        if(totalTime>baseTime){
            result = baseFee+(int)Math.ceil((double)(totalTime-baseTime)/unitTime) * unitFee;
        }else{
            result = baseFee;
        }
        return (int)result;
    }
    static class InOutRecords{
        String time;
        int carNumber;
        String in_Out;

        int accumulate;

        public InOutRecords(String t, int carNm, String io){
            this.time = t;
            this.carNumber = carNm;
            this.in_Out = io;
        }

        public String getTime(){
            return this.time;
        }

        public String getIn_Out(){
            return this.in_Out;
        }

    }
}
