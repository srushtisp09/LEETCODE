class Solution {
    public String reverseWords(String s) {
       String words[]=s.trim().split("\\s+");
       int right=words.length-1;
       int left=0;
       while(left<right){
        String temp=words[left];
        words[left]=words[right];
        words[right]=temp;
        left++;
        right--;
       }
return String.join(" ",words);
            }
}