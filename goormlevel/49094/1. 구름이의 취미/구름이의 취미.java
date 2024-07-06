import java.io.*;
import java.util.*;



class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long input = Integer.parseInt(br.readLine());
		
		long sum = (input*(input+1)/2)%1_000_000_007;
		
		System.out.println((sum*sum)%1_000_000_007);
	}
}