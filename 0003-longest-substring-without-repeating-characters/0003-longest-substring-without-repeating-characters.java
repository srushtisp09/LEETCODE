class Solution {
    public int lengthOfLongestSubstring(String s) {
        int freq[]=new int[128];
        int maxLen=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)]++;
            while(freq[s.charAt(right)]>1){
                freq[s.charAt(left)]--;
                left++;
            } 
                maxLen=Math.max(maxLen,right-left+1);
            
        }
        return maxLen;
    }
}