class Solution
{
 public static int solution(String s) {
		if (s.length()==1){
			return 1;
		}
		for (int len = s.length(); len>0; len--) {
			for (int i=0; i+len<=s.length(); i++){
				if (isPelindrome(i,i+len-1,s)){
					return len;
				}
			}
		}
		return 0;
	}

	public static boolean isPelindrome(int start, int end, String s){
		while (start<=end){
			if (s.charAt(start++)!=s.charAt(end--)){
				return false;
			}
		}
		return true;
	}
}