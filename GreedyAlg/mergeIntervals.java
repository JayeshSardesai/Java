class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> li=new ArrayList<>();
        for(int[] a:arr){
            if(li.isEmpty()||li.get(li.size()-1)[1]<a[0]){
                li.add(a);
            }else{
                li.get(li.size()-1)[1]=Math.max(li.get(li.size()-1)[1],a[1]);
            }
        }
        return li;
    }
}
