class Solution {
    class Item{
        int val;
        int wt;
        double wtg;
        Item(int val,int wt){
            this.val=val;
            this.wt=wt;
            wtg=(double)val/wt;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        PriorityQueue<Item> pq=new PriorityQueue<>((a,b)->Double.compare(b.wtg,a.wtg));
        for(int i=0;i<val.length;i++){
            pq.add(new Item(val[i],wt[i]));
        }
        double res=0.0;
        while(!pq.isEmpty()&&capacity>0){
            Item it=pq.poll();
            if(it.wt<=capacity){
                res=res+it.val;
                capacity-=it.wt;
            }else{
                res+=it.wtg*capacity;
                capacity=0;
            }
        }
        return res;
    }
}
