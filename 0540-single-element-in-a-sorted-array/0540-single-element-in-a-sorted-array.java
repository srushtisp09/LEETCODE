class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length;
        int result=0;
 while(start<end){
    result=result^nums[start];
    start++;
 }
 return result;
    }
}