import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = Integer.parseInt(st.nextToken());
		String target = st.nextToken();
			
		st = new StringTokenizer(br.readLine());	
		int answer = 0;
		for(int i=0; i<cnt; i++){
			String input = st.nextToken();
			if(!input.contains(target)){
				answer++;
			}
		}
		System.out.println(answer);
	}
}