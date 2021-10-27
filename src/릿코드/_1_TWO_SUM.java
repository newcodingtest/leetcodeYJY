package 릿코드;

import java.util.Arrays;

public class _1_TWO_SUM {
    public static int[] twoSum(int[] nums, int target) {
        int[] test = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i!=j){
                    if(nums[i]+nums[j]==target){
                        test[0]=i;
                        test[1]=j;
                        break;
                    }
                }
            }
        }

        return test;
    }

    public static void main(String[] args){

        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
