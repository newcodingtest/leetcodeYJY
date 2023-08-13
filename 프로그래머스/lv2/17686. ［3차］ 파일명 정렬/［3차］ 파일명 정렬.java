import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
   static Pattern pattern = Pattern.compile("[0-9]{1,}");
   public static String[] solution(String[] files) {
        List<FileInfo> list = new ArrayList<>();

        for (int i=0; i<files.length; i++){
            String str = files[i];
            Matcher m1 = pattern.matcher(str);
            m1.find();
            String num = m1.group();
            int startIdx = str.indexOf(num);
            String head = str.substring(0,startIdx);
            String number = num;
            String tail = "";
            if(startIdx+num.length()<=str.length()){
                tail = str.substring(startIdx+num.length());
            }
            list.add(new FileInfo(head,number,tail));
        }
        list.sort(Comparator.comparing(FileInfo::getHead).thenComparing(Comparator.naturalOrder()));

        String[] answer = new String[list.size()];
        for (int i=0; i<answer.length; i++){
            answer[i] = list.get(i).toString();
        }
        return answer;
    }


    public static class FileInfo implements Comparable<FileInfo> {
        String head;
        String number;
        String tail;
        public FileInfo(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead(){
            return this.head.toUpperCase();
        }
        @Override
        public String toString() {
            return this.head+this.number+this.tail;
        }

        @Override
        public int compareTo(FileInfo o) {
            return Integer.parseInt(this.number) - Integer.parseInt(o.number);
        }
    }
}