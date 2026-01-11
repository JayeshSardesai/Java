class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public class Pair{
        int start;
        int end;
        int ind;
        Pair(int start,int end,int ind){
            this.start=start;
            this.end=end;
            this.ind=ind;
        }
    }
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.end-b.end);
        for(int i=0;i<start.length;i++){
            pq.add(new Pair(start[i],end[i],i));
        }
        int cnt=0;
        int endtime=-1;
        while(!pq.isEmpty()){
            Pair item=pq.poll();
            if(endtime<item.start){
                cnt++;
                endtime=item.end;
            }
        }
        return cnt;
    }
}
