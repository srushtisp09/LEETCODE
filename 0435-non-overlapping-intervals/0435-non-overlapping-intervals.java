class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
  
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int lastStart=intervals[0][0];
        int lastEnd=intervals[0][1];
        int count=0;
        for(int i=1;i<=intervals.length-1;i++){
            if(intervals[i][0]<lastEnd){
                count++;
                lastEnd=Math.min(lastEnd,intervals[i][1]);
            } else{

                lastStart=intervals[i][0];
                lastEnd=intervals[i][1];
                 
            }

        }
        return count;
    }
}