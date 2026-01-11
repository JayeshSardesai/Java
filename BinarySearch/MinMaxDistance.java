// User function Template for Java

class Solution {
    public static int noStations(int[] stations,double diff){
        int count=0;
        for(int i=1;i<stations.length;i++){
            int nos=(int)((stations[i]-stations[i-1])/diff);
            if((stations[i]-stations[i-1])/diff==nos*diff){
                nos--;
            }
            count+=nos;
        }
        return count;
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        double low=0;
        double high=0;
        for(int i=0;i<stations.length-1;i++){
            high=Math.max(high,(double)stations[i+1]-stations[i]);
        }
        double diff=1e-6;
        while(high-low>diff){
            double mid=(low+high)/2.0;
            int count=noStations(stations,mid);
            if(count>k){
                low=mid;
            }else{
                high=mid;
            }
        }
        return high;
    }
}
