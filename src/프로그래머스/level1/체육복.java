package 프로그래머스.level1;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int result = n;

        for(int l : lost) {
            people[l-1]--;
        }

        for(int l : reserve) {
            people[l-1]++;
        }

        for(int i=0; i<people.length; i++) {
            //체육복을 읽어버린 사람이라면
            if(people[i] == -1) {
                //만약 한칸뒤 또는 한칸 앞사람이 체육복 여분을 갖고있는 사람이라면
                //해당 인덱스는 체육복을 입을수 있는 사람임으로 +1을 하여 -1 -> 0 으로 가게 만든다.
                //빌려준 인덱스는 -1 감소하여  1 -> 0 을 만들어 체육복을 더이상 빌려주지 못한다.
                if(i-1>=0 && people[i-1]==1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1<people.length && people[i+1]==1) {
                    people[i]++;
                    people[i+1]--;
                }
                //위 조건에 만족하지 못한 사람은 결국 체육복을 못입는 사람이기 때문에 전체 인원수에서 감소시킨다.
                else {
                    result--;
                }
            }
        }
        return result;
    }
}
