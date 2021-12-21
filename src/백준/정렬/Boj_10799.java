        package 백준.정렬;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.Stack;
        import java.util.StringTokenizer;

        public class Boj_10799 {
            public static void main(String[] args)throws Exception{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                Stack<String> stack = new Stack<>();

                String input = br.readLine();
                int result = 0;

                for (int i=0; i<input.length(); i++){
                    if(input.charAt(i)=='('){
                        stack.push("(");
                    }

                    if(input.charAt(i)==')'){
                        stack.pop();

                        if(input.charAt(i-1)=='('){
                            result+=stack.size();
                        }else{
                            result++;
                        }
                    }
                }
                System.out.println(result);
            }
        }
