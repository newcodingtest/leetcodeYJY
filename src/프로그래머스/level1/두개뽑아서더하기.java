package 프로그래머스.level1;
import java.util.HashMap;
import java.util.Map;

public class 두개뽑아서더하기 {
    static Map<Integer,Integer> numbers = new HashMap<>();
    public int[] solution(int[] d) {

        for(int i=0; i<d.length; i++) {
            for(int j=i+1; j<d.length; j++) {
                numbers.put(d[i]+d[j], d[i]+d[j]);
            }
        }

        return numbers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .mapToInt(x -> x.getKey().intValue())
                .toArray();

    }
}
