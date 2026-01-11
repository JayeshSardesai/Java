class Solution {
    public int eat(int mid,int[] piles){
        int sum=0;
        for(int i=0;i<piles.length;i++){
            sum+=Math.ceil((double)piles[i]/mid);
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();
        int min=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(eat(mid,piles)<=h){
                min=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return min;
    }
}
