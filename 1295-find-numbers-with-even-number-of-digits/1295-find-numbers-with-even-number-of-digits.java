class Solution {
    public int findNumbers(int[] nums) {
        int len;
        int count=0;
        for(int i=0;i<nums.length;i++){
            len=0;
            int temp=nums[i];
            while(temp!=0){
                len++;
                temp/=10;
            }
            if(len%2==0){
                count++;
            }
        }
        return count;
    }
}