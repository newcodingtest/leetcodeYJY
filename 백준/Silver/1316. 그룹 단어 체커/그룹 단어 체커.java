import java.io.*;
import java.util.Arrays;

public class Main {
	static int[] alpabet;
	// N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int cnt = Integer.parseInt(br.readLine());

		int answer = 0;
		for (int i=0; i<cnt; i++){
			String input = br.readLine();
			if (isGroupWord(input)){
				answer++;
			}
		}
		System.out.println(	answer);
	}

	public static boolean isGroupWord(String str){
		alpabet = new int[26];
		Arrays.fill(alpabet,101);
		for (int i=0; i<str.length(); i++){
			if(alpabet[122-str.charAt(i)]==101){
				alpabet[122-str.charAt(i)]=i;
			}else{
				if (alpabet[122-str.charAt(i)]+1==i){
					alpabet[122-str.charAt(i)]=i;
				}else{
					return false;
				}
			}
		}
		return true;
	}
}
