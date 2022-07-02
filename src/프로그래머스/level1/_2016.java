package 프로그래머스.level1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class _2016 {
    public static String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016,a,b);
        int weekValue = date.getDayOfWeek().getValue();

        return returnWeek(weekValue);
    }
    /**
     * 요일을 반환하는 함수(1~7, 월~일)
     * */
    public static String returnWeek(int value){
        String dayName = "";
        switch (value){
            case 1:
                dayName = "MON";
            break;
            case 2:
                dayName = "TUE";
                break;
            case 3:
                dayName = "WED";
                break;
            case 4:
                dayName = "THU";
                break;
            case 5:
                dayName = "FRI";
                break;
            case 6:
                dayName = "SAT";
                break;
            case 7:
                dayName = "SUN";
                break;
        }
        return dayName;
    }
}
