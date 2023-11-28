import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
      static Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");
     public static String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            Matcher m1 = p.matcher(o1.toLowerCase());
            Matcher m2 = p.matcher(o2.toLowerCase());

            m1.find();
            m2.find();

            if(!m1.group(1).equals(m2.group(1))){
                return m1.group(1).compareTo(m2.group(1));
            } else {
              return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
            }
        });
        
        return files;
    }
}