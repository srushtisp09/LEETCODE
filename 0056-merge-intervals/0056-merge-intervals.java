class Solution {
    public int[][] merge(int[][] intervals) {
          Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> result=new ArrayList<>();
        int lastStart=intervals[0][0];
        int lastEnd=intervals[0][1];
       
       
        for(int i=1;i<=intervals.length-1;i++){
            if(intervals[i][0]<=lastEnd){
                lastEnd=Math.max(lastEnd,intervals[i][1]);
            }else{
                result.add(new int[]{lastStart,lastEnd});
                lastStart=intervals[i][0];
                lastEnd=intervals[i][1];
            }
        }
         result.add(new int[]{lastStart,lastEnd});
        return result.toArray(new int[0][]);
    }
}