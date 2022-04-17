package 프로그래머스.level1;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 * 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
 * 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 * k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
 * 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 * */
public class 신고결과받기 {
    public static void main(String[] args){

        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k =2;

        System.out.println(solution(idList,report,k));
    }

    //이용자의 ID가 담긴 문자열 배열, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열, 정지 기준이 되는 신고횟수
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length-1];
        List<User> user = new ArrayList<>();
        HashMap<String, Integer> suspendList = new HashMap<>();
        HashMap<String, Integer> idIdx = new HashMap<>();

        int idx = 0;

        //유저 등록
        for (String name:id_list) {
            idIdx.put(name,idx++);
            user.add(new User(name));
        }

        //신고 리스트 등록 신고자-신고 당한자
        for (String re:report) {
            String[] str = re.split(" ");
            user.get(idIdx.get(str[0])).reportList.add(str[1]);
            user.get(idIdx.get(str[1])).reportedList.add(str[0]);
        }

        for (User users:user) {
            if (users.reportedList.size()>=k){
                suspendList.put(users.name,1);
            }
        }

        for (User users:user) {
            for (String nameReport : users.reportedList) {
                if (suspendList.get(nameReport) != null) {
                    answer[idIdx.get(nameReport)]++;
                }
            }
        }

        return answer;
    } //return ex: [2,1,1,0]

    static class User{
        String name;
        HashSet<String> reportList;
        HashSet<String> reportedList;

        public User(String name){
            this.name = name;
            reportList = new HashSet<>();
            reportedList = new HashSet<>();
        }


    }
}
