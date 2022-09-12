package 프로그래머스.level2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class 주차요금계산 {

    public static void main(String[] args) throws ParseException {
        int[] fees1 = {180,5000,10,600};
        String[] records1 ={"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                           "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                           "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] result1 = {14600, 34400, 5000};

        int[] fees2 = {120, 0, 60, 591};
        String[] records2 ={"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        int[] result2 = {0, 591};

        Arrays.stream(solution(fees1, records1)).forEach(x -> {
            System.out.println(x);
        });

    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        Map<String, InOutRecords> check = new LinkedHashMap<>();
        List<Integer> answer = new ArrayList<>();

        for(String info : records){
            String[] temp = info.split(" ");
            if(check.containsKey(temp[1])){
                if(check.get(temp[1]).getIn_Out().equals("IN")) {
                    int totalFee = calculate(check.get(temp[1]).getTime(), temp[1], fees);
                    answer.add(totalFee);
                    check.remove(temp[1]);
                }
            }else{
                check.put(temp[1], new InOutRecords(temp[0],temp[1],temp[2]));
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int calculate(String start, String end, int[] fees) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        Date d1 = sdf.parse(start);
        Date d2 = sdf.parse(end);

        double result = 0;
        long diff = d2.getTime()-d1.getTime();

        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if(diff>baseTime){
            result = Math.ceil((diff-baseTime)/unitTime) * unitFee;
        }else{
            result = baseFee;
        }

        return (int)result;
    }
    static class InOutRecords{
        String time;
        String carNumber;
        String in_Out;

        public InOutRecords(String t, String carNm, String io){
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
