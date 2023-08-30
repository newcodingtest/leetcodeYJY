import java.io.*;

public class Main {
	static String input;
	//만일 문자열 그 자체로 회문이면 0, 유사회문이면 1, 그 외는 2를 출력해야 한다.
	//한 문자를 삭제하여 회문으로 만들 수 있는 문자열이라면 우리는 이런 문자열을 “유사회문
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int cnt = Integer.parseInt(br.readLine());
		for (int i=0; i<cnt; i++){
			input = br.readLine();
			sb.append(solution(new Node(input,0,input.length()-1))+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int solution(Node n){
		if (isValid(n)){
			return 0;
		}
		if (isValid(new Node(n.str,n.left+1,n.right) )|| isValid(new Node(n.str,n.left,n.right-1))){
			return 1;
		}
		return 2;
	}

	public static boolean isValid(Node n){
		while (n.left<n.right){
			if (input.charAt(n.left)!=input.charAt(n.right)){
				return false;
			}
            n.left++;
            n.right--;
		}
		return true;
	}

	static class Node{
		String str;
		int left;
		int right;
		public Node(String str ,int left, int right){
			this.str = str;
			this.left = left;
			this.right = right;
		}
	}

}